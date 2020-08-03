package com.cognizant.processpensionmodule.restclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cognizant.processpensionmodule.exception.PensionerNotFoundException;
import com.cognizant.processpensionmodule.model.ProcessPensionInput;

@FeignClient(name="pension-disbursement-service", url="http://localhost:8083")
public interface PensionDisbursementClient {
	
	@PostMapping(value = "/disbursepension")
	public Integer getPensionDisbursement(@RequestBody ProcessPensionInput processPensionInput) throws PensionerNotFoundException;
}
