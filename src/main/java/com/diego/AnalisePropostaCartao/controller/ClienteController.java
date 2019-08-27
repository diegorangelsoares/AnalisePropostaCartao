package com.diego.AnalisePropostaCartao.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.diego.AnalisePropostaCartao.model.Cliente;
import com.diego.AnalisePropostaCartao.service.ClienteService;

//@RequestMapping ("/admin")


@RestController
@RequestMapping ("/admin")
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;

	//End point
	@RequestMapping(method = RequestMethod.POST, value="/clientes",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente) {
		Cliente clienteCadastrado = clienteService.cadastrar(cliente);
		return new ResponseEntity<Cliente>(clienteCadastrado, HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/clientes",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection< Cliente>> buscarTodosClientes() {
		Collection< Cliente> clientesBuscados= clienteService.buscarTodos();
		return new ResponseEntity<>(clientesBuscados, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/clientes/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection< Cliente>> excluirCliente(@PathVariable Integer id) {
		
		Cliente clienteEncontrado = clienteService.buscarPorId(id);
		if (clienteEncontrado == null) {
			//mensagem de nao encontrato
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			clienteService.excluir(clienteEncontrado);
			return new ResponseEntity<>( HttpStatus.OK);
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/clientes/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> buscarClientePorId(@PathVariable Integer id) {
		Cliente cliente = clienteService.buscarPorId(id);
		if (cliente == null) {
			//mensagem de nao encontrato
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<>( cliente,HttpStatus.OK);
		}
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/clientes",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> alterarCliente(@RequestBody Cliente cliente) {
		Cliente clienteAlterado = clienteService.alterar(cliente);		
		return new ResponseEntity<Cliente>(clienteAlterado, HttpStatus.OK);
	}
	
	/**
	//End point TESTE
	@RequestMapping(method = RequestMethod.GET, value="/clientes")
	public void busca() {
		System.out.println("Deu certo");
	}
	*/

}
