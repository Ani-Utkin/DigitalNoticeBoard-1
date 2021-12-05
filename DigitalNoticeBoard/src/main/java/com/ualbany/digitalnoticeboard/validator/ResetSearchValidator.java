package com.ualbany.digitalnoticeboard.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ualbany.digitalnoticeboard.model.User;

@Component
public class ResetSearchValidator implements Validator {

	@Override
	public boolean supports(Class<?> aClass) {
		return User.class.equals(aClass);
	}

	@Override
	public void validate(Object o, Errors errors) {
		User user = (User) o;
		
		if (user.getUsername().isBlank() && user.getEmail().isBlank()) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "MinimumSearchCriteria");
		} else if (user.getUsername().isBlank() && (!user.getEmail().isBlank()) && (!user.getEmail().endsWith("@albany.edu"))) {
			errors.rejectValue("email", "NotvalidEmail.userFrom.email");
		}
	}
}
