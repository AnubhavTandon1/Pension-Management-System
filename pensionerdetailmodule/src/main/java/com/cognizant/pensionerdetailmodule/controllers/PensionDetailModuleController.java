package com.cognizant.pensionerdetailmodule.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.pensionerdetailmodule.exception.PensionerNotFoundException;
import com.cognizant.pensionerdetailmodule.models.PensionerDetail;
import com.cognizant.pensionerdetailmodule.service.PensionDetailService;

@RestController
public class PensionDetailModuleController {
	
	@Autowired
	private PensionDetailService pensionDetailService;
	
	@GetMapping("/pensionerdetailbyaadhaar/{aadharNumber}")
	public PensionerDetail getPensionerDetail(@PathVariable Long aadharNumber) throws PensionerNotFoundException
	{
		return pensionDetailService.getPensionerDetail(aadharNumber);
	}
}
