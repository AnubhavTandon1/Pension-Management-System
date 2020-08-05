package com.cognizant.portal.model;


import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class Login {
	
	@NotNull(message = "please fill the username")
	private String username;
	@NotNull(message = "please enter the password")
	private String password;

}
