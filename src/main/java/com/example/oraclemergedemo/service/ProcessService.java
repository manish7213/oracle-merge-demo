package com.example.oraclemergedemo.service;

import com.example.oraclemergedemo.bo.Customer;
import com.example.oraclemergedemo.bo.CustomerCompositeKey;
import com.example.oraclemergedemo.bo.CustomerImport;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Service;

@Service
public class ProcessService implements ItemProcessor<CustomerImport, Customer> {
    @Override
    public Customer process(CustomerImport customerImport) throws Exception {
        Customer customer = new Customer();
        System.out.println(customerImport);
        CustomerCompositeKey compositeKey = new CustomerCompositeKey(customerImport.getCUSTOMER_ID(), customerImport.getEMAIL_ADDRESS());
        customer.setCompositeKey(compositeKey);
        customer.setFIRST_NAME(customerImport.getFIRST_NAME());
        customer.setLAST_NAME(customerImport.getLAST_NAME());
        customer.setADDRESS_STATE(customerImport.getADDRESS_STATE());
        return customer;
    }
}
