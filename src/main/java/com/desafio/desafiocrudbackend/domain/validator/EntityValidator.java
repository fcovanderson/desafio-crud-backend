package com.desafio.desafiocrudbackend.domain.validator;

public interface EntityValidator<T>{
	void validate(T entity);
}
