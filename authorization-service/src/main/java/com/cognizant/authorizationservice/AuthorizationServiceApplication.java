package com.cognizant.authorizationservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.cognizant.authorizationservice.entity.User;
import com.cognizant.authorizationservice.repository.UserRepository;

@SpringBootApplication
public class AuthorizationServiceApplication implements CommandLineRunner {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	@Autowired
	public AuthorizationServiceApplication(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	public static void main(String[] args) {
		SpringApplication.run(AuthorizationServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userRepository.save(new User("purusham", passwordEncoder.encode("password"), "ROLE_USER"));
		userRepository.save(new User("anubhav", passwordEncoder.encode("password1"), "ROLE_USER"));
		userRepository.save(new User("brijesh", passwordEncoder.encode("password2"), "ROLE_USER"));
		userRepository.save(new User("kunal", passwordEncoder.encode("password3"), "ROLE_USER"));
	}
}
