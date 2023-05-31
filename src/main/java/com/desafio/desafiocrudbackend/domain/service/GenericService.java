package com.desafio.desafiocrudbackend.domain.service;

public interface GenericService<T, E> {
	 
	E save(T entity);
}
