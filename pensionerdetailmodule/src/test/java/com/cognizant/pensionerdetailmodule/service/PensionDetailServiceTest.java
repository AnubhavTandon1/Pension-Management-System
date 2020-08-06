package com.cognizant.pensionerdetailmodule.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.pensionerdetailmodule.dao.impl.PensionDetailDaoImpl;
import com.cognizant.pensionerdetailmodule.exception.TokenInvalidException;
import com.cognizant.pensionerdetailmodule.models.PensionerDetail;
import com.cognizant.pensionerdetailmodule.restclients.AuthorizationServiceClient;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class PensionDetailServiceTest {
	@InjectMocks
	private PensionDetailService pensionDetailService;
	@Mock
	private PensionDetailDaoImpl pensionDetailDaoImpl;
	@Mock
	private AuthorizationServiceClient authClient;
	
	@Test
	public void testGetPensionerDetailSuccess() throws TokenInvalidException {
		String token="dummyToken";   
		PensionerDetail pensionerDetail = new PensionerDetail("Sanjay Guleria","21/03/1974","AAA12569CC",18000.0,1200.0,true,false,"Punjab National Bank","9999689745","Public");
		Mockito.when(authClient.validateAndReturnUser(token)).thenReturn(true);
		Mockito.when(pensionDetailDaoImpl.getPensionserDetail(546789641236L)).thenReturn(pensionerDetail);
		assertEquals(pensionDetailService.getPensionerDetail(token,546789641236L),pensionerDetail);
	}
//	@Test
//	public void testGetPensionerDetailFail() throws TokenInvalidException {
//		String token="dummyToken";   
//		PensionerDetail pensionerDetail = new PensionerDetail("Sanjay Guleria","21/03/1974","AAA12569CC",18000.0,1200.0,true,false,"Punjab National Bank","9999689745","Public");
//		Mockito.when(authClient.validateAndReturnUser(token)).thenReturn(false);
//		Mockito.when(pensionDetailDaoImpl.getPensionserDetail(546789641236L)).thenReturn(pensionerDetail);
//		assertEquals(pensionDetailService.getPensionerDetail(token,546789641236L),null);
//	}

}
