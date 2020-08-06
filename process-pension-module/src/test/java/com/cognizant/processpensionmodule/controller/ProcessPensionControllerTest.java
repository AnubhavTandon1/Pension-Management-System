package com.cognizant.processpensionmodule.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import com.cognizant.processpensionmodule.exception.PensionerNotFoundException;
import com.cognizant.processpensionmodule.exception.TokenInvalidException;
import com.cognizant.processpensionmodule.model.PensionDetail;
import com.cognizant.processpensionmodule.model.PensionerInput;
import com.cognizant.processpensionmodule.model.ProcessPensionInput;
import com.cognizant.processpensionmodule.service.PensionDetailService;
import com.cognizant.processpensionmodule.service.PensionDisbursementService;

import nl.jqno.equalsverifier.EqualsVerifier;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ProcessPensionControllerTest {

	@InjectMocks
	ProcessPensionController processPensionController;
	@Mock
	private PensionDetailService pensionDetailService;
	@Mock
	private PensionDisbursementService pensionDisbursementService;

	@Test
	public void testGetPensionDetail() throws PensionerNotFoundException, TokenInvalidException {
		String token = "dummyToken";
		PensionerInput input = new PensionerInput("Sanjay Guleria", "21/03/1974", "AAA12569CC", 546789641236L, true,
				false);
		PensionDetail pensionDetail = new PensionDetail("Sanjay Guleria", "21/03/1974", "AAA12569CC", true, false,
				15600.0);
		Mockito.when(pensionDetailService.getPensionDetail(token, input)).thenReturn(pensionDetail);
		assertNotNull(processPensionController.getPensionDetail(token, input));
		assertEquals(processPensionController.getPensionDetail(token, input), pensionDetail);

	}

	@Test
	public void testGetDisbursementCodeSuccess() throws PensionerNotFoundException, TokenInvalidException {
		String token = "dummyToken";
		ProcessPensionInput ppi = new ProcessPensionInput(546789641236L, 15600.0, 550.0);
		Mockito.when(pensionDisbursementService.getDisbursementCode(token, ppi)).thenReturn(10);
		assertEquals(processPensionController.getDisbursementCode(token, ppi), 10);
	}

	@Test
	public void testGetDisbursementCodeServiceChargeNotPaid() throws PensionerNotFoundException, TokenInvalidException {
		String token = "dummyToken";
		ProcessPensionInput ppi2 = new ProcessPensionInput(546789641236L, 15600.0, 0.0);
		Mockito.when(pensionDisbursementService.getDisbursementCode(token, ppi2)).thenReturn(20);
		assertEquals(processPensionController.getDisbursementCode(token, ppi2), 20);
	}

	@Test
	public void testGetDisbursementCodeUnknownError() throws PensionerNotFoundException, TokenInvalidException {
		String token = "dummyToken";
		ProcessPensionInput ppi3 = new ProcessPensionInput(546789641236L, 15600.0, 500.0);
		Mockito.when(pensionDisbursementService.getDisbursementCode(token, ppi3)).thenReturn(21);
		assertEquals(processPensionController.getDisbursementCode(token, ppi3), 21);
	}

	@Test
	public void simpleEqualsContract() {
		EqualsVerifier.simple().forClass(PensionerInput.class).verify();
	}
}
