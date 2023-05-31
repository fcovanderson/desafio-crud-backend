package com.desafio.desafiocrudbackend.api.dto.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.desafio.desafiocrudbackend.domain.enums.SupplierType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SupplierForm {
	
	@NotNull(message = "O campo CNPJ precisa ser informado")
	@NotBlank(message = "O campo CNPJ não pode ser vazio")
	private String cnpj_cpf;
	
	@NotNull(message = "O campo NOME precisa ser informado")
	@NotBlank(message = "O campo NOME não pode ser vazio")
	private String name;
	
	@NotNull(message = "O campo CEP precisa ser informado")
	@NotBlank(message = "O campo CEP não pode ser vazio")
	private String cep;
	
	@NotNull(message = "O campo EMAIL precisa ser informado")
	@NotBlank(message = "O campo EMAIL não pode ser vazio")
	private String email;
	
	@NotNull(message = "O campo TIPO DE PESSOA precisa ser informado. Valores aceitos: LEGAL_ENTITY ou NATURAL_PERSON")
	private SupplierType supplierType; 
	
	private String rg;
	
	private String birthDate;
}
