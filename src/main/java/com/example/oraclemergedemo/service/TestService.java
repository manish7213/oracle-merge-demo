package com.example.oraclemergedemo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.oraclemergedemo.bo.CustomerImport;
import com.example.oraclemergedemo.bo.GenericBo;
import com.example.oraclemergedemo.dao.CustomerImportRepository;

@Service
public class TestService {
	
	@Autowired
	private CustomerImportRepository customerImportRepository;
	
	@Autowired
	private BatchService batchService;
	
	public Optional<CustomerImport> findCustomerImportById(String id) {
		
		return customerImportRepository.findById(id);

	}
	


private void processPersonData() {
	GenericBo.setBatchNumber("First Batch");
	batchService.processBatchJob();
	
}

private void processCustomerData() {
	GenericBo.setBatchNumber("Second Batch");
	batchService.processBatchJob();
}

public void processData() {
	
	processPersonData();
	processCustomerData();
}

}
