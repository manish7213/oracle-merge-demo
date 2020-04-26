package com.example.oraclemergedemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.oraclemergedemo.bo.Customer;
import com.example.oraclemergedemo.bo.CustomerCompositeKey;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, CustomerCompositeKey>{

}
