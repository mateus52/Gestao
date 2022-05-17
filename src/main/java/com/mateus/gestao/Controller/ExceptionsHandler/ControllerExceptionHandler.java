package com.mateus.gestao.Controller.ExceptionsHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mateus.gestao.Service.Exceptions.ObjectNotFoundException;
import com.mateus.gestao.Service.Exceptions.StandardError;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFoundException(ObjectNotFoundException e){
		
	StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(),
			e.getMessage());
	
	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
}
