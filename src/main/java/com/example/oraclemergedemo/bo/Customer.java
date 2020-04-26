package com.example.oraclemergedemo.bo;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER")
public class Customer {

	@EmbeddedId
	private CustomerCompositeKey compositeKey;
	private String FIRST_NAME;
	private String LAST_NAME;
	private String ADDRESS_STATE;

	public Customer() {
	}

	public Customer(CustomerCompositeKey compositeKey, String fIRST_NAME, String lAST_NAME, String aDDRESS_STATE) {
		super();
		this.compositeKey = compositeKey;
		FIRST_NAME = fIRST_NAME;
		LAST_NAME = lAST_NAME;
		ADDRESS_STATE = aDDRESS_STATE;
	}

	public CustomerCompositeKey getCompositeKey() {
		return compositeKey;
	}

	public void setCompositeKey(CustomerCompositeKey compositeKey) {
		this.compositeKey = compositeKey;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ADDRESS_STATE == null) ? 0 : ADDRESS_STATE.hashCode());
		result = prime * result + ((FIRST_NAME == null) ? 0 : FIRST_NAME.hashCode());
		result = prime * result + ((LAST_NAME == null) ? 0 : LAST_NAME.hashCode());
		result = prime * result + ((compositeKey == null) ? 0 : compositeKey.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (ADDRESS_STATE == null) {
			if (other.ADDRESS_STATE != null)
				return false;
		} else if (!ADDRESS_STATE.equals(other.ADDRESS_STATE))
			return false;
		if (FIRST_NAME == null) {
			if (other.FIRST_NAME != null)
				return false;
		} else if (!FIRST_NAME.equals(other.FIRST_NAME))
			return false;
		if (LAST_NAME == null) {
			if (other.LAST_NAME != null)
				return false;
		} else if (!LAST_NAME.equals(other.LAST_NAME))
			return false;
		if (compositeKey == null) {
			if (other.compositeKey != null)
				return false;
		} else if (!compositeKey.equals(other.compositeKey))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Customer [compositeKey=" + compositeKey + ", FIRST_NAME=" + FIRST_NAME + ", LAST_NAME=" + LAST_NAME
				+ ", ADDRESS_STATE=" + ADDRESS_STATE + "]";
	}

}
