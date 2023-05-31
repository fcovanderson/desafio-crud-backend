package com.desafio.desafiocrudbackend.api.dto.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyForm {
	
	@NotNull(message = "O campo CNPJ precisa ser informado")
	@NotBlank(message = "O campo CNPJ não pode ser vazio")
	private String cnpj;
	
	@NotNull(message = "O campo NOME_FANTASIA precisa ser informado")
	@NotBlank(message = "O campo NOME_FANTASIA não pode ser vazio")
	private String fantasyName;
	
	@NotNull(message = "O campo CEP precisa ser informado")
	@NotBlank(message = "O campo CEP não pode ser vazio")
	private String cep;
}
