package com.desafio.desafiocrudbackend.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.desafiocrudbackend.api.dto.filter.SupplierFilter;
import com.desafio.desafiocrudbackend.api.dto.form.SupplierForm;
import com.desafio.desafiocrudbackend.domain.entity.Supplier;
import com.desafio.desafiocrudbackend.domain.service.SupplierService;

@RestController
@RequestMapping("/api/v1/supplieres")
public class SupplierController extends GenericController<SupplierService, Supplier, SupplierForm, Long>{
	
	@PostMapping("/find")
	public ResponseEntity<Object> findSupplierByNameCnpjCpf(@RequestBody SupplierFilter filteres){
		try {
			var supplieres = this.service.findSupplierByNameCnpjCpf(filteres);
			return ResponseEntity.ok(supplieres);
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}
}
