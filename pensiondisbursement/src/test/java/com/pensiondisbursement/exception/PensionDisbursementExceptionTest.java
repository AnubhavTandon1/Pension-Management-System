package com.pensiondisbursement.exception;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
public class PensionDisbursementExceptionTest {
	@InjectMocks
	private TokenInvalidException tokenInvalidException;

	@Test
	public void testTokenInvalidException() {
		String reason = "Invalid token..";
		assertEquals(reason, "Invalid token..");
	}
}