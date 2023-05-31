package com.desafio.desafiocrudbackend.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafio.desafiocrudbackend.domain.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Long>	{
	Optional<Company> findById(Long id);
}	
