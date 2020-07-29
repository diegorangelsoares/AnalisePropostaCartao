package com.diego.AnalisePropostaCartao.controller;

import com.diego.AnalisePropostaCartao.model.Cliente;
import com.diego.AnalisePropostaCartao.model.Endereco;
import com.diego.AnalisePropostaCartao.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller de Endereço
 * @author Diego Rangel - diegorangeljpa@gmail.com
 */
//@RequestMapping ("/admin")
@RestController
@RequestMapping ("/")
public class EnderecoController {

    /*
    @Autowired
    EnderecoService enderecoService;

    @RequestMapping(method = RequestMethod.GET, value="/endereco/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Endereco> buscarEnderecoPorId(@PathVariable Integer id) {
        enderecoService.buscarPorId(id);
        Endereco endereco = new Endereco();
        /*
        if (cliente == null) {
            //mensagem de nao encontrato
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>( cliente,HttpStatus.OK);
        }

         */
        //return new ResponseEntity<>( endereco,HttpStatus.OK);
    //}



}
