package com.pensiondisbursement.restclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.pensiondisbursement.modeldto.PensionerBankDetails;

//This class is similar to REQ2 controller without implementation(It points to REQ2 service)
//"pensioner-details","localhost:8082" is REQ2 service name and url respectively
@FeignClient(name = "pensionerdetailmodule-service", url = "localhost:8082")

public interface PensionerDetailsClient {

	// This method is REQ2 controllers method to get PensionerBankDetails
	@PostMapping(value = "/pensionerDetails")
	public PensionerBankDetails getPensionerBankDetails(Long aadhar);

}
