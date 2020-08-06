package com.pensiondisbursement.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import com.pensiondisbursement.exception.TokenInvalidException;
import com.pensiondisbursement.model.ProcessPensionInput;
import com.pensiondisbursement.service.PensionDisbursementService;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class PensionDisbursementControllerTest {
	@InjectMocks
	private PensionDisbursementController pensionDisbursementController;
	@Mock
	private PensionDisbursementService pensionDisbursementService;


	@Test
	public void testGetPensionDisbursementSuccess() throws  TokenInvalidException {
		String token = "dummyToken";
		ProcessPensionInput ppi = new ProcessPensionInput(546789641236L, 15600.0, 550.0);
		Mockito.when(pensionDisbursementService.getPensionDisbursement(token, ppi)).thenReturn(10);
		assertEquals(pensionDisbursementController.getPensionDisbursement(token, ppi), 10);
	}

	@Test
	public void testGetPensionDisbursementServiceChargeNotPaid()
			throws  TokenInvalidException {
		String token = "dummyToken";
		ProcessPensionInput ppi2 = new ProcessPensionInput(546789641236L, 15600.0, 0.0);
		Mockito.when(pensionDisbursementService.getPensionDisbursement(token, ppi2)).thenReturn(20);
		assertEquals(pensionDisbursementController.getPensionDisbursement(token, ppi2), 20);
	}

	@Test
	public void testGetPensionDisbursementUnkownError() throws  TokenInvalidException {
		String token = "dummyToken";
		ProcessPensionInput ppi3 = new ProcessPensionInput(546789641236L, 15600.0, 500.0);
		Mockito.when(pensionDisbursementService.getPensionDisbursement(token, ppi3)).thenReturn(21);
		assertEquals(pensionDisbursementController.getPensionDisbursement(token, ppi3), 21);
	}


}
