package com.ualbany.digitalnoticeboard.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ualbany.digitalnoticeboard.model.User;
import com.ualbany.digitalnoticeboard.service.UserService;

@Component
public class SignInValidator implements Validator {
    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        User usr = userService.findByUsername(user.getUsername());
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if(usr == null){
            errors.rejectValue("username", "Invalid.userForm.username");
        } 
        else {
        	if(!usr.getIsActive()) 
        		errors.rejectValue("username", "Inactive.userForm.username");
        	else if (!usr.getPasswordConfirm().equals(user.getPassword())) {
                errors.rejectValue("password", "Invalid.userForm.password");
            }
        }
    }
}
