package com.example.oraclemergedemo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDao {
	
	private static final String SELECTQUERY = "SELECT COUNT(1) FROM CUSTOMER_IMPORT";
	
	private static final String INSERTTQUERY = "INSERT INTO CUSTOMER(CUSTOMER_ID,FIRST_NAME,LAST_NAME,ADDRESS_STATE,EMAIL_ADDRESS) values  (?,?,?,?,?)";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int getCount() {
		
		int count = Integer.parseInt(jdbcTemplate.queryForMap(SELECTQUERY).get("COUNT(1)").toString());
		System.out.println("Count is "+count);
		return count;
	}
	
	public void insertInToCustomer() {
		
		int count = jdbcTemplate.update(INSERTTQUERY,1001,"Manish","Kumar","Bangalore","a@gmail.com");
		
		System.out.println("UPDATED COUNT IS "+count);
		
	}
	
	public List<String> getCompositeKeys() {
		
		List<Object> list = new ArrayList<>();
		
		List<Map<String, Object>> customerDetails = jdbcTemplate.queryForList("SELECT CUSTOMER_ID,EMAIL_ADDRESS FROM CUSTOMER");
		
		
		  for(Map<String,Object> map : customerDetails) {
			  list.add(map.get("CUSTOMER_ID")+""+map.get("EMAIL_ADDRESS"));
			 }
		 List<String> compositeKeys = list.stream().map(Object::toString).collect(Collectors.toList());
		return compositeKeys;
	}

}
