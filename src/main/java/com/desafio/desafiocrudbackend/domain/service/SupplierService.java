package com.desafio.desafiocrudbackend.domain.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.desafio.desafiocrudbackend.api.dto.form.SupplierForm;
import com.desafio.desafiocrudbackend.domain.entity.Supplier;
import com.desafio.desafiocrudbackend.domain.exception.InvalidBirthDateFormatException;
import com.desafio.desafiocrudbackend.domain.repository.SupplierRepository;
import com.desafio.desafiocrudbackend.domain.validator.SupplierValidator;

@Component
public class SupplierService implements GenericService<SupplierForm, Supplier, Long>{
	
	@Autowired 
	private SupplierRepository supplierRepository;
	
	@Autowired 
	private SupplierValidator validator;
	
	@Override
	public Supplier save(SupplierForm supplierForm) {
		this.validator.validate(supplierForm);
		
		Date birthDate = null;
		if(Objects.nonNull(supplierForm.getBirthDate())){
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
			try {
				birthDate = simpleDateFormat.parse(supplierForm.getBirthDate());
			} catch (ParseException e) {
				e.printStackTrace();
				throw new InvalidBirthDateFormatException(e.getMessage());
			}
		}
		Supplier newSupplier = new Supplier(supplierForm.getCnpj_cpf(), supplierForm.getName(), supplierForm.getCep(), supplierForm.getEmail(), supplierForm.getRg(), birthDate);
		return this.supplierRepository.save(newSupplier);
	}

	@Override
	public List<Supplier> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Supplier update(SupplierForm formEntity, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
	}
}
