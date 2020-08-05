package com.pensiondisbursement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.pensiondisbursement.exception.TokenInvalidException;
import com.pensiondisbursement.model.ProcessPensionInput;
import com.pensiondisbursement.service.PensionDisbursementService;

@RestController
public class PensionDisbursementController {
	@Autowired
	private PensionDisbursementService pensionDisbursementService;

	@PostMapping("/disbursepension")
	public Integer getPensionDisbursement(@RequestHeader("Authorization") String token,
			@RequestBody ProcessPensionInput processPensionInput) throws TokenInvalidException {
		return pensionDisbursementService.getPensionDisbursement(token, processPensionInput);
	}

}
