package com.medicaljournalsystem.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/", "/home").access("hasRole('USER')").antMatchers("/db/**")
				.access("hasRole('ADMIN') and hasRole('DBA')").and().formLogin().loginPage("/login")
				.loginProcessingUrl("/j_spring_security_check").usernameParameter("email").passwordParameter("password")
				.and().csrf().and().exceptionHandling().accessDeniedPage("/access_denied");

	}
}
