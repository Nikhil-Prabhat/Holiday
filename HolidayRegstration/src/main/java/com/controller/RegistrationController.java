package com.controller;

import com.model.*;
import com.validate.CustomValidator;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegistrationController {

	@Autowired
	private CustomValidator customvalidator;

	public CustomValidator getCustomvalidator() {
		return customvalidator;
	}

	public void setCustomvalidator(CustomValidator customvalidator) {
		this.customvalidator = customvalidator;
	}

	@InitBinder
	public void initbinder(WebDataBinder web) {
		web.addValidators(customvalidator);
	}

	@RequestMapping(value = "registerPage", method = RequestMethod.GET)
	public String registerPage(@ModelAttribute("register") RegistrationBean bean, BindingResult result) {
		return "registrationpage";
	}

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String performRegistration(@ModelAttribute("register") @Valid RegistrationBean registrationBean,
			BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "registrationpage";
		} else {
			return "thankyou";
		}

	}

}
