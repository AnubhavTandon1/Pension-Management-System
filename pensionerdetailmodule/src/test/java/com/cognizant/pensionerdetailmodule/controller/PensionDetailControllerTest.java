package com.cognizant.pensionerdetailmodule.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
//import com.cognizant.pensionerdetailmodule.controllers.PensionDetailModuleController;
//import com.cognizant.pensionerdetailmodule.exception.PensionerNotFoundException;
import com.cognizant.pensionerdetailmodule.exception.TokenInvalidException;
import com.cognizant.pensionerdetailmodule.models.PensionerDetail;
import com.cognizant.pensionerdetailmodule.service.PensionDetailService;

import nl.jqno.equalsverifier.EqualsVerifier;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class PensionDetailControllerTest {
	@InjectMocks
	private PensionDetailModuleController pensionDetailController;
	@Mock
	private PensionDetailService pensionDetailService;

	@Test
	public void testGetPensionerDetail() throws  TokenInvalidException {
		String token = "dummyToken";
		PensionerDetail pensionerDetail = new PensionerDetail("Sanjay Guleria", "21/03/1974", "AAA12569CC", 18000, 1200,
				true, false, "Punjab National Bank", "9999689745", "Public");
		Mockito.when(pensionDetailService.getPensionerDetail(token, 546789641236L)).thenReturn(pensionerDetail);
		assertNotNull(pensionDetailService.getPensionerDetail(token, 546789641236L));
		assertEquals(pensionDetailController.getPensionerDetail(token, 546789641236L), pensionerDetail);
	}
	@Test
	public void simpleEqualsContract() {
		EqualsVerifier.simple().forClass(PensionerDetail.class).verify();
	}
	@Test
	public void testGetPensionserDetailSuccess() {
		PensionerDetail pensionerDetail = new PensionerDetail("Sanjay Guleria", "21/03/1974", "AAA12569CC", 18000, 1200,
				true, false, "Punjab National Bank", "9999689745", "Public");
		Map<Long, PensionerDetail> mapAadharToPensionerDetail=new HashMap<Long,PensionerDetail>();
		mapAadharToPensionerDetail.put(546789641236L, pensionerDetail);
		assertEquals(mapAadharToPensionerDetail.get(546789641236L),pensionerDetail);
	}
	@Test
	public void testGetPensionserDetailFail() {
		PensionerDetail pensionerDetail = new PensionerDetail("Sanjay Guleria", "21/03/1974", "AAA12569CC", 18000, 1200,
				true, false, "Punjab National Bank", "9999689745", "Public");
		Map<Long, PensionerDetail> mapAadharToPensionerDetail=new HashMap<Long,PensionerDetail>();
		mapAadharToPensionerDetail.put(546789641236L, pensionerDetail);
		assertNotEquals(mapAadharToPensionerDetail.get(54678964123L),pensionerDetail);
	}

}
