package com.cognizant.processpensionmodule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.cognizant.processpensionmodule.swagger.SwaggerFilter;

@SpringBootApplication
@EnableFeignClients
public class ProcessPensionModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProcessPensionModuleApplication.class, args);
	}
	
	//For Swagger UI - http://localhost:<portno>/swagger-ui.html
	@SuppressWarnings({ "rawtypes", "unchecked"})
	@Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        SwaggerFilter myFilter = new SwaggerFilter();
        filterRegistrationBean.setFilter(myFilter);
        return filterRegistrationBean;
    }
}
