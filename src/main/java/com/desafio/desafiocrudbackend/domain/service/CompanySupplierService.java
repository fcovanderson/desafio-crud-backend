package com.desafio.desafiocrudbackend.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.desafio.desafiocrudbackend.api.dto.form.CompanySupplierForm;
import com.desafio.desafiocrudbackend.domain.entity.Company;
import com.desafio.desafiocrudbackend.domain.entity.CompanySupplier;
import com.desafio.desafiocrudbackend.domain.entity.Supplier;
import com.desafio.desafiocrudbackend.domain.repository.CompanyRepository;
import com.desafio.desafiocrudbackend.domain.repository.CompanySupplierRepository;
import com.desafio.desafiocrudbackend.domain.repository.SupplierRepository;

@Component
public class CompanySupplierService {
	
	@Autowired 
	private CompanySupplierRepository companySupplierRepository;
	
	@Autowired 
	private CompanyRepository companyRepository;
	
	@Autowired 
	private SupplierRepository supplierRepository;
	
	public CompanySupplier save(CompanySupplierForm companySupplierForm) {
		Optional<Company> company = this.companyRepository.findById(companySupplierForm.getIdCompany());
		Optional<Supplier> supplier = this.supplierRepository.findById(companySupplierForm.getIdSupplier());
		
		CompanySupplier newCompanySupplier = new CompanySupplier(company.get(), supplier.get());
		
		newCompanySupplier = this.companySupplierRepository.save(newCompanySupplier);
		
		company.get().getSupplieres().add(newCompanySupplier);
		supplier.get().getCompanies().add(newCompanySupplier);
		
		this.companyRepository.save(company.get());
		this.supplierRepository.save(supplier.get());
		
		return newCompanySupplier;
	}
	
	public void delete(Long id) {
		this.companySupplierRepository.deleteById(id);
	}
	
	public List<CompanySupplier> findAll() {
		return this.companySupplierRepository.findAll();
	}
}
