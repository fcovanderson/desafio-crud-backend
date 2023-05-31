package com.desafio.desafiocrudbackend.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.desafiocrudbackend.domain.entity.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier,Long>{

}
