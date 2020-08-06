package com.cognizant.processpensionmodule.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
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
import com.cognizant.processpensionmodule.modeldto.PensionerDetail;
import com.cognizant.processpensionmodule.restclients.PensionDisbursementClient;
import com.cognizant.processpensionmodule.restclients.PensionerDetailClient;

import nl.jqno.equalsverifier.EqualsVerifier;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ProcessPensionServiceTest {
	@InjectMocks
	private PensionDetailService pensionDetailService;
	@Mock
	private PensionerDetailClient pensionerDetailClient;
	@InjectMocks
	private PensionDisbursementService pensionDisbursementService;
	@Mock
	private PensionDisbursementClient pensionDisbursementClient;

	@Test
	public void testCalculatePensionAmountIsSelfPension() {
		PensionerInput pensionerInput = new PensionerInput("Sanjay Guleria", "21/03/1974", "AAA12569CC", 546789641236L,
				true, false);
		assertEquals(pensionDetailService.calculatePensionAmount(18000.0, 1200.0, pensionerInput), 15600.0);
	}

	@Test
	public void testCalculatePensionAmountIsFamilyPension() {
		PensionerInput pensionerInput = new PensionerInput("Ashok Kumar", "20/10/1970", "DNA55682NN", 264819375648L,
				false, true);
		assertEquals(pensionDetailService.calculatePensionAmount(16000.0, 1200.0, pensionerInput), 9200.0);
	}

	@Test
	public void testGetPensionDetail() throws PensionerNotFoundException, TokenInvalidException {
		String token = "dummyToken";
		PensionerDetail pensionerDetail = new PensionerDetail("Sanjay Guleria", "21/03/1974", "AAA12569CC", 18000.0,
				1200.0, true, false, "Punjab National Bank", "9999689745", "Public");
		PensionerInput pensionerInput = new PensionerInput("Ashok Kumar", "20/10/1970", "DNA55682NN", 264819375648L,
				false, true);
		Mockito.when(pensionerDetailClient.getPensionerDetails(token, pensionerInput.getAadharNumber()))
				.thenReturn(pensionerDetail);
		assertEquals(pensionDetailService.getPensionDetail(token, pensionerInput.getAadharNumber()), pensionerDetail);
	}

	@Test
	public void testGetPensionDetailNullCheck() throws PensionerNotFoundException, TokenInvalidException {
		String token = "dummyToken";
		PensionerDetail pensionerDetail = new PensionerDetail("Sanjay Guleria", "21/03/1974", "AAA12569CC", 18000.0,
				1200.0, true, false, "Punjab National Bank", "9999689745", "Public");
		Mockito.when(pensionerDetailClient.getPensionerDetails(token, 1212L)).thenReturn(null);
		assertEquals(pensionDetailService.getPensionDetail(token, 1212L), null);
	}

	@Test
	public void testGetPensionDetailValidInput() throws PensionerNotFoundException {
		String token = "dummyToken";
		PensionerDetail pensionerDetail = new PensionerDetail("Sanjay Guleria", "21/03/1974", "AAA12569CC", 18000.0,
				1200.0, true, false, "Punjab National Bank", "9999689745", "Public");
		PensionerInput pensionerInput = new PensionerInput("Sanjay Guleria", "21/03/1974", "AAA12569CC", 546789641236L,
				true, false);
		assertEquals(pensionerInput.getName(), pensionerDetail.getName());
		assertEquals(pensionerInput.getDateOfBirth(), pensionerDetail.getDateOfBirth());
		assertEquals(pensionerInput.getPan(), pensionerDetail.getPan());
		assertEquals(pensionerInput.isSelfPension(), pensionerDetail.isSelfPension());
	}

	@Test
	public void testGetPensionDetailInValidInput() throws PensionerNotFoundException, TokenInvalidException {
		String token = "dummyToken";
		PensionerDetail pensionerDetail = new PensionerDetail("Sanjay Guleria", "21/03/1974", "AAA12569CC", 18000.0,
				1200.0, true, false, "Punjab National Bank", "9999689745", "Public");
		PensionerInput pensionerInput = new PensionerInput("Ashok Kumar", "20/10/1970", "DNA55682NN", 264819375648L,
				false, true);
		assertNotEquals(pensionerInput.getName(), pensionerDetail.getName());
		assertNotEquals(pensionerInput.getDateOfBirth(), pensionerDetail.getDateOfBirth());
		assertNotEquals(pensionerInput.getPan(), pensionerDetail.getPan());
		assertNotEquals(pensionerInput.isSelfPension(), pensionerDetail.isSelfPension());
		assertEquals(pensionDetailService.getPensionDetail(token, pensionerInput.getAadharNumber()), null);
	}

	// PensionerDisbursementService
	@Test
	public void testGetDisbursementCodeSucess() throws PensionerNotFoundException {
		String token = "dummyToken";
		ProcessPensionInput ppi = new ProcessPensionInput(546789641236L, 15600.0, 550.0);
		Mockito.when(pensionDisbursementClient.getPensionDisbursement(token, ppi)).thenReturn(10);
		assertEquals(pensionDisbursementService.getDisbursementCode(token, ppi), 10);
	}

	@Test
	public void testGetDisbursementCodeNotPaid() throws PensionerNotFoundException {
		String token = "dummyToken";
		ProcessPensionInput ppi = new ProcessPensionInput(546789641236L, 15600.0, 0.0);
		Mockito.when(pensionDisbursementClient.getPensionDisbursement(token, ppi)).thenReturn(20);
		assertEquals(pensionDisbursementService.getDisbursementCode(token, ppi), 20);
	}

	@Test
	public void testGetDisbursementCodeUnknownError() throws PensionerNotFoundException {
		String token = "dummyToken";
		ProcessPensionInput ppi = new ProcessPensionInput(546789641236L, 15600.0, 400.0);
		Mockito.when(pensionDisbursementClient.getPensionDisbursement(token, ppi)).thenReturn(21);
		assertEquals(pensionDisbursementService.getDisbursementCode(token, ppi), 21);
	}
	@Test
	public void testGetPensionDetailInValidInputName() throws PensionerNotFoundException, TokenInvalidException {
		String token = "dummyToken";
		PensionerDetail pensionerDetail = new PensionerDetail("Sanjay Guleria", "21/03/1974", "AAA12569CC", 18000.0,
				1200.0, true, false, "Punjab National Bank", "9999689745", "Public");
		PensionerInput pensionerInput = new PensionerInput("Ashok Kumar", "20/10/1970", "DNA55682NN", 264819375648L,
				false, true);
		assertNotEquals(pensionerInput.getName(), pensionerDetail.getName());
		assertEquals(pensionDetailService.getPensionDetail(token, pensionerInput.getAadharNumber()), null);
	}
	@Test
	public void testGetPensionDetailValidInputName() throws PensionerNotFoundException {
		String token = "dummyToken";
		PensionerDetail pensionerDetail = new PensionerDetail("Sanjay Guleria", "21/03/1974", "AAA12569CC", 18000.0,
				1200.0, true, false, "Punjab National Bank", "9999689745", "Public");
		PensionerInput pensionerInput = new PensionerInput("Sanjay Guleria", "21/03/1974", "AAA12569CC", 546789641236L,
				true, false);
		assertEquals(pensionerInput.getName(), pensionerDetail.getName());
		assertEquals(pensionerInput.isSelfPension(), pensionerDetail.isSelfPension());
	}
	@Test
	public void testGetPensionDetailInValidInputDob() throws PensionerNotFoundException, TokenInvalidException {
		String token = "dummyToken";
		PensionerDetail pensionerDetail = new PensionerDetail("Sanjay Guleria", "21/03/1974", "AAA12569CC", 18000.0,
				1200.0, true, false, "Punjab National Bank", "9999689745", "Public");
		PensionerInput pensionerInput = new PensionerInput("Ashok Kumar", "20/10/1970", "DNA55682NN", 264819375648L,
				false, true);
		assertNotEquals(pensionerInput.getDateOfBirth(), pensionerDetail.getDateOfBirth());
		assertEquals(pensionDetailService.getPensionDetail(token, pensionerInput.getAadharNumber()), null);
	}
	@Test
	public void testGetPensionDetailValidInputDob() throws PensionerNotFoundException {
		String token = "dummyToken";
		PensionerDetail pensionerDetail = new PensionerDetail("Sanjay Guleria", "21/03/1974", "AAA12569CC", 18000.0,
				1200.0, true, false, "Punjab National Bank", "9999689745", "Public");
		PensionerInput pensionerInput = new PensionerInput("Sanjay Guleria", "21/03/1974", "AAA12569CC", 546789641236L,
				true, false);
		assertEquals(pensionerInput.getDateOfBirth(), pensionerDetail.getDateOfBirth());
		assertEquals(pensionerInput.isSelfPension(), pensionerDetail.isSelfPension());
	}
	@Test
	public void testGetPensionDetailInValidInputPan() throws PensionerNotFoundException, TokenInvalidException {
		String token = "dummyToken";
		PensionerDetail pensionerDetail = new PensionerDetail("Sanjay Guleria", "21/03/1974", "AAA12569CC", 18000.0,
				1200.0, true, false, "Punjab National Bank", "9999689745", "Public");
		PensionerInput pensionerInput = new PensionerInput("Ashok Kumar", "20/10/1970", "DNA55682NN", 264819375648L,
				false, true);
		assertNotEquals(pensionerInput.getPan(), pensionerDetail.getPan());
		assertEquals(pensionDetailService.getPensionDetail(token, pensionerInput.getAadharNumber()), null);
	}
	@Test
	public void testGetPensionDetailValidInputPan() throws PensionerNotFoundException {
		String token = "dummyToken";
		PensionerDetail pensionerDetail = new PensionerDetail("Sanjay Guleria", "21/03/1974", "AAA12569CC", 18000.0,
				1200.0, true, false, "Punjab National Bank", "9999689745", "Public");
		PensionerInput pensionerInput = new PensionerInput("Sanjay Guleria", "21/03/1974", "AAA12569CC", 546789641236L,
				true, false);
		assertEquals(pensionerInput.getPan(), pensionerDetail.getPan());
	}
	@Test
	public void testGetPensionDetailInValidInputisSelf() throws PensionerNotFoundException, TokenInvalidException {
		String token = "dummyToken";
		PensionerDetail pensionerDetail = new PensionerDetail("Sanjay Guleria", "21/03/1974", "AAA12569CC", 18000.0,
				1200.0, true, false, "Punjab National Bank", "9999689745", "Public");
		PensionerInput pensionerInput = new PensionerInput("Ashok Kumar", "20/10/1970", "DNA55682NN", 264819375648L,
				false, true);
		assertNotEquals(pensionerInput.isSelfPension(), pensionerDetail.isSelfPension());
		assertEquals(pensionDetailService.getPensionDetail(token, pensionerInput.getAadharNumber()), null);
	}
	@Test
	public void testGetPensionDetailValidInputSelf() throws PensionerNotFoundException {
		String token = "dummyToken";
		PensionerDetail pensionerDetail = new PensionerDetail("Sanjay Guleria", "21/03/1974", "AAA12569CC", 18000.0,
				1200.0, true, false, "Punjab National Bank", "9999689745", "Public");
		PensionerInput pensionerInput = new PensionerInput("Sanjay Guleria", "21/03/1974", "AAA12569CC", 546789641236L,
				true, false);
		assertEquals(pensionerInput.isSelfPension(), pensionerDetail.isSelfPension());
	}
//	@Test
//	public void testGetPensionDetailWithValidCheck() throws PensionerNotFoundException, TokenInvalidException {
//		String token = "dummyToken";
//		PensionDetail pensionDetail = new PensionDetail("Sanjay Guleria", "21/03/1974", "AAA12569CC", true, false,
//				15600.0);
//		PensionerInput pensionerInput = new PensionerInput("Ashok Kumar", "20/10/1970", "DNA55682NN", 264819375648L,
//				false, true);
//		Mockito.when(pensionDetail.getName())
//				.thenReturn(pensionDetail.getName());
//		assertEquals(pensionDetailService.getPensionDetail(token, pensionerInput.getAadharNumber()), pensionDetail);
//	}
}
