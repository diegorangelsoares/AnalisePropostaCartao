package com.diego.AnalisePropostaCartao.resources;

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
import com.diego.AnalisePropostaCartao.repository.ClienteRepository;

/**Classe de tratamentos do Cliente
* @author Diego Rangel
*/
@RestController
@RequestMapping(value="/api")
@CrossOrigin(origins="*")
public class ClienteResource {

		@Autowired
		private ClienteRepository uRepository;
		
		@GetMapping(path="Clientes")
		public ResponseEntity<?> listAll(Pageable pageable){
			return new ResponseEntity<>(uRepository.findAll(pageable),HttpStatus.OK);
		}
		
		@GetMapping( path="Clientes/{id}")
		public ResponseEntity<?> getclisById(@PathVariable("id") long id){
			verifyIfclisExists(id);
			Cliente cli = uRepository.findById(id);
			return new ResponseEntity<>(cli,HttpStatus.OK);
		}
		
		@PostMapping(path="Clientes")
		public ResponseEntity<?> save(@Validated @RequestBody Cliente cli){
			uRepository.save(cli);
			return new ResponseEntity<>(cli,HttpStatus.OK);
		}
		
		@DeleteMapping(path="Clientes/{id}")
		public ResponseEntity<?> delete(@PathVariable(name="id") long id){
			verifyIfclisExists(id);
			Cliente cli = uRepository.findById(id);
			uRepository.delete(cli);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
		@PutMapping(path="Clientes")
		public ResponseEntity<?> update(@RequestBody Cliente cli){
			verifyIfclisExists(cli.getId());
			uRepository.save(cli);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
		private void verifyIfclisExists(long id){
			if(uRepository.findById(id) == null)
				throw new ResourceNotFoundException("Cliente não encontrado para o Id: " + id);
		}
	
}
