package com.cognizant.processpensionmodule.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Input not found!")
public class PensionerInputNotFoundException extends Exception {
	public PensionerInputNotFoundException(String msg) {
		super(msg);
	}
}
