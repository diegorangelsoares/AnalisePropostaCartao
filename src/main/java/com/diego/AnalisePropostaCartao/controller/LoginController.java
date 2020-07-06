package com.diego.AnalisePropostaCartao.controller;

import java.security.Key;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.servlet.ServletException;
import javax.xml.bind.DatatypeConverter;
import javax.xml.crypto.AlgorithmMethod;

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

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;


@RestController
public class LoginController {
	
	@Autowired
	UsuarioService usuarioService;
	
	ConvertPasswordToMD5 convertPasswordToMD5 = new ConvertPasswordToMD5();
		
	//End point
	@RequestMapping(method = RequestMethod.POST, value="/autenticar",consumes = MediaType.APPLICATION_JSON_VALUE)
	public loginResponse autenticar(@RequestBody Usuario usuario) throws ServletException {

		//System.out.println("Usuario: "+usuario.getNome());
		if ( usuario.getNome() == null) {
			throw new ServletException("Nome e senha obrigatório.");
		}
		Usuario usuarioAutenticado = usuarioService.buscarPorNome(usuario.getNome());
		//System.out.println("Chama a funcao usuarioService.buscarPorNome(usuario.getNome()) Resultado Usuario: "+usuarioAutenticado.getNome()+" Senha: "+usuarioAutenticado.getSenha());
		
		//consulta no banco
		//System.out.println("Usuario: "+usuario.getNome());
		if (usuarioAutenticado == null) {
			throw new ServletException("Usuário não encontrado.");
		}
		//Verificando senha criptografada
		//if (!convertPasswordToMD5.encripta(usuarioAutenticado.getSenha()).equals(convertPasswordToMD5.encripta(usuario.getSenha()))) {
		if (!usuarioAutenticado.getSenha().equals(usuario.getSenha())) {
			throw new ServletException("Usuário ou senha inválido.");
		}

		//String token = Jwts.builder().setSubject(usuarioAutenticado.getNome()).signWith(SignatureAlgorithm.HS256, "diegorangeldoareasdlskmadlkdmsalsdlskmadlkdmsal").setExpiration(new Date(System.currentTimeMillis() + 500 * 60 * 1000)).compact();
		//return new loginResponse(token);
		//return new loginResponse(token, usuario);
		
		Usuario usu = usuarioService.buscarPorNome(usuario.getNome());
		return new loginResponse(usu);
		//return usuario;
	}
	
	
		
		

}
