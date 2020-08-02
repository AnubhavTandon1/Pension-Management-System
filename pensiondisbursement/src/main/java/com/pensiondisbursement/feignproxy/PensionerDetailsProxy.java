package com.pensiondisbursement.feignproxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.pensiondisbursement.dto.PensionerBankDetails;

//This class is similar to REQ2 controller without implementation(It points to REQ2 service)
//"pensioner-details","localhost:8082" is REQ2 service name and url respectively
@FeignClient(name = "pensioner-details", url = "localhost:8082")

public interface PensionerDetailsProxy {

	// This method is REQ2 controllers method to get PensionerBankDetails
	@PostMapping(value = "/pensionerDetails")
	public PensionerBankDetails getPensionerBankDetails(Long aadhar);

}
