package com.example.oraclemergedemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.oraclemergedemo.bo.CustomerImport;

@Repository
public interface CustomerImportRepository extends JpaRepository<CustomerImport, String>{
	
	

}
