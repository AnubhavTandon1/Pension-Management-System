package com.cognizant.processpensionmodule.restclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.processpensionmodule.exception.PensionerNotFoundException;
import com.cognizant.processpensionmodule.modeldto.PensionerDetail;

@FeignClient(name = "pensionerdetailmodule-service", url = "http://localhost:8082")
public interface PensionerDetailClient {

	@GetMapping("/pensionerdetailbyaadhaar/{aadharNumber}")
	PensionerDetail getPensionerDetails(@RequestHeader("Authorization") String token,
			@PathVariable("aadharNumber") Long aadharNumber) throws PensionerNotFoundException; // check with other
																								// micro

}
