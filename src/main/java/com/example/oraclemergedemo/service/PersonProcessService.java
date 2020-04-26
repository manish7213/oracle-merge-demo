package com.example.oraclemergedemo.service;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Service;

import com.example.oraclemergedemo.bo.PersonDestination;
import com.example.oraclemergedemo.bo.PersonSource;
@Service
public class PersonProcessService implements ItemProcessor<PersonSource, PersonDestination> {

	
	@Override
	public PersonDestination process(PersonSource item) throws Exception {
		PersonDestination destination = new PersonDestination();
		destination.setPERSON_ID(item.getPerson_id());
		destination.setFIRST_NAME(item.getFirst_name());
		destination.setLAST_NAME(item.getLast_name());
		return destination;
	}
}
