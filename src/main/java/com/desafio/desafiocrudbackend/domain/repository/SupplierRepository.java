package com.desafio.desafiocrudbackend.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.desafio.desafiocrudbackend.domain.entity.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier,Long>, JpaSpecificationExecutor<Supplier>{
}
