package com.desafio.desafiocrudbackend.domain.exception;

public class UnderAgeException extends BusinessException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UnderAgeException(String message) {
		super(message);
	}
}
