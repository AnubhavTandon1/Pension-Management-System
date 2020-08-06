package com.pensiondisbursement.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.pensiondisbursement.model.PensionerDetail;
import com.pensiondisbursement.model.ProcessPensionInput;
import com.pensiondisbursement.restclients.PensionerDetailClient;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class PensionDisbursementServiceTest {
	@InjectMocks
	private PensionDisbursementService pensionDisbursementService;
	@Mock
	private PensionerDetailClient pensionerDetailClient;
	@Test
	public void testGetPensionDetail() {
		String token="dummyToken";
		PensionerDetail pensionerDetail = new PensionerDetail("Sanjay Guleria", "21/03/1974", "AAA12569CC", 18000.0,
				1200.0, true, false, "Punjab National Bank", "9999689745", "Public");
		Mockito.when(pensionerDetailClient.getPensionerDetails(token, 546789641236L)).thenReturn(pensionerDetail);
		assertEquals(pensionDisbursementService.getPensionDetail(token, 546789641236L),pensionerDetail);
	}
	@Test
	public void testGetPensionDisbursementSuccess() {
		String token="dummyToken";
		PensionerDetail pensionerDetail = new PensionerDetail("Sanjay Guleria", "21/03/1974", "AAA12569CC", 18000.0,
				1200.0, true, false, "Punjab National Bank", "9999689745", "Public");
	ProcessPensionInput ppi = new ProcessPensionInput(546789641236L, 15600.0, 500.0);
	Mockito.when(pensionerDetailClient.getPensionerDetails(token, ppi.getAadharNumber())).thenReturn(pensionerDetail);
	assertEquals(pensionDisbursementService.getPensionDisbursement(token,ppi),10);
	}
	@Test
	public void testGetPensionDisbursementServiceChargeNotPaid() {
		String token="dummyToken";
		PensionerDetail pensionerDetail = new PensionerDetail("Sanjay Guleria", "21/03/1974", "AAA12569CC", 18000.0,
				1200.0, true, false, "Punjab National Bank", "9999689745", "Public");
	ProcessPensionInput ppi = new ProcessPensionInput(546789641236L, 15600.0, 0.0);
	Mockito.when(pensionerDetailClient.getPensionerDetails(token, ppi.getAadharNumber())).thenReturn(pensionerDetail);
	assertEquals(pensionDisbursementService.getPensionDisbursement(token,ppi),20);
	}
	@Test
	public void testGetPensionDisbursementUnknownError() {
		String token="dummyToken";
		PensionerDetail pensionerDetail = new PensionerDetail("Sanjay Guleria", "21/03/1974", "AAA12569CC", 18000.0,
				1200.0, true, false, "Punjab National Bank", "9999689745", "Public");
	ProcessPensionInput ppi = new ProcessPensionInput(546789641236L, 15600.0, 900.0);
	Mockito.when(pensionerDetailClient.getPensionerDetails(token, ppi.getAadharNumber())).thenReturn(pensionerDetail);
	assertEquals(pensionDisbursementService.getPensionDisbursement(token,ppi),21);
	}
	@Test
	public void testGetPensionDisbursementWrongAadhar() {
		String token="dummyToken";
		PensionerDetail pensionerDetail = null;
	ProcessPensionInput ppi = new ProcessPensionInput(5467896416L, 15600.0, 900.0);
	Mockito.when(pensionerDetailClient.getPensionerDetails(token, ppi.getAadharNumber())).thenReturn(pensionerDetail);
	assertEquals(pensionDisbursementService.getPensionDisbursement(token,ppi),0);
	}
	@Test
	public void testGetPensionDisbursementPrivateBankSuccess() {
		String token="dummyToken";
		PensionerDetail pensionerDetail = new PensionerDetail("Ashok Kumar", "20/10/1970", "DNA55682NN", 16000.0,
				1200.0, false, true, "Axis Bank", "2987465186", "Private");
	ProcessPensionInput ppi = new ProcessPensionInput(264819375648L, 9200.0, 550.0);
	Mockito.when(pensionerDetailClient.getPensionerDetails(token, ppi.getAadharNumber())).thenReturn(pensionerDetail);
	assertEquals(pensionDisbursementService.getPensionDisbursement(token,ppi),10);
	}
	@Test
	public void testGetPensionDisbursementPrivateBankChargeNotPaid() {
		String token="dummyToken";
		PensionerDetail pensionerDetail = new PensionerDetail("Ashok Kumar", "20/10/1970", "DNA55682NN", 16000.0,
				1200.0, false, true, "Axis Bank", "2987465186", "Private");
	ProcessPensionInput ppi = new ProcessPensionInput(264819375648L, 9200.0, 0.0);
	Mockito.when(pensionerDetailClient.getPensionerDetails(token, ppi.getAadharNumber())).thenReturn(pensionerDetail);
	assertEquals(pensionDisbursementService.getPensionDisbursement(token,ppi),20);
	}
	@Test
	public void testGetPensionDisbursementPrivateBankUnknownError() {
		String token="dummyToken";
		PensionerDetail pensionerDetail = new PensionerDetail("Ashok Kumar", "20/10/1970", "DNA55682NN", 16000.0,
				1200.0, false, true, "Axis Bank", "2987465186", "Private");
	ProcessPensionInput ppi = new ProcessPensionInput(264819375648L, 9200.0, 5250.0);
	Mockito.when(pensionerDetailClient.getPensionerDetails(token, ppi.getAadharNumber())).thenReturn(pensionerDetail);
	assertEquals(pensionDisbursementService.getPensionDisbursement(token,ppi),21);
	}
	@Test
	public void testGetPensionDisbursementUnknownErrorWrongBankType() {
		String token="dummyToken";
		PensionerDetail pensionerDetail = new PensionerDetail("Ashok Kumar", "20/10/1970", "DNA55682NN", 16000.0,
				1200.0, false, true, "Axis Bank", "2987465186", "WrongBank");
	ProcessPensionInput ppi = new ProcessPensionInput(264819375648L, 9200.0, 5250.0);
	Mockito.when(pensionerDetailClient.getPensionerDetails(token, ppi.getAadharNumber())).thenReturn(pensionerDetail);
	assertEquals(pensionDisbursementService.getPensionDisbursement(token,ppi),21);
	}
	

}
