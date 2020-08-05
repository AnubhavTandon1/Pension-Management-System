package com.cognizant.portal.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cognizant.portal.model.Login;
import com.cognizant.portal.model.PensionerInput;
import com.cognizant.portal.service.PortalService;

@SessionAttributes("login")
@Controller
public class LoginController {

	@Autowired
	private PortalService portalService;



	@GetMapping("/login")
	public String displayLoginPage(Model model, Login login) {
		model.addAttribute("login", login);
		return "login";
	}
//	
//	@GetMapping("/login")
//	public String loginPage() {
//		return "login";
//	}

	@RequestMapping(value="/login",method=RequestMethod.POST )
	public String parseLoginPage(@Valid @ModelAttribute("pensionerInput") PensionerInput pensionerInput ,@ModelAttribute("login") Login login) {
		return portalService.getPensionerPage(pensionerInput,login);

	}
}
