package com.desafio.desafiocrudbackend.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.desafiocrudbackend.api.dto.form.CompanySupplierForm;
import com.desafio.desafiocrudbackend.domain.entity.CompanySupplier;
import com.desafio.desafiocrudbackend.domain.service.CompanySupplierService;


@RestController
@RequestMapping("/api/v1/relationship")
public class CompanySupplierController {
	
	@Autowired
	protected CompanySupplierService companySupplierService;
	
	@PostMapping
	public ResponseEntity<CompanySupplier> addCompanySupplierRelationship(@Validated @RequestBody CompanySupplierForm companySupplierForm) {
		CompanySupplier entity = this.companySupplierService.save(companySupplierForm);
		return ResponseEntity.ok().body(entity);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCompanySuplierRelationship(@PathVariable Long id) {
		this.companySupplierService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping
	public ResponseEntity<List<CompanySupplier>> listAllRelationship() {
		return ResponseEntity.ok().body(this.companySupplierService.findAll());
	}
}
