package com.ualbany.digitalnoticeboard.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ualbany.digitalnoticeboard.model.Channel;
import com.ualbany.digitalnoticeboard.model.Group;
import com.ualbany.digitalnoticeboard.model.GroupInvitation;
import com.ualbany.digitalnoticeboard.model.GroupMember;
import com.ualbany.digitalnoticeboard.model.GroupMemberRole;
import com.ualbany.digitalnoticeboard.model.GroupNotice;
import com.ualbany.digitalnoticeboard.model.GroupShortNotice;
import com.ualbany.digitalnoticeboard.model.InivitationStatus;
import com.ualbany.digitalnoticeboard.model.ShortNotice;
import com.ualbany.digitalnoticeboard.model.User;
import com.ualbany.digitalnoticeboard.service.ChannelService;
import com.ualbany.digitalnoticeboard.service.GroupIniviationService;
import com.ualbany.digitalnoticeboard.service.GroupMemberService;
import com.ualbany.digitalnoticeboard.service.GroupNoticeService;
import com.ualbany.digitalnoticeboard.service.GroupService;
import com.ualbany.digitalnoticeboard.service.GroupShortNoticeService;
import com.ualbany.digitalnoticeboard.service.ShortNoticeService;
import com.ualbany.digitalnoticeboard.service.UserService;
import com.ualbany.digitalnoticeboard.validator.InviteValidator;

@Controller
public class GroupController extends BaseController{

	@Autowired
	GroupService groupService;
	
	@Autowired
	GroupNoticeService noticeService;
	
	@Autowired
	GroupShortNoticeService shortnoticeService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private GroupMemberService groupmemberService;
	
	@Autowired
	private GroupIniviationService inivitationService; 
	
	@Autowired
	ChannelService channelService;
	
	@Autowired
	ShortNoticeService shortNoticeService;
	
   @Autowired
    private InviteValidator validator;
	
	@GetMapping(value = "/{username}/newGroup")
    public ModelAndView groupAddGet(@PathVariable final String username, @ModelAttribute("groupForm") Group groupForm, BindingResult bindingResult,  Model model) {
		User user = userService.findByUsername(username);
	    ModelAndView mv = new ModelAndView("addgroup");
        mv.addObject("user", user);
        return mv;
    }
	 
	@PostMapping("/{username}/newGroup")
    public ModelAndView groupAddPut(@PathVariable final String username, @ModelAttribute("groupForm") Group groupForm, BindingResult bindingResult, Model model) {
		User user = userService.findByUsername(username);
		setpersistableproperties(groupForm, user);
		GroupMember member = new GroupMember();
		setpersistableproperties(member, user);
		member.setRole(GroupMemberRole.ADMIN);
		member.setUser(user);
		member.setGroup(groupForm);
		List<GroupMember> members = groupForm.getMembers();
		members.add(member);
		groupForm.setMembers(members);
		groupService.save(groupForm);
		member.setGroup(groupForm);
		groupmemberService.save(member);
		ModelAndView mv = showGroupPage(groupForm.getId(), user);
        return mv;
    }

	@GetMapping(value = "/{username}/group/{grpId}")
    public ModelAndView groupHomeGet(@PathVariable final String username, @PathVariable final Long grpId,  Model model) {
		User user = userService.findByUsername(username);
	    ModelAndView mv = showGroupPage(grpId, user);
        return mv;
    }
	
	@GetMapping(value = "/{username}/{grpId}/addNotice")
    public ModelAndView addNoticeGetRequest(@PathVariable final String username,@PathVariable final Long grpId, @ModelAttribute("noticeForm") GroupNotice noticeForm, BindingResult bindingResult, Model model) {
		User user = userService.findByUsername(username);
		Group group = groupService.getById(grpId).get();
	    ModelAndView mv = new ModelAndView("addgrpnotice");
        mv.addObject("user", user);
        mv.addObject("group", group);
        return mv;
    }
	 
	@PostMapping("/{username}/{grpId}/addNotice")
    public ModelAndView addNoticePutRequest(@PathVariable final String username, @PathVariable final Long grpId, @ModelAttribute("groupnoticeForm") GroupNotice noticeForm, BindingResult bindingResult, Model model) {
		User user = userService.findByUsername(username);
		setpersistableproperties(noticeForm, user);
		noticeForm.setGroup(groupService.getById(grpId).get());
        noticeService.save(noticeForm);
        
        ModelAndView mv = showGroupPage(grpId, user);
        return mv;
    }

	private ModelAndView showGroupPage(final Long grpId, User user) {
		Group group = groupService.getById(grpId).get();
		List<Group> groups = groupService.getUserGroups(user);
	    ModelAndView mv = new ModelAndView("grouphome");
        mv.addObject("user", user);
        mv.addObject("groups", groups);
    	mv.addObject("curgrp", group);
		return mv;
	}
	
	@GetMapping("/{username}/{grpId}/deletenotice/{id}")
    public ModelAndView deleteNoticesById(@PathVariable final String username, @PathVariable final Long grpId, @PathVariable final Long id, Model model) {
		User user = userService.findByUsername(username);
        noticeService.deleteNoticeById(id);
        return showGroupPage(grpId, user);
    }
	
	@GetMapping(value = "/{username}/{grpId}/addShortNotice")
    public ModelAndView addShortNoticeGetRequest(@PathVariable final String username,@PathVariable final Long grpId, @ModelAttribute("shortNoticeForm") GroupShortNotice noticeForm, BindingResult bindingResult, Model model) {
		User user = userService.findByUsername(username);
		Group group = groupService.getById(grpId).get();
		List<Group> groups = groupService.getUserGroups(user);
	    ModelAndView mv = new ModelAndView("addgrpshortnotice");
	    mv.addObject("user", user);
        mv.addObject("groups", groups);
    	mv.addObject("group", group);
        return mv;
    }
	 
	@PostMapping("/{username}/{grpId}/addShortNotice")
    public ModelAndView addShortNoticePutRequest(@PathVariable final String username,@PathVariable final Long grpId, @ModelAttribute("shortNoticeForm") GroupShortNotice noticeForm, BindingResult bindingResult, Model model) {
		User user = userService.findByUsername(username);
		
		SimpleDateFormat sdf =new SimpleDateFormat("HH:mm");
		try {
			Date date = sdf.parse(noticeForm.getExpirationTime());
			Calendar cal = Calendar.getInstance();
			Date now = cal.getTime();
			cal.setTime(date);
	    	int hh = cal.get(Calendar.HOUR_OF_DAY);
	    	int mm = cal.get(Calendar.MINUTE);
	    	int ss = cal.get(Calendar.SECOND);
	    	cal.setTime(now);
	        cal.set(Calendar.HOUR_OF_DAY, hh);
	        cal.set(Calendar.MINUTE, mm);
	        cal.set(Calendar.SECOND, ss);
			noticeForm.setExpirationDate(cal.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setpersistableproperties(noticeForm, user);
		noticeForm.setGroup(groupService.getById(grpId).get());
		shortnoticeService.save(noticeForm);
        return showGroupPage(grpId, user);
    }
	
	@GetMapping("/{username}/{grpId}/deleteshortnotice/{id}")
	public ModelAndView deleteShortNoteById(@PathVariable final String username,@PathVariable final Long grpId, @PathVariable final Long id,
			Model model) {
		User user = userService.findByUsername(username);
		shortnoticeService.deleteShortNoticeById(id);
		return showGroupPage(grpId, user);
	}
	
	@GetMapping("/{username}/{grpId}/invite")
	public ModelAndView inviteMemberGet(@PathVariable final String username, @PathVariable final Long grpId, 
			@ModelAttribute("userForm") User userForm, 
			BindingResult bindingResult, 
			Model model) {
		User user = userService.findByUsername(username);
		ModelAndView mv = new ModelAndView("invitemember");
	    mv.addObject("user", user);
	    Group group = groupService.getById(grpId).get();
	    mv.addObject("group", group);
		return mv;
	}
	
	@PostMapping("/{username}/{grpId}/invite")
	public ModelAndView inviteMemberPut(@PathVariable final String username, @PathVariable final Long grpId, 
			@ModelAttribute("userForm") User recieverForm, BindingResult bindingResult,Model model) {
		validator.validate(recieverForm, bindingResult);
    	if (bindingResult.hasErrors()) {
            return new ModelAndView("invitemember");
        }
		User user = userService.findByUsername(username);
		GroupInvitation invite = new GroupInvitation();
		setpersistableproperties(invite, user);
		invite.setSender(user);
		User reciever = userService.findByEmail(recieverForm.getEmail());
		invite.setReceiver(reciever);
		Group group = groupService.getById(grpId).get();
		invite.setGroup(group);
		invite.setInivitationStatus(InivitationStatus.PENDING);
		
		inivitationService.save(invite);
		return showGroupPage(grpId, user);
	}
	
	@GetMapping("/{username}/pendinginvite")
	public ModelAndView pendingInviteGet(@PathVariable final String username, 
			@ModelAttribute("inviteForm") GroupInvitation inivitationForm, 
			BindingResult bindingResult, 
			Model model) {
		User user = userService.findByUsername(username);
		return showIniviationsPage(user);
	}
	
	private ModelAndView showIniviationsPage( User user) {
		ModelAndView mv = new ModelAndView("invities");
	    mv.addObject("user", user);
	    List<GroupInvitation> recieved = inivitationService.getUserRecivedInvites(user, InivitationStatus.PENDING);
	    List<GroupInvitation> sent = inivitationService.getUserSentInvites(user, InivitationStatus.PENDING);
	    mv.addObject("recieved", recieved);
	    mv.addObject("sent", sent);
	    return mv;
	}

	@GetMapping("/{username}/invite/{grpId}/{id}/accept")
	public ModelAndView acceptInviteGet(@PathVariable final String username, @PathVariable final Long grpId, 
			@PathVariable final Long id, 
			Model model) {
		User user = userService.findByUsername(username);
		GroupInvitation invite = inivitationService.getById(id).get();
		Group group = groupService.getById(grpId).get();
		List<GroupMember> members = group.getMembers();
		GroupMember member = new GroupMember();
		member.setUser(user);
		member.setGroup(group);
		member.setRole(GroupMemberRole.MEMBER);
		setpersistableproperties(member, user);
		groupmemberService.save(member);
		members.add(member);
		group.setMembers(members);
		groupService.save(group);
		
		invite.setInivitationStatus(InivitationStatus.ACCEPTED);
		inivitationService.save(invite);
		
		return showIniviationsPage(user);
	}
	
	@GetMapping("/{username}/invite/{grpId}/{id}/decline")
	public ModelAndView declineInviteGet(@PathVariable final String username, @PathVariable final Long grpId, 
			@PathVariable final Long id, 
			Model model) {
		User user = userService.findByUsername(username);
		GroupInvitation invite = inivitationService.getById(id).get();
		invite.setInivitationStatus(InivitationStatus.DECLINED);
		invite.setUpdatedBy(user);
		Date now = new Date();
		invite.setUpdatedAt(now);
		inivitationService.save(invite);
		return showIniviationsPage(user);
	}
	
	@GetMapping("/{username}/{grpId}/exit")
	public ModelAndView exitGroup(@PathVariable final String username, @PathVariable final Long grpId, 
			Model model) {
		User user = userService.findByUsername(username);
		Group group = groupService.getById(grpId).get();
		Optional<GroupMember> member = groupmemberService.getMemberByUserAndGroup(user, group);
		groupmemberService.deletemember(member);
		
		ModelAndView mv = new ModelAndView("userhome");
		mv.addObject("user", user);
        List<Channel> channels = channelService.getChannelsWithValidNotices();
        mv.addObject("Channels", channels);
        List<ShortNotice> shortnotices = shortNoticeService.getAllActiveNotices();
        Collections.sort(shortnotices, (o1, o2) -> o1.getExpirationDate().compareTo(o2.getExpirationDate()));
        
        mv.addObject("ShortNotices", shortnotices);
        List<Group> groups = groupService.getUserGroups(user);
    	mv.addObject("groups", groups);
        return mv;
	}
}
