package in.sr.nw.SpringSecurityJWTNatwest.model;

public class JWTResponse {
	private String jwtToken;

	public JWTResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JWTResponse(String jwtToken) {
		super();
		this.jwtToken = jwtToken;
	}

	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}
}
