package com.pensiondisbursement.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pensiondisbursement.model.ProcessPensionInput;
import com.pensiondisbursement.service.PensionDisbursementService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class PensionDisbursementController {
	@Autowired
	private PensionDisbursementService pensionDisbursementService;

//	@PostMapping(value = "/disbursepension")
//	public Integer getPensionDisbursement(@RequestBody ProcessPensionInput pensionDetails) {
//		Optional<String> serviceResponse = pensionDisbursementService.getPensionDisbursement(pensionDetails);
//		if (serviceResponse.isPresent()) {
//			return ResponseEntity.ok("Pension is disbursed for aadhar:" + pensionDetails.getAadhar());
//		}
//		return ResponseEntity.status(HttpStatus.NO_CONTENT)
//				.body("Pension is not disbursed for aadhar:" + pensionDetails.getAadhar());
//
//	}

}
