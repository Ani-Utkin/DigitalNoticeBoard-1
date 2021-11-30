<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta property="og:url"           content="https://blackboard.albany.edu" />
<meta property="og:type"          content="website" />
<meta property="og:title"         content="Digital notice board" />
<meta property="og:description"   content="Check on new notice!" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>
<link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick-theme.css"/>
<link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
<link href="${contextPath}/resources/css/style.css" rel="stylesheet">
<link href="${contextPath}/resources/css/common.css" rel="stylesheet">
<link href="${contextPath}/resources/css/home.css" rel="stylesheet">
<link href="${contextPath}/resources/css/lightbox.css" rel="stylesheet">
</head>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
 <!-- <a class="navbar-brand" href="#">
    <img src="${contextPath}/resources/img/icon.png" width="30" height="30" alt="">
  </a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>-->

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
        <a class="nav-link" href="${contextPath}/${user.username}/userhome">Public</a>
      </li>
      <c:forEach var="grp" items="${groups}">
      <li class="nav-item">
        <a class="nav-link" href="${contextPath}/${user.username}/group/${grp.id}">${grp.name}</a>
      </li>
      </c:forEach>
    </ul>
    <div class="fb-share-button" data-href="https://blackboard.albany.edu" data-layout="button"></div>
    <div class="dropdown">
	  <a class="btn btn-secondary dropdown-toggle" href="1" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		${user.username} 
	  </a>
	  <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
		<a class="dropdown-item" href="${contextPath}/${user.username}/profile">Profile</a>
		<a class="dropdown-item" href="${contextPath}/${user.username}/${curgrp.id}/addNotice">Add Notice</a>
		<a class="dropdown-item" href="${contextPath}/${user.username}/${curgrp.id}/addShortNotice">Add Short Notice</a>
		<a class="dropdown-item" href="${contextPath}/${user.username}/${curgrp.id}/invite">Invite Member</a>
		<a class="dropdown-item" href="${contextPath}/${user.username}/pendinginvite">Current Invitations</a>
		<a class="dropdown-item" href="${contextPath}/${user.username}/${curgrp.id}/exit">Exit Group</a>
		<a class="dropdown-item" href="${contextPath}/signout">SignOut</a>
	  </div>
	</div>
  </div>
</nav>
<body>
	<div class="maincontent">
	<section id="">
		<div class="item row">
            <div class="col-sm-9">
            <div class="group">
          	 <c:forEach var="note" items="${curgrp.notices}">
          	    <div class="notice">
          	     <div class="notice-header">
          	      <h3 class="notice-title">${note.title}</h3>
          	     </div>
          	     <div class=notice-body>
          	      <p class=notice-summary>${note.summary}</p>
          	      <p class=notice-expirationtime><strong>Created Date :</strong><fmt:formatDate value="${note.createdAt}" pattern="yyyy-MM-dd" /></p>
          	      <p class=notice-expirationtime><strong>Expire Date :</strong><fmt:formatDate value="${note.expirationDate}" pattern="yyyy-MM-dd" /></p>
                 </div>
                 <button  class="btn btn-primary" onclick="openLightBox(); 
						       showNoticeTitle('${note.title}'); 
						       showNoticeSummary('${note.summary}');" style="width:60px; height:30px">View</button>
          	    </div>
          	    </c:forEach>
            </div>
	    	</div>
             <div class="col-sm-3 shortnoticeHeight">
              <div class="short-notice-slider">
               <h2>Short Notices</h2>
               <c:forEach var="shnote" items="${curgrp.shortNotices}"> 
                 <div class="shortnotice">
            		<p>${shnote.details}</p>
            		<p>Expired by: <fmt:formatDate value="${shnote.expirationDate}" type="time" pattern="HH:mm" /></p>
            	   </div>
               </c:forEach>
             </div>
            </div>  
		</div>

    <div id="Lightbox" class="modal">
      <div class="modal-dialog">
        <div class="modal-content">
      <div class="modal-header">
        <h3 id="lightbox-notice-title" class="modal-title">${note.title}</h3>
        <span type="button" class="model-close pointer"  onclick="closeLightBox()" aria-label="Close">X</span>
      </div>
      <div class="modal-body">
       <p id="lightbox-notice-summary" class=notice-summary>${note.summary}</p>
      <!--<button class=sharebutton onclick="share('${note.title}', '${note.summary}')" style="width:60px; height:30px">share</button> --> 
      </div>
    </div>
    </div>
    </div>

        <div class="item row">
        	<h2>Members</h2>
        	<c:forEach var="member" items="${curgrp.members}"> 
        	   <div class="col-sm-3">
                 <div class="shortnotice">
            		<p>${member.user.email}</p>
            		<p>${member.role}</p>
            	   </div>
            	</div>   
             </c:forEach>
        </div>
    </section>
    </div>
    <script type="text/javascript" src="${contextPath}/resources/js/lightbox.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script type="text/javascript" src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
</body>
</html>
