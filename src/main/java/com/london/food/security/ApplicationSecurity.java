package com.london.food.security;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class ApplicationSecurity extends WebSecurityConfigurerAdapter {

	@Override
	  protected void configure(HttpSecurity http) throws Exception {
	    http
	      .authorizeRequests()
	        .antMatchers("/**").hasRole("USER")
	        .anyRequest().anonymous().and()
	      .httpBasic().and()
	      .csrf().disable();
	  }
	   
	  @Override
	  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	    auth
	      .inMemoryAuthentication()
	        .withUser("user").password("user").authorities("ROLE_USER").and()
	        .withUser("admin").password("admin").authorities("ROLE_USER", "ROLE_ADMIN");
	  }
}
