package com.cognizant.processpensionmodule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.processpensionmodule.exception.PensionerNotFoundException;
import com.cognizant.processpensionmodule.model.ProcessPensionInput;
import com.cognizant.processpensionmodule.restclients.PensionDisbursementClient;

@Service
public class PensionDisbursementService {
	
	@Autowired
	private PensionDisbursementClient pensionDisbursementClient;

	public Integer getDisbursementCode(ProcessPensionInput processPensionInput)throws PensionerNotFoundException {
		return pensionDisbursementClient.getPensionDisbursement(processPensionInput);
	}
		
	
	
	
}
