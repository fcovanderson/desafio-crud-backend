package com.desafio.desafiocrudbackend.domain.validator;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Component;

import com.desafio.desafiocrudbackend.domain.entity.CompanySupplier;
import com.desafio.desafiocrudbackend.domain.entity.dto.AddressDTO;
import com.desafio.desafiocrudbackend.domain.exception.UnderAgeException;
import com.desafio.desafiocrudbackend.domain.util.CEPUtil;

@Component
public class CompanySupplierValidator extends GenericValidator implements EntityValidator<CompanySupplier>{
    private final int UNDER_AGE = 18;
	
	@Override
	public void validate(CompanySupplier companySupplier) {
		AddressDTO companyAddressDTO = this.getAdressByCep(companySupplier.getCompany().getCep());
        if(companyAddressDTO.getUf().equals("PR")){
        	if(calculeAge(companySupplier.getSupplier().getBirthDate()) < UNDER_AGE) {
        		throw new UnderAgeException(this.getMessageSource().getMessage("message.exception.supplier.under.age", null, Locale.getDefault()));
        	}
        }
	}
	
	private AddressDTO getAdressByCep(String cep){
		return CEPUtil.getAddress(cep);
	}
	
	private int calculeAge(Date birthDate) {
	    Period periodo = Period.between(birthDate.toInstant().atZone(ZoneId.systemDefault())
	    	      .toLocalDate(), LocalDate.now());
	    return periodo.getYears();
	}
}
