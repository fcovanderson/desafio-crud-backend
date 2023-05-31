package com.desafio.desafiocrudbackend.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.desafiocrudbackend.api.dto.form.SupplierForm;
import com.desafio.desafiocrudbackend.domain.entity.Supplier;
import com.desafio.desafiocrudbackend.domain.service.SupplierService;

@RestController
@RequestMapping("/api/v1/supplieres")
public class SupplierController extends GenericController<SupplierService, Supplier, SupplierForm, Long>{
}
