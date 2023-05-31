package com.desafio.desafiocrudbackend.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.desafiocrudbackend.api.dto.form.CompanyForm;
import com.desafio.desafiocrudbackend.domain.entity.Company;
import com.desafio.desafiocrudbackend.domain.service.CompanyService;

@RestController
@RequestMapping("/api/v1/companies")
public class CompanyController extends GenericController<CompanyService, Company, CompanyForm, Long> {
}
