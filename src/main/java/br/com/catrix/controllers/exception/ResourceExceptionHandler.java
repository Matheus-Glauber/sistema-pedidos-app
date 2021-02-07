package br.com.catrix.controllers.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.catrix.services.exception.IntegradadeDeDadosException;
import br.com.catrix.services.exception.NegocioNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(value = {
			NegocioNotFoundException.class
	})
	public ResponseEntity<PadraoError> negocioNotFound(NegocioNotFoundException e, HttpServletRequest request) {
		PadraoError err = new PadraoError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
	
	@ExceptionHandler(value = {
			DataIntegrityViolationException.class
	})
	public ResponseEntity<PadraoError> dataIntegrity(IntegradadeDeDadosException e, HttpServletRequest request) {
		PadraoError err = new PadraoError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
	
	@ExceptionHandler(value = {
			MethodArgumentNotValidException.class
	})
	public ResponseEntity<PadraoError> validacao(MethodArgumentNotValidException e, HttpServletRequest request) {
		ValidationError err = new ValidationError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
		
		for (FieldError error : e.getBindingResult().getFieldErrors()) {
			err.addError(error.getField(), error.getDefaultMessage());
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}

}
