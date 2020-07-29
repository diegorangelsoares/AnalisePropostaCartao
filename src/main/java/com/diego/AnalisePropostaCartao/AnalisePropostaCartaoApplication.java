package com.diego.AnalisePropostaCartao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.diego.AnalisePropostaCartao.controller.TokenFilter;

/**
 * Classe main do projeto
 * @author Diego Rangel - diegorangeljpa@gmail.com
 */
@SpringBootApplication
public class AnalisePropostaCartaoApplication {

	/**
	@Bean
	public FilterRegistrationBean filtroJwt() {
		FilterRegistrationBean frb = new FilterRegistrationBean();
		frb.setFilter(new TokenFilter());
		frb.addUrlPatterns("/admin/*");
		return frb;
		
	}
	*/
	
	public static void main(String[] args) {
		SpringApplication.run(AnalisePropostaCartaoApplication.class, args);
		System.out.println("\n <<<<< APLICAÇÃO ESTÁ EM EXECUÇÃO >>>>>\n" +
				"\n" +
				"Link de acesso ao Swagger http://localhost:8080/swagger-ui.html\n" +
				"\n" +
				"Link de acesso a interface Angular http://localhost:8080/#/\n" +
				"\n"+
				"\n" +
				"Link de teste http://api-diegorangel.ddns.net:8080/#/\n" +
				"\n");


	}

}
