package com.diego.AnalisePropostaCartao.service;

import com.diego.AnalisePropostaCartao.model.Cliente;
import com.diego.AnalisePropostaCartao.model.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Service de Endereço
 * @author Diego Rangel - diegorangeljpa@gmail.com
 */
@Service
public class EnderecoService {

    public void buscarPorId(long id) {
        System.out.println("Chamou o buscarPorId");
    }

    public Endereco retornaEndereco(long cep){
        Endereco endereco = new Endereco();
        String json = buscarCepNaAPI(cep+"");
        System.out.println(json);

        Map<String,String> mapa = new HashMap<>();

        Matcher matcher = Pattern.compile("\"\\D.*?\": \".*?\"").matcher(json);
        while (matcher.find()) {
            String[] group = matcher.group().split(":");
            mapa.put(group[0].replaceAll("\"", "").trim(), group[1].replaceAll("\"", "").trim());
        }

        //System.out.println(mapa);
        Set<String> campos = mapa.keySet();

        for (Map.Entry<String, String> entrada : mapa.entrySet()) {
            if (entrada.getKey().equals("logradouro")){
                endereco.setLogradouro(entrada.getValue());
            }
            if (entrada.getKey().equals("complemento")){
                endereco.setComplemento(entrada.getValue());
            }
            if (entrada.getKey().equals("bairro")){
                endereco.setBairro(entrada.getValue());
            }
            if (entrada.getKey().equals("localidade")){
                endereco.setLocalidade(entrada.getValue());
            }
            if (entrada.getKey().equals("uf")){
                endereco.setUf(entrada.getValue());
            }
            if (entrada.getKey().equals("unidade")){
                endereco.setUnidade(entrada.getValue());
            }
            if (entrada.getKey().equals("ibge")){
                endereco.setIbge(entrada.getValue());
            }
            if (entrada.getKey().equals("gia")){
                endereco.setGia(entrada.getValue());
            }
            endereco.setLogradouro(cep+"");
        }
        return endereco;
    }

    public static String buscarCepNaAPI(String cep) {
        String json;

        try {
            URL url = new URL("http://viacep.com.br/ws/"+ cep +"/json");
            URLConnection urlConnection = url.openConnection();
            InputStream is = urlConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            StringBuilder jsonSb = new StringBuilder();

            br.lines().forEach(l -> jsonSb.append(l.trim()));

            json = jsonSb.toString();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return json;
    }


}
