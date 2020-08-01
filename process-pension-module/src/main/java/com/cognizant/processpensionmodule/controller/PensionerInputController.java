package com.cognizant.processpensionmodule.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.processpensionmodule.exception.PensionerInputNotFoundException;
import com.cognizant.processpensionmodule.model.PensionerInput;
import com.cognizant.processpensionmodule.service.PensionerInputService;

@RestController
public class PensionerInputController {
	@Autowired
	PensionerInputService pensionerInputService;
	
	private static final Logger log = LoggerFactory.getLogger(PensionerInputController.class);
	
	@GetMapping("/pensiondetail")
	public void showPensionerDetails(@RequestBody PensionerInput pin) {
		log.info("================Start Get end Point of PensionerInput=====================");
		pensionerInputService.calculatePensionAmount(pin);
		log.info("================End Get end Point of PensionerInput=======================");
	}
}
