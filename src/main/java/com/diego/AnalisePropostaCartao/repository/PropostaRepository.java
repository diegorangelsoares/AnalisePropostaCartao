package com.diego.AnalisePropostaCartao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.diego.AnalisePropostaCartao.model.Cliente;
import com.diego.AnalisePropostaCartao.model.Proposta;

/**
 * Repositório de Propostas
 * @author Diego Rangel - diegorangeljpa@gmail.com
 */
@Repository
public interface PropostaRepository extends JpaRepository<Proposta, Integer>{

	//Proposta findByNome(String nome);
	
	Proposta findById(long id);
	
	@Query("SELECT u FROM Proposta u WHERE u.cliente.id = ?1")
	Proposta findByIdCliente(long id);
	
	//Proposta findByIdCliente (long cliente_id);
	
	//@Query("SELECT p FROM TAB_PROPOSTA p WHERE u.cliente_id = :id")
	//Proposta findByIdCliente(@Param("id") long id);
	

	/*
	@Query("SELECT c FROM Combustivel c WHERE LOWER(c.id)")
    List<Combustivel> findBySearchTerm(@Param("searchTerm") String searchTerm);
	
	@Query("SELECT u FROM User u WHERE u.status = :status and u.name = :name")
	User findUserByStatusAndNameNamedParams(@Param("status") Integer status, @Param("name") String name);
	
	@Query(value = "SELECT * FROM Users u WHERE u.status = :status and u.name = :name", nativeQuery = true)
	User findUserByStatusAndNameNamedParamsNative(@Param("status") Integer status, @Param("name") String name);
	
	@Query("SELECT u FROM User u WHERE u.status = 1")
	Collection<User> findAllActiveUsers();
	
	@Query("SELECT p FROM TAB_PROPOSTA p WHERE LOWER(p.cliente_id)")
	Proposta findByIdCliente(@Param("id") long id);
	
	@Query("SELECT u FROM User u WHERE u.status = ?1")
	User findUserByStatus(Integer status);
	 
	@Query("SELECT u FROM User u WHERE u.status = ?1 and u.name = ?2")
	User findUserByStatusAndName(Integer status, String name);
	
	*/
	
}
