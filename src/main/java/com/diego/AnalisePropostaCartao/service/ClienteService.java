package com.diego.AnalisePropostaCartao.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diego.AnalisePropostaCartao.erro.ResourceNotFoundException;
import com.diego.AnalisePropostaCartao.model.Cliente;
import com.diego.AnalisePropostaCartao.model.Proposta;
import com.diego.AnalisePropostaCartao.repository.ClienteRepository;
import com.diego.AnalisePropostaCartao.repository.PropostaRepository;

/**
 * Service de clientes
 * @author Diego Rangel - diegorangeljpa@gmail.com
 */
@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	PropostaRepository propostaRepository;
		
	//Negocio
	public Cliente cadastrar(Cliente cliente) {
		Cliente cliNovo = clienteRepository.findByCpf(cliente.getCpf());
		System.out.println("Chamou funcao Cadastrar cliente");
		if (cliNovo == null){
			System.out.println("Não existe cliente com esse CPF");
			return clienteRepository.save(cliente);
		}else{
			System.out.println("Existe cliente com esse CPF");
			throw new ResourceNotFoundException("Já existe um cliente com esse CPF cadastrado!");
		}

	}
	
	public Collection< Cliente> buscarTodos(){
		return clienteRepository.findAll();
	}
	
	public void excluir (Cliente cliente) {
		//System.out.println("Chamou funcao excluir cliente");
		verificaSeTemContrato(cliente.getId());
		clienteRepository.delete(cliente);
	}
	
	public Cliente buscarPorId(long id) {
		Cliente cliente = clienteRepository.findById(id);
		return cliente;
	}
		
	public Cliente alterar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public Proposta buscarPropostasPorIdCliente(long id) {
		List<Proposta> Propostas = propostaRepository.findAll();
		Proposta pro = null;
		for (int i = 0; i < Propostas.size(); i++) {
			if (Propostas.get(i).getCliente().getId() == id) {
				pro = Propostas.get(i);
			}
		}
		return pro;
	}
	
	public void verificaSeTemContrato(long idCliente){
		Proposta pro = buscarPropostasPorIdCliente(idCliente);
		if(pro == null) {
			System.out.println("Cliente não possui contrato");
		}else {
			//System.out.println("Cliente possui contrato e não pode ser excluido. Contrato: " + pro.getId());
			throw new ResourceNotFoundException("Cliente possui contrato e não pode ser excluido. Contrato: " + pro.getId());
		}
	}
	
}
