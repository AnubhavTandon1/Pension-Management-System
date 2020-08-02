package com.cognizant.pensionerdetailmodule.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Pensioner not found!")
public class PensionerNotFoundException extends Exception {
	public PensionerNotFoundException(String msg) {
		super(msg);
	}
	public PensionerNotFoundException() {}
}
