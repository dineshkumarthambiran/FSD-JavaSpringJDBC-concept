package in.sr.nw.SpringSecurityJWTNatwest.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import in.sr.nw.SpringSecurityJWTNatwest.service.MyUserDetailsService;
import in.sr.nw.SpringSecurityJWTNatwest.util.JWTUtility;

@Component
public class JWTFilter extends OncePerRequestFilter{

	@Autowired
	JWTUtility jwtUtil; 
	//Filters in java has doFilterInterval(HttpServletRequest request, HttpServletResponse resp, FilterChain)
		//request ---> Carries jwt token in the header
	
	@Autowired
	MyUserDetailsService userDeatilsService;
	
	@Override
	protected void doFilterInternal
	(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String token = null;
		String userName = null;
//		To extract the Authorization token from the HttpRequest object
		String authorization = request.getHeader("Authorization");
		
//		Validating if the header is not null and valid
		if(authorization != null && authorization.startsWith("Bearer ")) {
//			Extracting the token from authorization header string
			token = authorization.substring(7);
//			Extracting the userName from the token
			userName = jwtUtil.getUsernameFromToken(token);
		}
		
//		Checking if the userName is not null and the authentication is not done yet
		if(userName!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
//		Creating UserDetails object to pass in the arguments of the validate token
			UserDetails userDetails = userDeatilsService.loadUserByUsername(userName);
//			Validating the UserDetails comparing to the JWT Token
			if(jwtUtil.validateToken(token, userDetails)) {
//				If valid then generating UserNamePasswordAuthenticationToken to denote that the user is authenticated
				UsernamePasswordAuthenticationToken upToken =
						new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//			To convert the http servlet request compatibil to spring boot context
				WebAuthenticationDetails webAuthDetails = new WebAuthenticationDetailsSource().buildDetails(request);
//			Injecting the details to the UsernamePasswordAuthenticationToken
				upToken.setDetails(webAuthDetails);
				
//			Injecting the UsernamePasswordAuthenticationToken into the SecurityContextHolder
				SecurityContextHolder.getContext().setAuthentication(upToken);
			}
//			After the filter process is over forward the request to the next element in the chain
			filterChain.doFilter(request, response);
		}
	}

	
}
