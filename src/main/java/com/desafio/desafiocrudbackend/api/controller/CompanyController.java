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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.desafiocrudbackend.api.dto.form.CompanyForm;
import com.desafio.desafiocrudbackend.domain.entity.Company;
import com.desafio.desafiocrudbackend.domain.service.CompanyService;

@RestController
@RequestMapping("/api/v1/companies")
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	
	@GetMapping
	public ResponseEntity<List<Company>> listAllCompanies() {
		return ResponseEntity.ok().body(this.companyService.findAll());
	}
	
	@PostMapping
	public ResponseEntity<Company> addCompany(@Validated @RequestBody CompanyForm companyForm) {
		Company company = this.companyService.save(companyForm);
		return ResponseEntity.ok().body(company);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Company> updateCompany(@PathVariable Long id, @RequestBody @Valid CompanyForm companyForm) {
	     return ResponseEntity.ok().body(this.companyService.update(id, companyForm));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCompany(@PathVariable Long id) {
		this.companyService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
