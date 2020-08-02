package com.cognizant.processpensionmodule.restclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.cognizant.processpensionmodule.modeldto.PensionerDetail;

@FeignClient("pensionerdetailmodule-service")
public interface PensionerDetailClient {
	@GetMapping("/pensionerdetailbyaadhaar/{aadharNumber}")
	PensionerDetail getPensionerDetails(@PathVariable("aadharNumber") String aadharNumber); //check with other micro

}
