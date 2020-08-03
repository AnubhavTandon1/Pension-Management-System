package com.cognizant.pensionerdetailmodule.restclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import com.cognizant.pensionerdetailmodule.exception.TokenInvalidException;

@FeignClient(name = "authorization-service", url = "http://localhost:8084")
public interface AuthorizationServiceClient {

	@PostMapping("/auth/validate")
	public boolean validateAndReturnUser(@RequestHeader("Authorization") String token) throws TokenInvalidException;

}