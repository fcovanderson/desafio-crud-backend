package com.desafio.desafiocrudbackend.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafio.desafiocrudbackend.domain.entity.CompanySupplier;

@Repository
public interface CompanySupplierRepository extends JpaRepository<CompanySupplier, Long> {

}
