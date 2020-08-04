package com.cognizant.pensionerdetailmodule.controller;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.pensionerdetailmodule.controller.PensionDetailModuleController;
import com.cognizant.pensionerdetailmodule.exception.PensionerNotFoundException;
import com.cognizant.pensionerdetailmodule.exception.TokenInvalidException;
import com.cognizant.pensionerdetailmodule.models.PensionerDetail;
import com.cognizant.pensionerdetailmodule.service.PensionDetailService;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class PensionDetailControllerTest {
	@InjectMocks
	private PensionDetailModuleController pensionDetailController;
	@Mock
	private PensionDetailService pensionDetailService;

	@Test
	public void testGetPensionerDetail() throws PensionerNotFoundException, TokenInvalidException {
		String token = "dummyToken";
		PensionerDetail pensionerDetail = new PensionerDetail("Sanjay Guleria", "21/03/1974", "AAA12569CC", 18000, 1200,
				true, false, "Punjab National Bank", "9999689745", "Public");

		Mockito.when(pensionDetailService.getPensionerDetail(token, 546789641236L)).thenReturn(pensionerDetail);
		assertNotNull(pensionDetailService.getPensionerDetail(token, 546789641236L));
		assertEquals(pensionDetailService.getPensionerDetail(token, 546789641236L), pensionerDetail);
	}

}
