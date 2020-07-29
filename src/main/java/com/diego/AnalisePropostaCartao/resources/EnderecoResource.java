package com.diego.AnalisePropostaCartao.resources;

import com.diego.AnalisePropostaCartao.model.Cliente;
import com.diego.AnalisePropostaCartao.model.Endereco;
import com.diego.AnalisePropostaCartao.service.ClienteService;
import com.diego.AnalisePropostaCartao.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**Classe de tratamentos do Endereco
 * @author Diego Rangel
 */
@RestController
@RequestMapping(value="/api")
@CrossOrigin(origins="*")
public class EnderecoResource {

    @Autowired
    EnderecoService enderecoService;

    //Endpoint do swagger
    @GetMapping( path="Endereco/{cep}")
    public ResponseEntity<?> getEnderecoPorCEP(@PathVariable("cep") long cep){
        //verifyIfclisExists(id);
        //Endereco endereco = new Endereco();
        Endereco endereco = enderecoService.retornaEndereco(cep);
        return new ResponseEntity<>(endereco, HttpStatus.OK);
    }

}
