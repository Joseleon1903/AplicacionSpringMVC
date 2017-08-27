package com.aplication.spring.mvc.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig2 {

	@Bean
	public Mundo mundo2(){
		return new Mundo();
	}

}
