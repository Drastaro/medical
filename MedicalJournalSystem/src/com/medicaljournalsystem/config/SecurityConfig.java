package com.medicaljournalsystem.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("authenticationService")
	UserDetailsService userDetailsService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/", "/home").authenticated().antMatchers("/users/list")
				.hasAuthority("ROLE_PUBLISHER").antMatchers("/users/add").hasAuthority("ROLE_PUBLISHER")
				.antMatchers("/users/delete/*").hasAuthority("ROLE_PUBLISHER").antMatchers("/medicaljournals/list")
				.hasAuthority("ROLE_PUBLISHER").antMatchers("medicaljournals/add").hasAuthority("ROLE_PUBLISHER")
				.antMatchers("medicaljournals/edit/*").hasAuthority("ROLE_PUBLISHER").antMatchers("rest/journals")
				.hasAuthority("ROLE_PUBLISHER").antMatchers("medicaljournals/submit").hasAuthority("ROLE_PUBLISHER")
				.antMatchers("medicaljournals/search").authenticated().antMatchers("/medicaljournals/subscribe")
				.authenticated().and().formLogin().loginPage("/login").loginProcessingUrl("/j_spring_security_check")
				.usernameParameter("email").passwordParameter("password").and().csrf().and().exceptionHandling()
				.accessDeniedPage("/500");

	}
}
