package com.pensiondisbursement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pensiondisbursement.exception.PensionerNotFoundException;
import com.pensiondisbursement.model.PensionerDetail;
import com.pensiondisbursement.model.ProcessPensionInput;
import com.pensiondisbursement.restclients.PensionerDetailClient;

@Service
public class PensionDisbursementService {
	
	@Autowired
	private PensionerDetailClient pensionerDetailClient;

	public Integer getPensionDisbursement(ProcessPensionInput processPensionInput) throws PensionerNotFoundException {
		PensionerDetail pensionDetail=getPensionDetail(processPensionInput.getAadharNumber());
		String bankType=pensionDetail.getBankType();
		Double bankCharge=processPensionInput.getBankCharge();
		switch(bankType) {
			case "Private":
				if(bankCharge==550)
					return 10;//Pension disbursement Success  	
				else if(bankCharge<550)
					return 20;//Bank service charge not paid 
					return 21;
			case "Public":
				if(bankCharge==500)
					return 10;//Pension disbursement Success  	
				else if(bankCharge<500)
					return 20;//Bank service charge not paid 
					return 21;
			default :
				return 21;
		}
	}
	
	public PensionerDetail getPensionDetail(Long aadharNumber) throws PensionerNotFoundException {
		return pensionerDetailClient.getPensionerDetails(aadharNumber);
		}
}
