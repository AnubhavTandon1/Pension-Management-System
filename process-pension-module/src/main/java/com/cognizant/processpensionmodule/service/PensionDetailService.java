package com.cognizant.processpensionmodule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cognizant.processpensionmodule.exception.PensionerNotFoundException;
import com.cognizant.processpensionmodule.model.PensionDetail;
import com.cognizant.processpensionmodule.model.PensionerInput;
import com.cognizant.processpensionmodule.modeldto.PensionerDetail;
import com.cognizant.processpensionmodule.restclients.PensionerDetailClient;

@Service
public class PensionDetailService {
	
	@Autowired
	private PensionerDetailClient pensionerDetailClient;
	
	public double calculatePensionAmount(double salary,double allowances,PensionerInput pensionerInput) {
		if(pensionerInput.isSelfPension())
			return 0.8*salary+allowances;
		else
			return 0.5*salary+allowances;
	}
	
	public PensionDetail getPensionDetail(PensionerInput pensionerInput) throws PensionerNotFoundException
	{
			PensionerDetail pensionerDetail=getPensionDetail(pensionerInput.getAadharNumber());
			double pensionAmount=calculatePensionAmount(pensionerDetail.getSalaryEarned(),pensionerDetail.getAllowances(), pensionerInput);
			PensionDetail pensionDetail=new PensionDetail(pensionerDetail.getName(), pensionerDetail.getDateOfBirth(), pensionerDetail.getPan(), pensionerDetail.isSelfPension(),pensionerDetail.isFamilyPension(),pensionAmount);
		return pensionDetail;
	}
	
	public PensionerDetail getPensionDetail(Long aadharNumber) throws PensionerNotFoundException {
		return pensionerDetailClient.getPensionerDetails(aadharNumber);
			
	}
}
