package com.hpinfosystem.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class TimesheetUtils {
	
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();	
	}

}
