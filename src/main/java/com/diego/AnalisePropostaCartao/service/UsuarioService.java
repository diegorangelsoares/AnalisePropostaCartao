package com.diego.AnalisePropostaCartao.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.diego.AnalisePropostaCartao.model.Cliente;
import com.diego.AnalisePropostaCartao.model.Usuario;
import com.diego.AnalisePropostaCartao.repository.UsuarioRepository;

/**
 * Repositório de usuarios
 * @author Diego Rangel - diegorangeljpa@gmail.com
 */
@Service
public class UsuarioService{
	
	@Autowired
	UsuarioRepository usuarioRepository;

	public Usuario cadastrar(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public Collection< Usuario> buscarTodos(){
		return usuarioRepository.findAll();
	}
	
	public Usuario buscarPorNome(String nome) {
		//System.out.println("Chamou oi buscarPorNome");
		return usuarioRepository.findByNome(nome);
	}
	
	public void excluir (Usuario usuario) {
		//System.out.println("Chamou funcao excluir Usuario");
		usuarioRepository.delete(usuario);
	}
	
	public Usuario buscarPorId(long id) {
		List<Usuario> usuarios = usuarioRepository.findAll();
		Usuario usu = null;
		for (int i = 0; i < usuarios.size(); i++) {
			if (usuarios.get(i).getId() == id) {
				usu = usuarios.get(i);
			}
		}
		return usu;
	}
		
	public Usuario alterar(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
}
