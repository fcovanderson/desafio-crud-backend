package com.desafio.desafiocrudbackend.api.dto.form;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanySupplierForm {
	@NotNull private Long idCompany;
	@NotNull private Long idSupplier;
}
