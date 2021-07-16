package com.diego.AnalisePropostaCartao.controller;

import com.diego.AnalisePropostaCartao.model.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.security.MessageDigest;
//import sun.misc.BASE64Encoder;
//import Decoder.BASE64Decoder;

import java.security.NoSuchAlgorithmException;
import java.util.Date;

/**
 * Tratamento de criptografia
 * @author Diego Rangel - diegorangeljpa@gmail.com
 */
public class ConvertPasswordToMD5 {

	public ConvertPasswordToMD5() {
		
	}
	
	public String encripta (String senha) {     
        try {     
             MessageDigest digest = MessageDigest.getInstance("MD5");
             digest.update(senha.getBytes());
//             return Jwts.builder()
//                     .setIssuedAt(new Date(System.currentTimeMillis()))
//                     .setSubject(senha)
//                     .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
//                     .signWith(SignatureAlgorithm.HS256, key)
//                     .compact();
            return senha;
        } catch (NoSuchAlgorithmException ns) {     
             ns.printStackTrace ();      
             return senha;      
        }      
   }

//    public String generateToken(Usuario user) {
//        return Jwts.builder()
//                .setIssuedAt(new Date(System.currentTimeMillis()))
//                //.setSubject("Teste JWT API")
//                .setSubject(user.getNome())
//                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
//                .signWith(SignatureAlgorithm.HS256, key)
//                .compact();
//    }
//
//    public Claims decodeToken(String token) {
//        return Jwts.parser()
//                .setSigningKey(key)
//                .parseClaimsJws(token)
//                .getBody();
//    }

}
