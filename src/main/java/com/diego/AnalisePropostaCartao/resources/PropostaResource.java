package com.diego.AnalisePropostaCartao.resources;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.diego.AnalisePropostaCartao.service.PropostaService;
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
import com.diego.AnalisePropostaCartao.model.Proposta;
import com.diego.AnalisePropostaCartao.model.Usuario;
import com.diego.AnalisePropostaCartao.repository.PropostaRepository;
import com.diego.AnalisePropostaCartao.repository.UsuarioRepository;


/**Classe de tratamentos do Proposta
* @author Diego Rangel
*/
@RestController
@RequestMapping(value="/api")
@CrossOrigin(origins="*")
public class PropostaResource {

	@Autowired
	private PropostaService propostaService;
	//private PropostaRepository uRepository;

	@GetMapping(path="Propostas")
	public ResponseEntity<?> listAll(Pageable pageable){
		return new ResponseEntity<>(propostaService.buscarTodos(),HttpStatus.OK);
	}
	
	@GetMapping(path="CountPropostas")
	public ResponseEntity<?> countPropostas (Pageable pageable){
		long quant = 0;
		Collection<Proposta> propostas = propostaService.buscarTodos();
		for (int i = 0; i < propostas.size(); i++) {
			quant++;
		}
		return new ResponseEntity<>(quant,HttpStatus.OK);
	}
	
	
	/**Código para retornar historico
	* @author Diego Rangel
	* @return String - Retorna uma lista de historico
	*/
	/*
	@GetMapping( path="combustiveis/")
	public ResponseEntity<?> getHitoricoCombustivel(){
		List <Combustivel> combustiveis = cRepository.findAll();
		List <String> historico = new ArrayList<>();
		for (int i = 0; i < combustiveis.size(); i++) {
			historico.add("Data da Coleta:"+combustiveis.get(i).getDataDaColeta() + " Preço de Venda: "+combustiveis.get(i).getValorDaVenda());
		}
		return new ResponseEntity<>(historico	,HttpStatus.OK);
	}
	 */
	
	@GetMapping( path="Propostas/{id}")
	public ResponseEntity<?> getprosById(@PathVariable("id") long id){
		verifyIfprosExists(id);
		Proposta pro = propostaService.buscarPorId(id);
		return new ResponseEntity<>(pro,HttpStatus.OK);
	}
	
	@PostMapping(path="Propostas")
	public ResponseEntity<?> save(@Validated @RequestBody Proposta pro){
		propostaService.cadastrar(pro);
		return new ResponseEntity<>(pro,HttpStatus.OK);
	}
	
	@DeleteMapping(path="Propostas/{id}")
	public ResponseEntity<?> delete(@PathVariable(name="id") long id){
		verifyIfprosExists(id);
		Proposta pro = propostaService.buscarPorId(id);
		propostaService.excluir(pro);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping(path="Propostas")
	public ResponseEntity<?> update(@RequestBody Proposta pro){
		verifyIfprosExists(pro.getId());
		propostaService.cadastrar(pro);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping(path="AprovaProposta")
	public ResponseEntity<?> AprovaProposta(@RequestBody Proposta pro){
		verifyIfprosExists(pro.getId());
		pro.setStatusProposta("aprovada");
		propostaService.cadastrar(pro);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping(path="AprovaSPCProposta")
	public ResponseEntity<?> AprovaSPCProposta(@RequestBody Proposta pro){
		verifyIfprosExists(pro.getId());
		pro.setStatusSPC("aprovada");
		propostaService.cadastrar(pro);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping(path="AprovaDocumentosProposta")
	public ResponseEntity<?> AprovaDocumentosProposta(@RequestBody Proposta pro){
		verifyIfprosExists(pro.getId());
		pro.setStatusDocumentos("aprovada");
		propostaService.cadastrar(pro);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	private void verifyIfprosExists(long id){
		if(propostaService.buscarPorId(id) == null)
			throw new ResourceNotFoundException("Proposta não encontrado para o Id: " + id);
	}
	
	
	
}
