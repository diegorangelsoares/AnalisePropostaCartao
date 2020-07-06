package com.diego.AnalisePropostaCartao.controller;

import com.diego.AnalisePropostaCartao.model.Usuario;

public class loginResponse {

	//public String token;
	
	public Usuario usuario;
	
	public loginResponse(Usuario usuario) {
		this.usuario = usuario;
	}
	
	/**
	public loginResponse(String token) {
		this.token = token;
	}
	
	public loginResponse(String token, Usuario usuario) {
		this.token = token;
		this.usuario = usuario;
	}
	
	public String getToken() {
		return token;
	}
	
	public void setToken(String token) {
		this.token = token;
	}
	*/

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
