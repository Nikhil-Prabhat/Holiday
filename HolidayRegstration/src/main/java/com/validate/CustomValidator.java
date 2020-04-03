package com.validate;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.model.RegistrationBean;
import java.lang.*;

@Component
public class CustomValidator implements Validator {

	public void validate(Object arg0, Errors arg1) {
		ValidationUtils.rejectIfEmpty(arg1, "userName", "register.username.empty");
		ValidationUtils.rejectIfEmpty(arg1, "contactNumber", "register.contactnumber.empty");
		ValidationUtils.rejectIfEmpty(arg1, "emailId", "register.emailid.empty");
		ValidationUtils.rejectIfEmpty(arg1, "confirmEmailId", "register.confirmemail.empty");
		ValidationUtils.rejectIfEmpty(arg1, "status", "register.status.empty");

		RegistrationBean model = (RegistrationBean) arg0;

		if (!model.isStatus()) {
			arg1.rejectValue("status", "register.status.empty");
		}

		if (!(model.getEmailId().equals(model.getConfirmEmailId()))) {
			arg1.rejectValue("emailId", "register.emailid.empty");
			arg1.rejectValue("confirmEmailId", "register.confirmemail.empty");
		}

		if (!(String.valueOf(model.getContactNumber()).length() == 10)) {
			arg1.rejectValue("contactNumber", "register.contactnumber.empty");
		}

	}

	public boolean supports(Class<?> arg0) {
		return RegistrationBean.class.equals(arg0);
	}

}
