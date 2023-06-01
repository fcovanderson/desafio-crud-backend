package com.desafio.desafiocrudbackend.domain.util;

import java.util.Collections;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.desafio.desafiocrudbackend.domain.entity.dto.AddressDTO;

public class CEPUtil {
	
	public static AddressDTO getAddress(String cep) {
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
}
