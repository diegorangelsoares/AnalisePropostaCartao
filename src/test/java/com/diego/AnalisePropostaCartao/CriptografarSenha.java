package com.diego.AnalisePropostaCartao;

import com.diego.AnalisePropostaCartao.controller.ConvertPasswordToMD5;

public class CriptografarSenha {



    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ConvertPasswordToMD5 convertPasswordToMD5 = new ConvertPasswordToMD5();

        // TODO code application logic here
        String senha = "123";
        System.out.println("Senha normal: " + senha);
        senha = convertPasswordToMD5.encripta(senha);
        System.out.println("Senha encriptada: " + senha);

    }

}

/*
2ETIPWZa1R4+LJRW3nahQw==
        Senha digitada: 123
        Senha digitada criptografada: ICy5YqxZB1uWSwcVLSNLcA==
        */
