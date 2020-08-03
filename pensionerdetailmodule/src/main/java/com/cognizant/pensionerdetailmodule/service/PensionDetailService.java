package com.cognizant.pensionerdetailmodule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.pensionerdetailmodule.dao.PensionDetailDaoImpl;
import com.cognizant.pensionerdetailmodule.exception.PensionerNotFoundException;
import com.cognizant.pensionerdetailmodule.exception.TokenInvalidException;
import com.cognizant.pensionerdetailmodule.models.PensionerDetail;
import com.cognizant.pensionerdetailmodule.restclients.AuthorizationServiceClient;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PensionDetailService {
	
	@Autowired
	private PensionDetailDaoImpl pensionDetailDaoImpl;
	
	@Autowired
	private AuthorizationServiceClient authClient;
	
	public PensionerDetail getPensionerDetail(String token,Long aadharNumber) throws PensionerNotFoundException, TokenInvalidException {
			
		boolean response=authClient.validateAndReturnUser(token);
		if(response)
		return pensionDetailDaoImpl.getPensionserDetail(aadharNumber);
		else
		{
			log.error("user unathorized");
			throw new TokenInvalidException("USER UNAUTHORIZED");
		}
	}

}
