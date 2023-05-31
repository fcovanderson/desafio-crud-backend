package com.desafio.desafiocrudbackend.domain.entity;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "SUPPLIER")
public class Supplier implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="ID_SUPPLIER")
	private Long id_supplier;
	
	@Column(name="CNPJ_CPF", unique = true, nullable = false)
	private String cnpj_cpf;
	
	@Column(name="NOME", nullable = false)
	private String nome;
	
	@Column(name="CEP", nullable = false)
	private String cep;
	
	@Column(name="EMAIL", nullable = false)
	private String email;
	
	@Column(name="RG", nullable = true)
	private String rg;
	
	@Column(name="BIRTH_DATE", nullable = true)
	private Date birthDate;
	
	@OneToMany(mappedBy = "supplier")
	private List<CompanySupplier> companies;

	public Supplier() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Supplier(String cnpj_cpf, String nome, String cep, String email, String rg, Date birthDate) {
		super();
		this.cnpj_cpf = cnpj_cpf;
		this.nome = nome;
		this.cep = cep;
		this.email = email;
		this.rg = rg;
		this.birthDate = birthDate;
	}
}
