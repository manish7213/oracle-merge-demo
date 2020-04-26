package com.example.oraclemergedemo;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.oraclemergedemo.bo.Customer;
import com.example.oraclemergedemo.bo.CustomerImport;
import com.example.oraclemergedemo.dao.CustomerImportRepository;

@EnableBatchProcessing
@EnableTransactionManagement
@SpringBootApplication
@EntityScan(basePackageClasses = {Customer.class,CustomerImport.class})
@EnableJpaRepositories(basePackageClasses = {CustomerImportRepository.class,Customer.class})
public class OracleMergeDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(OracleMergeDemoApplication.class, args);
	}

}
