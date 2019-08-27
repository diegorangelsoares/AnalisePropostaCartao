package com.diego.AnalisePropostaCartao.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.diego.AnalisePropostaCartao.model.Usuario;
import com.diego.AnalisePropostaCartao.repository.UsuarioRepository;




@Service
public class UsuarioService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public Usuario cadastrar(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public Usuario buscarPorNome(String nome) {
		//return usuarioRepository.buscarPorNome(nome);
		return usuarioRepository.findByNome(nome);
	}
	
}
