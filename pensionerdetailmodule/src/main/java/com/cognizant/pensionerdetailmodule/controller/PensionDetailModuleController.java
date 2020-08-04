package com.cognizant.pensionerdetailmodule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.pensionerdetailmodule.exception.PensionerNotFoundException;
import com.cognizant.pensionerdetailmodule.exception.TokenInvalidException;
import com.cognizant.pensionerdetailmodule.models.PensionerDetail;
import com.cognizant.pensionerdetailmodule.service.PensionDetailService;

@RestController
public class PensionDetailModuleController {
	
	@Autowired
	private PensionDetailService pensionDetailService;
	
	/**
	 * REST end point 
	 * GET the PensionerDetial using aadharNumber
	 */
	@GetMapping("/pensionerdetail/{aadharNumber}")
	public PensionerDetail getPensionerDetail(@RequestHeader("Authorization") String token,@PathVariable Long aadharNumber) throws PensionerNotFoundException,TokenInvalidException 
	{
		return pensionDetailService.getPensionerDetail(token, aadharNumber);
	}
}
