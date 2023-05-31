package com.desafio.desafiocrudbackend.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.desafio.desafiocrudbackend.domain.service.GenericService;

public class GenericController<S extends GenericService<F, E, ID>, E, F, ID> {
	
	@Autowired
	private S service;
	
	@GetMapping
	public ResponseEntity<List<E>> listAllEntities() {
		return ResponseEntity.ok().body(this.service.findAll());
	}
	
	@PostMapping
	public ResponseEntity<E> addEntity(@Validated @RequestBody F entityForm) {
		E entity = this.service.save(entityForm);
		return ResponseEntity.ok().body(entity);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<E> updateEntity(@PathVariable ID id, @RequestBody @Valid F entityForm) {
	     return ResponseEntity.ok().body(this.service.update(entityForm, id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCompany(@PathVariable ID id) {
		this.service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
