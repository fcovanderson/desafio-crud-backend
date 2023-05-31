package com.desafio.desafiocrudbackend.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.desafio.desafiocrudbackend.api.dto.form.CompanyForm;
import com.desafio.desafiocrudbackend.domain.entity.Company;
import com.desafio.desafiocrudbackend.domain.repository.CompanyRepository;

@Component
public class CompanyService implements GenericService<CompanyForm, Company, Long>{
	
	@Autowired 
	private CompanyRepository companyRepository;
	
	@Override
	public Company save(CompanyForm companyForm) {
		Company newCompany = new Company(companyForm.getCnpj(), companyForm.getFantasyName(), companyForm.getCep());
		return this.companyRepository.save(newCompany);
	}
	
	public List<Company> findAll() {
		return this.companyRepository.findAll();
	}
	
	@Override
	public Company update(CompanyForm companyForm, Long id) {
		Optional<Company> company = this.companyRepository.findById(id);
		company.get().setFantasyName(companyForm.getFantasyName());
		company.get().setCep(companyForm.getCep());
		company.get().setCnpj(companyForm.getCnpj());
		return this.companyRepository.save(company.get());
	}
	
	@Override
	public void delete(Long id) {
		this.companyRepository.deleteById(id);
	}
}
