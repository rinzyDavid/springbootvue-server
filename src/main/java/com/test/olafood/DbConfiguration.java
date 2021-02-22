package com.test.olafood;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties("spring.datasource")
public class DbConfiguration {
	
	private String driverClassName;
	
	
	@Profile("dev")
	@Bean
	public void DevdbConnection() {
	
		System.out.println(driverClassName);
	}

}
