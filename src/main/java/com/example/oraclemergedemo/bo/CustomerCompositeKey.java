package com.example.oraclemergedemo.bo;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class CustomerCompositeKey implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotNull
	private String CUSTOMER_ID;
	@NotNull
	private String EMAIL_ADDRESS;
	public CustomerCompositeKey() {}
	public CustomerCompositeKey(@NotNull String cUSTOMER_ID, @NotNull String eMAIL_ADDRESS) {
		super();
		CUSTOMER_ID = cUSTOMER_ID;
		EMAIL_ADDRESS = eMAIL_ADDRESS;
	}
	public String getCUSTOMER_ID() {
		return CUSTOMER_ID;
	}
	public void setCUSTOMER_ID(String cUSTOMER_ID) {
		CUSTOMER_ID = cUSTOMER_ID;
	}
	public String getEMAIL_ADDRESS() {
		return EMAIL_ADDRESS;
	}
	public void setEMAIL_ADDRESS(String eMAIL_ADDRESS) {
		EMAIL_ADDRESS = eMAIL_ADDRESS;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CUSTOMER_ID == null) ? 0 : CUSTOMER_ID.hashCode());
		result = prime * result + ((EMAIL_ADDRESS == null) ? 0 : EMAIL_ADDRESS.hashCode());
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
		CustomerCompositeKey other = (CustomerCompositeKey) obj;
		if (CUSTOMER_ID == null) {
			if (other.CUSTOMER_ID != null)
				return false;
		} else if (!CUSTOMER_ID.equals(other.CUSTOMER_ID))
			return false;
		if (EMAIL_ADDRESS == null) {
			if (other.EMAIL_ADDRESS != null)
				return false;
		} else if (!EMAIL_ADDRESS.equals(other.EMAIL_ADDRESS))
			return false;
		return true;
	}
	
	
	

}
