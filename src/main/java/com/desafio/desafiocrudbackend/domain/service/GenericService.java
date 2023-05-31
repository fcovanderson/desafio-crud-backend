package com.desafio.desafiocrudbackend.domain.service;

import java.util.List;

public interface GenericService<F, E, ID> {
	 
	E save(F entity);
	
	List<E> findAll();
	
	E update(F formEntity, ID id);
	
	void delete(ID id);
}
