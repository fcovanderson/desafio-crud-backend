package com.desafio.desafiocrudbackend.domain.exception;

import java.time.Instant;
import java.util.Locale;
import java.util.NoSuchElementException;

import javax.servlet.http.HttpServletRequest;

import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@Autowired
	private MessageSource messageSource;
	
	@ExceptionHandler(PSQLException.class)
	public ResponseEntity<StandardError> entityAlreadRegistered(PSQLException exception, HttpServletRequest request){ 
		String message = this.messageSource.getMessage("message.exception.entity.alread.registered", null, Locale.getDefault());
		HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		return ResponseEntity.status(httpStatus).body(this.standardErrorFactory(httpStatus, message, exception, request));
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> methodArgumentNotValid(MethodArgumentNotValidException exception, HttpServletRequest request){ 
		String message = this.messageSource.getMessage("message.exception.invalide.params.resume", null, Locale.getDefault());
		HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
		return ResponseEntity.status(httpStatus).body(this.standardErrorFactory(httpStatus, message, exception, request));
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<StandardError> entityToUpdateNotFound(NoSuchElementException exception, HttpServletRequest request){ 
		String message = this.messageSource.getMessage("message.exception.entity.not.found", null, Locale.getDefault());
		HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		return ResponseEntity.status(httpStatus).body(this.standardErrorFactory(httpStatus, message, exception, request));
	}
	
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<StandardError> entityToUpdateNotFound(EmptyResultDataAccessException exception, HttpServletRequest request){ 
		String message = this.messageSource.getMessage("message.exception.entity.not.found", null, Locale.getDefault());
		HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		return ResponseEntity.status(httpStatus).body(this.standardErrorFactory(httpStatus, message, exception, request));
	}
	
	private StandardError standardErrorFactory(HttpStatus httpStatus, String mensagem, Exception exception, HttpServletRequest request) {
		StandardError error = new StandardError();
		error.setTimestamp(Instant.now());
		error.setStatus(httpStatus.value());
		error.setError(mensagem);
		error.setMessage(exception.getMessage());
		error.setPath(request.getRequestURI());
		return error;
	}
}
