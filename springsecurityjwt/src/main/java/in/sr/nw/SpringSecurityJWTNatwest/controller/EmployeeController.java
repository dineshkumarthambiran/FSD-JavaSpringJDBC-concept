package in.sr.nw.SpringSecurityJWTNatwest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.sr.nw.SpringSecurityJWTNatwest.model.JWTRequest;
import in.sr.nw.SpringSecurityJWTNatwest.model.JWTResponse;
import in.sr.nw.SpringSecurityJWTNatwest.service.MyUserDetailsService;
import in.sr.nw.SpringSecurityJWTNatwest.util.JWTUtility;

@RestController
public class EmployeeController {
	
	@Autowired
	JWTUtility jwtUtility;
	
	@Autowired
	AuthenticationManager manager;
	
	@Autowired
	MyUserDetailsService userDetailsService;
	
	@GetMapping("/emp")
	public String getAnEmployee() {
		//Lets assume we get the data back from a service using a repository
		return "Id: 123, Name: Manish, Salary: 1234";
	}
	
	@GetMapping("/")
	public String sayHello() {
		return "Hello world";
	}
	
	@PostMapping("/login")
	public JWTResponse login(@RequestBody JWTRequest request) throws Exception {
		
		try {
			UsernamePasswordAuthenticationToken upToken = 
					new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword());
			manager.authenticate(upToken);
		}
		catch(BadCredentialsException e) {
			throw new Exception("WRONG_USER_NAME_PASSWORD");
		}
		
		UserDetails userDetail = userDetailsService.loadUserByUsername(request.getUserName());
		String token = jwtUtility.generateToken(userDetail);
		
		return new JWTResponse(token);
	}
}




