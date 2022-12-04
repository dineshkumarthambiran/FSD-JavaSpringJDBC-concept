package in.sr.nw.SpringSecurityJWTNatwest.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// Will write the code to read data from database table (credentials ---> username and password)
		// Store the password after encryption (BCrypt)
		return new User("bharathy", "password", new ArrayList<>());
	}

}
