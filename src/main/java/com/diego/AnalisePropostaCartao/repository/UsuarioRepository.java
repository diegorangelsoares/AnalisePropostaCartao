package com.diego.AnalisePropostaCartao.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.diego.AnalisePropostaCartao.model.Usuario;

/**
 * Repositório de usuários
 * @author Diego Rangel - diegorangeljpa@gmail.com
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	/**
	@Query(value="select u from tab_usuario u where u.nome=:pnome")
	public Usuario buscarPorNome(@Param("pnome") String nome);
	*/
	
	Usuario findByNome(String nome);
	
	Usuario findById(long id);

		
	
	
}
