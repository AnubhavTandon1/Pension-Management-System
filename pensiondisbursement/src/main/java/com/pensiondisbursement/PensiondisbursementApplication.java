package com.pensiondisbursement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class PensiondisbursementApplication {

	public static void main(String[] args) {
		SpringApplication.run(PensiondisbursementApplication.class, args);
	}

}
