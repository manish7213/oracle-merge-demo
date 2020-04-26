package com.example.oraclemergedemo.bo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER_IMPORT")
public class CustomerImport {
	@Id
	private String CUSTOMER_ID;
	private String FIRST_NAME;
	private String LAST_NAME;
	private String ADDRESS_STATE;
	private String EMAIL_ADDRESS;
	
	
	public CustomerImport() {
	}

	public String getCUSTOMER_ID() {
		return CUSTOMER_ID;
	}

	public void setCUSTOMER_ID(String cUSTOMER_ID) {
		CUSTOMER_ID = cUSTOMER_ID;
	}

	public String getFIRST_NAME() {
		return FIRST_NAME;
	}

	public void setFIRST_NAME(String fIRST_NAME) {
		FIRST_NAME = fIRST_NAME;
	}

	public String getLAST_NAME() {
		return LAST_NAME;
	}

	public void setLAST_NAME(String lAST_NAME) {
		LAST_NAME = lAST_NAME;
	}

	public String getADDRESS_STATE() {
		return ADDRESS_STATE;
	}

	public void setADDRESS_STATE(String aDDRESS_STATE) {
		ADDRESS_STATE = aDDRESS_STATE;
	}

	public String getEMAIL_ADDRESS() {
		return EMAIL_ADDRESS;
	}

	public void setEMAIL_ADDRESS(String eMAIL_ADDRESS) {
		EMAIL_ADDRESS = eMAIL_ADDRESS;
	}

	@Override
	public String toString() {
		return "Customer [CUSTOMER_ID=" + CUSTOMER_ID + ", FIRST_NAME=" + FIRST_NAME + ", LAST_NAME=" + LAST_NAME
				+ ", ADDRESS_STATE=" + ADDRESS_STATE + ", EMAIL_ADDRESS=" + EMAIL_ADDRESS + "]";
	}

}
