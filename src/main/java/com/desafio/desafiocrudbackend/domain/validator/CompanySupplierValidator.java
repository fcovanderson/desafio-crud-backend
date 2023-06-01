package com.desafio.desafiocrudbackend.domain.validator;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.desafio.desafiocrudbackend.domain.entity.CompanySupplier;
import com.desafio.desafiocrudbackend.domain.entity.dto.AddressDTO;
import com.desafio.desafiocrudbackend.domain.exception.UnderAgeException;

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
		String companyCEP = cep.replace(".", "").replace("-", ""); 
		String URI = String.format("http://cep.la/%s", companyCEP);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		
		@SuppressWarnings({ "unchecked", "rawtypes" })
		HttpEntity request = new HttpEntity(headers);
		
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<AddressDTO> response = restTemplate.exchange(URI, HttpMethod.GET, request, AddressDTO.class);
        return response.getBody();
	}
	
	private int calculeAge(Date birthDate) {
	    Period periodo = Period.between(birthDate.toInstant().atZone(ZoneId.systemDefault())
	    	      .toLocalDate(), LocalDate.now());
	    return periodo.getYears();
	}
}
