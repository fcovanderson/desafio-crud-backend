package com.desafio.desafiocrudbackend.domain.entity.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDTO {
	private String cep;
	private String uf;
	private String cidade;
	private String bairro;
	private String logradouro;
}
