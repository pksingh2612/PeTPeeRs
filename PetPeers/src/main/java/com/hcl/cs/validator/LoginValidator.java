package com.hcl.cs.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.hcl.cs.model.User;

public class LoginValidator implements Validator {
	@Override
	public boolean supports(Class<?> paramClass) {
        return User.class.equals(paramClass);
    }

    @Override
    public void validate(Object obj, Errors errors) {
    	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName",
                "required.username", "Mandatory Field.");
    	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userPassword",
                "required.password", "Mandatory Field.");
    }
}
