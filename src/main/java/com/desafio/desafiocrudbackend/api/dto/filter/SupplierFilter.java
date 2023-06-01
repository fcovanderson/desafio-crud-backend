package com.desafio.desafiocrudbackend.api.dto.filter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SupplierFilter {
	private String name;
	private String cnpjCpf;
}
