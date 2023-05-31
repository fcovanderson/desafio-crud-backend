package com.desafio.desafiocrudbackend.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "COMPANY_SUPPLIER")
public class CompanySupplier implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="ID_COMPANY_SUPPLIER")
	private Long id_company_supplier;
	
	@ManyToOne
    @JoinColumn(name = "ID_COMPANY", nullable = false)
	private Company company;
	
	@ManyToOne
    @JoinColumn(name = "ID_SUPPLIER", nullable = false)
	private Supplier supplier;
}
