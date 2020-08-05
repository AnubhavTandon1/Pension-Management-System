package com.cognizant.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cognizant.portal.model.Login;
import com.cognizant.portal.model.PensionerInput;
import com.cognizant.portal.model.ProcessPensionInput;
import com.cognizant.portal.service.PortalService;

@Controller
public class PensionProcessController {

	@Autowired
	private PortalService pensionProcessService;

	@PostMapping("/submitinfo")
	public String submitPensionerInfo(@ModelAttribute("pensionerInput") PensionerInput pensionerInput,Model model) {
		return pensionProcessService.submitPensionInput(pensionerInput,model);

	}
	
	@GetMapping("/disburse")
	public String processPensionInput(Model model,ProcessPensionInput processPensionInput) {
		model.addAttribute("processPensionInput",processPensionInput);
		return "disburseForm";
	}
	
	@PostMapping("/disburse")
	public String disburseProcess(@ModelAttribute("processPensionInput") ProcessPensionInput processPensionInput) {
		return pensionProcessService.disburseProcess(processPensionInput);
	}

}
