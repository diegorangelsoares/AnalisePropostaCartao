package com.diego.AnalisePropostaCartao.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diego.AnalisePropostaCartao.erro.ResourceNotFoundException;
import com.diego.AnalisePropostaCartao.model.Cliente;
import com.diego.AnalisePropostaCartao.model.Usuario;
import com.diego.AnalisePropostaCartao.repository.UsuarioRepository;

/**Classe de tratamentos do usuario
* @author Diego Rangel
*/
@RestController
@RequestMapping(value="/api")
@CrossOrigin(origins="*")
public class UsuarioResource {
	
	@Autowired
	private UsuarioRepository uRepository;
	
	@GetMapping(path="Usuarios")
	public ResponseEntity<?> listAll(Pageable pageable){
		return new ResponseEntity<>(uRepository.findAll(pageable),HttpStatus.OK);
	}
	
	@GetMapping( path="Usuarios/{id}")
	public ResponseEntity<?> getUsersById(@PathVariable("id") long id){
		verifyIfUsersExists(id);
		Usuario user = uRepository.findById(id);
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	@GetMapping(path="CountUsuarios")
	public ResponseEntity<?> countUsuarios (Pageable pageable){
		long quant = 0;
		List <Usuario> Usuarios = uRepository.findAll();
		for (int i = 0; i < Usuarios.size(); i++) {
			quant++;
		}
		return new ResponseEntity<>(quant,HttpStatus.OK);
	}
	
	@PostMapping(path="Usuarios")
	public ResponseEntity<?> save(@Validated @RequestBody Usuario user){
		uRepository.save(user);
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	@DeleteMapping(path="Usuarios/{id}")
	public ResponseEntity<?> delete(@PathVariable(name="id") long id){
		verifyIfUsersExists(id);
		Usuario user = uRepository.findById(id);
		uRepository.delete(user);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping(path="Usuarios")
	public ResponseEntity<?> update(@RequestBody Usuario user){
		verifyIfUsersExists(user.getId());
		uRepository.save(user);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	private void verifyIfUsersExists(long id){
		if(uRepository.findById(id) == null)
			throw new ResourceNotFoundException("Usuario não encontrado para o Id: " + id);
	}

}
