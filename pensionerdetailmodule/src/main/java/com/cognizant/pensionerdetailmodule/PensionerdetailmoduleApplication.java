package com.cognizant.pensionerdetailmodule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import com.cognizant.pensionerdetailmodule.swagger.SwaggerFilter;


@SpringBootApplication
public class PensionerdetailmoduleApplication {

	public static void main(String[] args) {
		SpringApplication.run(PensionerdetailmoduleApplication.class, args);
	}
	
	//For Swagger UI - http://localhost:8082/swagger-ui.html
	@SuppressWarnings({ "rawtypes", "unchecked"})
	@Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        SwaggerFilter myFilter = new SwaggerFilter();
        filterRegistrationBean.setFilter(myFilter);
        return filterRegistrationBean;
    }

}
