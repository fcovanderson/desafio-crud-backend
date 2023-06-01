package com.desafio.desafiocrudbackend.domain.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.desafio.desafiocrudbackend.api.dto.filter.SupplierFilter;
import com.desafio.desafiocrudbackend.api.dto.form.SupplierForm;
import com.desafio.desafiocrudbackend.domain.entity.Supplier;
import com.desafio.desafiocrudbackend.domain.repository.SupplierRepository;
import com.desafio.desafiocrudbackend.domain.util.DateUtil;
import com.desafio.desafiocrudbackend.domain.validator.SupplierValidator;

@Component
public class SupplierService implements GenericService<SupplierForm, Supplier, Long>{
	
	@Autowired 
	private SupplierRepository supplierRepository;
	
	@Autowired 
	private SupplierValidator validator;
	
	@Override
	public Supplier save(SupplierForm entityForm) {
		this.validator.validate(entityForm);
		Date birthDate = DateUtil.convertFormatedDateToDateFormat(entityForm.getBirthDate());
		Supplier newSupplier = new Supplier(entityForm.getCnpj_cpf(), entityForm.getName(), entityForm.getCep(), entityForm.getEmail(), entityForm.getRg(), birthDate, entityForm.getSupplierType());
		return this.supplierRepository.save(newSupplier);
	}

	@Override
	public List<Supplier> findAll() {
		return this.supplierRepository.findAll();
	}

	@Override
	public Supplier update(SupplierForm entityForm, Long id) {
		this.validator.validate(entityForm);
		Date birthDate = DateUtil.convertFormatedDateToDateFormat(entityForm.getBirthDate());
		
		Optional<Supplier> supplier = this.supplierRepository.findById(id);
		supplier.get().setName(entityForm.getName());
		supplier.get().setSupplierType(entityForm.getSupplierType());
		supplier.get().setCep(entityForm.getCep());
		supplier.get().setCnpj_cpf(entityForm.getCnpj_cpf());
		supplier.get().setEmail(entityForm.getEmail());
		supplier.get().setRg(entityForm.getRg());
		supplier.get().setBirthDate(birthDate);
		return this.supplierRepository.save(supplier.get());
	}

	@Override
	public void delete(Long id) {
		this.supplierRepository.deleteById(id);
	}

	@SuppressWarnings("serial")
	public List<Supplier> findSupplierByNameCnpjCpf(SupplierFilter filteres) {
		return this.supplierRepository.findAll(new Specification<Supplier>() {
			
			@Override
			public Predicate toPredicate(Root<Supplier> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				List<Predicate> predicates = new ArrayList<>();
				
				if (Objects.nonNull(filteres.getName())) {
					predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("name"), filteres.getName())));
				}
				
				if (Objects.nonNull(filteres.getCnpjCpf())) {
					predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("cnpj_cpf"), filteres.getCnpjCpf())));
				}
				return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
			}
		});
	}
}
