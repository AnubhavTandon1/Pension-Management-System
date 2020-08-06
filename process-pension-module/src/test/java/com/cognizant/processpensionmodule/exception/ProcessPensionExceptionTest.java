package com.cognizant.processpensionmodule.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProcessPensionExceptionTest {
	@InjectMocks
	private TokenInvalidException tokenInvalidException;
	@InjectMocks
	private PensionerInputNotFoundException pensionerInputNotFoundException;
	@InjectMocks
	private PensionerNotFoundException pensionerNotFoundException;

	@Test
	public void testTokenInvalidException() {
		String reason = "Invalid token..";
		assertEquals(reason, "Invalid token..");
	}

	@Test
	public void testPensionerInputNotFoundException() {
		String reason = "Input not found!";
		assertEquals(reason, "Input not found!");
	}

	@Test
	public void testPensionerNotFoundException() {
		String reason = "Pensioner not found!";
		assertEquals(reason, "Pensioner not found!");
	}
}
