package com.diego.AnalisePropostaCartao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diego.AnalisePropostaCartao.model.Proposta;


@Repository
public interface PropostaRepository extends JpaRepository<Proposta, Integer>{

	//Proposta findByNome(String nome);
	
	Proposta findById(long id);
	

	
}
