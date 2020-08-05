package com.cognizant.portal.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtResponse {

	private long id;
	private String token;
	private String username;
	private List<String> roles;

}