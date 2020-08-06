package com.pensiondisbursement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableFeignClients
@SpringBootApplication
public class PensiondisbursementApplication {

	public static void main(String[] args) {
		SpringApplication.run(PensiondisbursementApplication.class, args);
	}

	// For Swagger UI - http://localhost:8083/swagger-ui.html
//	@SuppressWarnings({ "rawtypes", "unchecked" })
//	@Bean
//	public FilterRegistrationBean filterRegistrationBean() {
//		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//		SwaggerFilter myFilter = new SwaggerFilter();
//		filterRegistrationBean.setFilter(myFilter);
//		return filterRegistrationBean;
//	}

}
