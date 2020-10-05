package com.diego.AnalisePropostaCartao.resources;

import com.diego.AnalisePropostaCartao.model.Endereco;
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
        Endereco endereco = null;
        try {
            endereco = enderecoService.retornaEndereco(cep);
            return new ResponseEntity<>(endereco, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

}
