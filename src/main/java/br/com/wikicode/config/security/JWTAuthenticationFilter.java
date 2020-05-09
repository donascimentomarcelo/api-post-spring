package br.com.wikicode.config.security;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.wikicode.dto.CredenciaisDTO;


public class JWTAuthenticationFilter  extends UsernamePasswordAuthenticationFilter {

	private AuthenticationManager authenticationManager;

	private JWTUtil jwtUtil;

	public JWTAuthenticationFilter(AuthenticationManager authenticationManager, JWTUtil jwtUtil) {
		super();
 		this.authenticationManager = authenticationManager;
 		this.jwtUtil = jwtUtil;
	}

	@Override
	 public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) throws AuthenticationException {
		try {

			CredenciaisDTO credenciaisDTO = new ObjectMapper()
					.readValue(req.getInputStream(), CredenciaisDTO.class);

			UsernamePasswordAuthenticationToken token = 
					new UsernamePasswordAuthenticationToken(credenciaisDTO.getUsername(), credenciaisDTO.getPassword(), new ArrayList<>());

			Authentication authentication = authenticationManager.authenticate(token);

			return authentication;

		}catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest req, 
											HttpServletResponse res,
											FilterChain chain,
											Authentication auth) throws IOException, ServletException{

		String username = ((UserSpringSecurity) auth.getPrincipal()).getUsername();
		Integer id = ((UserSpringSecurity) auth.getPrincipal()).getId();
		String token = jwtUtil.generateToken(username);
		res.addHeader("Authorization", "Bearer " + token);
		res.addHeader("access-control-expose-headers", "Authorization");
		res.addHeader("username", username);
		res.addHeader("id", Integer.toString(id));
	}
}
