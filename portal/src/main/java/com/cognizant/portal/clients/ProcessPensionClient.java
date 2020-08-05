package com.cognizant.portal.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.portal.exception.TokenInvalidException;
import com.cognizant.portal.model.PensionDetail;
import com.cognizant.portal.model.PensionerInput;
import com.cognizant.portal.model.ProcessPensionInput;

@FeignClient(name = "process-pension", url = "http://localhost:8081")
public interface ProcessPensionClient {
	
	@PostMapping("/pensiondetail")
	public PensionDetail getPensionDetail(@RequestHeader("Authorization") String token,
			@RequestBody PensionerInput pensionerInput) throws TokenInvalidException;

	@PostMapping("/pensionprocess")
	public Integer getDisbursementCode(@RequestHeader("Authorization") String token,
			@RequestBody ProcessPensionInput processPensionInput);

}
