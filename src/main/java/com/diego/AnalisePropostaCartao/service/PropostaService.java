package com.diego.AnalisePropostaCartao.service;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diego.AnalisePropostaCartao.controller.DataController;
import com.diego.AnalisePropostaCartao.model.Proposta;
import com.diego.AnalisePropostaCartao.repository.PropostaRepository;

/**
 * Repositório de Propostas
 * @author Diego Rangel - diegorangeljpa@gmail.com
 */
@Service
public class PropostaService {

	@Autowired
	PropostaRepository PropostaRepository;
	
	DataController dataController = new DataController();
	
	//Negocio
	public Proposta cadastrar(Proposta Proposta) {
		if (Proposta.getData().contains("-")) {
			String data2 = Proposta.getData().substring(0, 9);
			data2 = dataController.transformaDataComIfemEmComBarraDDMMYYYY(data2);
			Proposta.setData(data2);
		}
		return PropostaRepository.save(Proposta);
	}
	
	public Collection<Proposta> buscarTodos(){
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
	
	public long retornaQuantidadeDePropostasCadastradas () {
		long quantidade = PropostaRepository.count();
		return quantidade;
	}
	
	public Proposta buscarPorIdCliente(long id) {
		System.out.println("Buscando proposta com idcliente "+id);
		List<Proposta> Propostas = PropostaRepository.findAll();
		Proposta pro = null;
		for (int i = 0; i < Propostas.size(); i++) {
			System.out.println("Proposta: "+Propostas.get(i).getId() +" IdCliente: "+id);
			if (Propostas.get(i).getCliente().getId() == id) {
				System.out.println("Achou proposta com idcliente "+id);
				pro = Propostas.get(i);
			}
		}
		return pro;
	}
		
	public Proposta alterar(Proposta Proposta) {
		return PropostaRepository.save(Proposta);
	}
	
}
