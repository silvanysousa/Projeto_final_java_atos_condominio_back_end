package com.api.condominio.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity 
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	public void configure(HttpSecurity httpSec) throws Exception {
		
		httpSec.csrf().disable()
					  .authorizeHttpRequests() 
					  //USUARIO
					  .antMatchers(HttpMethod.POST, "/usuario/login").permitAll()
					  .antMatchers(HttpMethod.GET, "/usuario").permitAll()
					  .antMatchers(HttpMethod.POST, "/usuario").permitAll()
					  .antMatchers(HttpMethod.PUT, "/usuario/{id}").permitAll()
					  .antMatchers(HttpMethod.DELETE, "/usuario/{id}").permitAll()
					  //RESERVA					  
					  .antMatchers(HttpMethod.POST, "/reserva").permitAll()
					  .antMatchers(HttpMethod.GET, "/reserva").permitAll()
					  .antMatchers(HttpMethod.PUT, "/reserva/{id}").permitAll()
					  .antMatchers(HttpMethod.DELETE, "/reserva/{id}").permitAll()
					  
					  .anyRequest().authenticated().and().cors();
		
		httpSec.addFilterBefore(new SecurityFilter(), UsernamePasswordAuthenticationFilter.class);
	}
	
}