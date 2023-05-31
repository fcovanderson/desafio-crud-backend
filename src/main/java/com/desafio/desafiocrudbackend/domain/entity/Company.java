package com.desafio.desafiocrudbackend.domain.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "COMPANY")
public class Company implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="ID_COMPANY")
	private Long id_company;
	
	@Column(name="CNPJ", unique = true, nullable = false)
	private String cnpj;
	
	@Column(name="FANTASY_NAME", nullable = false)
	private String fantasyName;
	
	@Column(name="CEP", nullable = false)
	private String cep;
	
	@OneToMany(mappedBy = "company")
	private List<CompanySupplier> supplieres;

	public Company(String cnpj, String fantasyName, String cep) {
		super();
		this.cnpj = cnpj;
		this.fantasyName = fantasyName;
		this.cep = cep;
		this.supplieres = new ArrayList<CompanySupplier>();
	}

	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}
}
