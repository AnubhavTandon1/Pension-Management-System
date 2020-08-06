package com.cognizant.processpensionmodule.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Pensioner not found!")
public class PensionerNotFoundException extends Exception {
	public PensionerNotFoundException(String msg) {
		super(msg);
	}

}
