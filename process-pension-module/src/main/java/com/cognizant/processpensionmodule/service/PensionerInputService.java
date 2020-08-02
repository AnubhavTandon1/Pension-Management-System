package com.cognizant.processpensionmodule.service;

import org.springframework.stereotype.Service;
import com.cognizant.processpensionmodule.model.PensionerInput;

@Service
public class PensionerInputService {
	
	public double calculatePensionAmount(double salary,double allowances,PensionerInput pensionerInput) {
		if(pensionerInput.isSelfPension())
			return 0.8*salary+allowances;
		else
			return 0.5*salary+allowances;
	}

}
