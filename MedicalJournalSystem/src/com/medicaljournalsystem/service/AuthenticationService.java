package com.medicaljournalsystem.service;

import java.util.ArrayList;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("authenticationService")
public class AuthenticationService implements UserDetailsService {

	@Autowired
	private UsersService userService;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		com.medicaljournalsystem.pojo.Users user = userService.findByEmail(email);

		if (user != null) {

			if (user.getUserRole().equalsIgnoreCase("PUBLISHER")) {

				try {
					Collection<GrantedAuthority> userAuthorities = new ArrayList<GrantedAuthority>();
					userAuthorities.add(new SimpleGrantedAuthority("PUBLISHER"));
					return new User(user.getEmail(), user.getPassword(), true, true, true, true, userAuthorities);

				} catch (Exception e) {
					throw new UsernameNotFoundException("Username " + user.getEmail() + " not found!");
				}

			} else {
				try {

					Collection<GrantedAuthority> userAuthorities = new ArrayList<GrantedAuthority>();
					userAuthorities.add(new SimpleGrantedAuthority("USER"));
					return new User(user.getEmail(), user.getPassword(), true, true, true, true, userAuthorities);

				} catch (Exception e) {
					throw new UsernameNotFoundException("Username " + user.getEmail() + " not found!");
				}
			}

		}
		return null;
	}

}
