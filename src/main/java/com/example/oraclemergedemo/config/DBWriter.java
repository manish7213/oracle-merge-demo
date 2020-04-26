package com.example.oraclemergedemo.config;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.oraclemergedemo.bo.Customer;
import com.example.oraclemergedemo.dao.CustomerRepository;

@Component
public class DBWriter implements ItemWriter<Customer>{
	
	@Autowired
	private CustomerRepository customerRepo;

	@Override
	public void write(List<? extends Customer> items) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("DATA SAVED *******************************************");
		customerRepo.saveAll(items);
		
	}

}
