package com.cognizant.authorizationservice.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.authorizationservice.entity.User;
import com.cognizant.authorizationservice.exception.TokenInvalidException;
import com.cognizant.authorizationservice.exception.UserNotFoundException;
import com.cognizant.authorizationservice.payload.JwtResponse;
import com.cognizant.authorizationservice.payload.LoginRequest;
import com.cognizant.authorizationservice.repository.UserRepository;
import com.cognizant.authorizationservice.security.jwt.JwtUtils;
import com.cognizant.authorizationservice.security.service.UserDetailsImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/auth")
@Slf4j
public class AuthController {

	private final AuthenticationManager authenticationManager;
	private final UserRepository userRepository;
	private final JwtUtils jwtUtils;

	public AuthController(AuthenticationManager authenticationManager, JwtUtils jwtUtils, UserRepository userRepository,
			PasswordEncoder encoder) {
		this.authenticationManager = authenticationManager;
		this.userRepository = userRepository;
		this.jwtUtils = jwtUtils;
	}

	@PostMapping("/signin")
	public ResponseEntity<JwtResponse> authenticateUser(@RequestBody LoginRequest loginRequest) {
		log.debug("Login Request {}", loginRequest);
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority)
				.collect(Collectors.toList());

		return new ResponseEntity<>(new JwtResponse(userDetails.getId(), jwt, userDetails.getUsername(), roles),
				HttpStatus.OK);
	}

//	@PostMapping("/validate-cart")
//	public String validateAndReturnUserForCart(@RequestHeader("Authorization") String token) throws TokenInvalidException {
//		jwtUtils.validateJwtToken(token);
//
//		String username = jwtUtils.getUserNameFromJwtToken(token);
//		User user = userRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException(username));
//		return user.getUsername();
//	}

	@PostMapping("/validate")
	public boolean validateAndReturnUser(@RequestHeader("Authorization") String token) throws TokenInvalidException {
		log.debug("in auth controller with jwt {}", token);
		return jwtUtils.validateJwtToken(token);

	}
}
