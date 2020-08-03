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

	public Integer getPensionDisbursement(String token,ProcessPensionInput processPensionInput) throws PensionerNotFoundException {
		PensionerDetail pensionDetail=getPensionDetail(token,processPensionInput.getAadharNumber());
		String bankType=pensionDetail.getBankType();
		Double bankCharge=processPensionInput.getBankCharge();
		
		
		switch(bankType) {
			case "Private":
				if(bankCharge==550)
					return 10;//Pension disbursement Success  	
				else if(bankCharge==0)
					return 20;//Bank service charge not paid now it should pe paid
					break;
			case "Public":
				if(bankCharge==500)
					return 10;//Pension disbursement Success  	
				else if(bankCharge==0)
					return 20;//Bank service charge not paid 
				break;	
			default :
				return 21;//Bank service charge less or greater than required
		}
		return 21;
	}
	
	public PensionerDetail getPensionDetail(String token,Long aadharNumber) throws PensionerNotFoundException {
		return pensionerDetailClient.getPensionerDetails(token,aadharNumber);
		}
}
