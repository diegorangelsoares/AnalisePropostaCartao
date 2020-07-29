package com.diego.AnalisePropostaCartao.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.diego.AnalisePropostaCartao.erro.ResourceNotFoundDetails;
import com.diego.AnalisePropostaCartao.erro.ResourceNotFoundException;

/**
 * @author Diego Rangel - diegorangeljpa@gmail.com
 */
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundExcepition(ResourceNotFoundException rfnException){
		
		ResourceNotFoundDetails rDetails = ResourceNotFoundDetails.ResouceNotFoundDetailsBuilder
		.newBuilder()
		.timestamp(new Date().getTime())
		.status(HttpStatus.NOT_FOUND.value())
		.title("Resource Not Found")
		.detail(rfnException.getMessage())
		.developerMessage(rfnException.getClass().getName())
		.build();
		
		return new ResponseEntity<>(rDetails,HttpStatus.NOT_FOUND);
		
	}
}
