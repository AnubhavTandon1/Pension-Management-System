package com.cognizant.processpensionmodule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ProcessPensionModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProcessPensionModuleApplication.class, args);
	}

}
