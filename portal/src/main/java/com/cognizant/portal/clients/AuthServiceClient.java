package com.cognizant.portal.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.portal.exception.TokenInvalidException;
import com.cognizant.portal.model.JwtResponse;
import com.cognizant.portal.model.Login;

@FeignClient(name = "authorization-service", url = "http://localhost:8084")
public interface AuthServiceClient {

	@PostMapping("/auth/signin")
	ResponseEntity<JwtResponse> authenticateUserAndGetDetails(@RequestBody Login login);

	@PostMapping("/auth/validate")
	public boolean validateToken(@RequestHeader("Authorization") String token)throws TokenInvalidException;

}