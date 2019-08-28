package com.diego.AnalisePropostaCartao.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diego.AnalisePropostaCartao.model.Proposta;
import com.diego.AnalisePropostaCartao.repository.PropostaRepository;

@Service
public class PropostaService {

	@Autowired
	PropostaRepository PropostaRepository;
	
	//Negocio
	public Proposta cadastrar(Proposta Proposta) {
		return PropostaRepository.save(Proposta);
	}
	
	public Collection< Proposta> buscarTodos(){
		return PropostaRepository.findAll();
	}
	
	public void excluir (Proposta Proposta) {
		PropostaRepository.delete(Proposta);
	}
	
	public Proposta buscarPorId(long id) {
		List<Proposta> Propostas = PropostaRepository.findAll();
		Proposta pro = null;
		for (int i = 0; i < Propostas.size(); i++) {
			if (Propostas.get(i).getId() == id) {
				pro = Propostas.get(i);
			}
		}
		return pro;
	}
		
	public Proposta alterar(Proposta Proposta) {
		return PropostaRepository.save(Proposta);
	}
	
}
