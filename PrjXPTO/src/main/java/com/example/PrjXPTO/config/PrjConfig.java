package com.example.PrjXPTO.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class PrjConfig {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http)throws Exception{
		http
		.csrf().disable()
		.authorizeHttpRequests((requests)-> requests

				.requestMatchers(
						HttpMethod.POST,"/livro/", "/autor/", "/categoria/")
				.permitAll()
				.requestMatchers(
						HttpMethod.GET,"/livro/", "/autor/", "/categoria/")
				.permitAll()	
				.anyRequest()
				.authenticated()	

				)
		.httpBasic();
		return http.build();

	}
	
	@Bean
	public InMemoryUserDetailsManager userDetailsService(){
		UserDetails user = User.withDefaultPasswordEncoder()
				.username("livro")
				.password("12345")
				.build();
		return new InMemoryUserDetailsManager(user);
		
	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
	           @Override
	           public void addCorsMappings(CorsRegistry registry) {
	               registry.addMapping("/**").allowedOrigins("*") // Permitir qualquer origem
	                       .allowedMethods("POST", "GET", "OPTIONS", "PUT", "DELETE", "HEAD"); // Métodos permitidos
	           }
	       };
	}
}
