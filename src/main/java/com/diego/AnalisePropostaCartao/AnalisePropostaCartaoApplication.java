package com.diego.AnalisePropostaCartao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.diego.AnalisePropostaCartao.controller.TokenFilter;


@SpringBootApplication
public class AnalisePropostaCartaoApplication {

	@Bean
	public FilterRegistrationBean filtroJwt() {
		FilterRegistrationBean frb = new FilterRegistrationBean();
		frb.setFilter(new TokenFilter());
		frb.addUrlPatterns("/admin/*");
		return frb;
		
	}
	
	public static void main(String[] args) {
		SpringApplication.run(AnalisePropostaCartaoApplication.class, args);
	}

}
