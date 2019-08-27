package com.diego.AnalisePropostaCartao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.diego.AnalisePropostaCartao.model.Usuario;
import com.diego.AnalisePropostaCartao.service.UsuarioService;



@RestController
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;

	//End point
	@RequestMapping(method = RequestMethod.POST, value="/usuarios",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario) {
		Usuario usuarioCadastrado = usuarioService.cadastrar(usuario);
		return new ResponseEntity<Usuario>(usuarioCadastrado, HttpStatus.OK);
	}

}
