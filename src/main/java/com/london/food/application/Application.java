package com.london.food.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.london.food.security.ApplicationSecurity;

@ImportResource({"classpath:spring/services-config.xml"})
@PropertySource(value="classpath:application.properties")
@Configuration
@ComponentScan(basePackages = {"com.london.food.controller", "com.london.food.validator"})
@EnableAutoConfiguration
public class Application {
	
	@Bean
	public WebSecurityConfigurerAdapter webSecurityConfigurerAdapter(){
		return new ApplicationSecurity();
	}
	
	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(Application.class);
        application.run(args);
	}
}			