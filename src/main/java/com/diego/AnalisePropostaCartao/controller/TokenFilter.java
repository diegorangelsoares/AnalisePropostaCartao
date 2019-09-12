package com.diego.AnalisePropostaCartao.controller;

import java.io.Console;
import java.io.IOException;
import java.security.Key;

import javax.servlet.FilterChain;
import javax.servlet.GenericFilter;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.filter.GenericFilterBean;

//import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;


//public class TokenFilter extends GenericFilterBean{
public class TokenFilter  {
	/**
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		String header = req.getHeader("Authorization");
		// header esta vindo null mesmo enviando null <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< ver isso aqui pq ta vindo do postman
		if (header == null || !header.startsWith("Bearer ")) {
			throw new ServletException("Token inexistente ou inválido.");
		}
		
		String token = header.substring(7); //extraindo so o token
	
		//verificar token
		try {
		Jwts.parser().setSigningKey("diegorangeldoareasdlskmadlkdmsalsdlskmadlkdmsal").parseClaimsJws(token).getBody();
		//Jwts.parser().setSigningKey(key).parseClaimsJws(token);
		//Jwts.parser().setSigningKey(key).parseClaimsJws(jws).getBody()

		}catch (JwtException  e) {
		//}catch (SignatureException e) {
			throw new ServletException("Token inválido.");
		}
		
		chain.doFilter(request, response);
			
	}
	*/

}
