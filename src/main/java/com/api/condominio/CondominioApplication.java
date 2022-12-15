package com.api.condominio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;



@SpringBootApplication /*(exclude = {SecurityAutoConfiguration.class})*/

public class CondominioApplication {
	public static void main(String[] args) {
		SpringApplication.run(CondominioApplication.class, args);
		
	}		
	
}