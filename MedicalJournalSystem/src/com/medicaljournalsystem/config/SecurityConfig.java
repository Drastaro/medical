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

		http.authorizeRequests().antMatchers("/", "/home").authenticated().antMatchers("/listusers")
				.hasAuthority("USER").antMatchers("/medicaljournal/list/").hasAuthority("USER")
				.antMatchers("/medicaljournals/add").hasAuthority("USER").antMatchers("/medicaljournals/edit")
				.hasAuthority("USER").antMatchers("/medicaljournals/submit").hasAuthority("USER")
				.antMatchers("/medicaljournals/delete").hasAuthority("USER").antMatchers("/medicaljournals/search")
				.authenticated().antMatchers("/medicaljournals/subscribe").authenticated().and().formLogin()
				.loginPage("/login").loginProcessingUrl("/j_spring_security_check").usernameParameter("email")
				.passwordParameter("password").and().csrf().and().exceptionHandling()
				.accessDeniedPage("/pages/examples/404");

	}
}
