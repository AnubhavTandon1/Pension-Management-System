package com.cognizant.processpensionmodule.service;

import org.springframework.stereotype.Service;
import com.cognizant.processpensionmodule.model.PensionerInput;

@Service
public class PensionerInputService {
	
	public double calculatePensionAmount(PensionerInput pensionerInput) {
		if(pensionerInput.isSelfPension())
			return 0.8*0.0;
		else
			return 0.5*0.0;
	}

}
