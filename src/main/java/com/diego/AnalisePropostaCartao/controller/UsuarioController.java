package com.diego.AnalisePropostaCartao.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.diego.AnalisePropostaCartao.model.Usuario;
import com.diego.AnalisePropostaCartao.service.UsuarioService;

@RestController
@RequestMapping ("/admin")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;

	//End point
	@RequestMapping(method = RequestMethod.POST, value="/Usuarios",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario) {
		Usuario usuarioCadastrado = usuarioService.cadastrar(usuario);
		return new ResponseEntity<Usuario>(usuarioCadastrado, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/Usuarios",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection< Usuario>> buscarTodosUsuarios() {
		Collection< Usuario> UsuariosBuscados= usuarioService.buscarTodos();
		return new ResponseEntity<>(UsuariosBuscados, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/Usuarios/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection< Usuario>> excluirUsuario(@PathVariable Integer id) {
		Usuario UsuarioEncontrado = usuarioService.buscarPorId(id);
		if (UsuarioEncontrado == null) {
			//mensagem de nao encontrato
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			usuarioService.excluir(UsuarioEncontrado);
			return new ResponseEntity<>( HttpStatus.OK);
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/Usuarios/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> buscarUsuarioPorId(@PathVariable Integer id) {
		Usuario Usuario = usuarioService.buscarPorId(id);
		if (Usuario == null) {
			//mensagem de nao encontrato
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<>( Usuario,HttpStatus.OK);
		}
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/Usuarios",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> alterarUsuario(@RequestBody Usuario Usuario) {
		Usuario UsuarioAlterado = usuarioService.alterar(Usuario);		
		return new ResponseEntity<Usuario>(UsuarioAlterado, HttpStatus.OK);
	}

}
