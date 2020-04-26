package com.example.oraclemergedemo.bo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PERSON_DESTINATION")
public class PersonDestination {
	@Id
	private int PERSON_ID;

	private String FIRST_NAME;

	private String LAST_NAME;

	public PersonDestination() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PersonDestination(int pERSON_ID, String fIRST_NAME, String lAST_NAME) {
		super();
		PERSON_ID = pERSON_ID;
		FIRST_NAME = fIRST_NAME;
		LAST_NAME = lAST_NAME;
	}

	public int getPERSON_ID() {
		return PERSON_ID;
	}

	public void setPERSON_ID(int pERSON_ID) {
		PERSON_ID = pERSON_ID;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((FIRST_NAME == null) ? 0 : FIRST_NAME.hashCode());
		result = prime * result + ((LAST_NAME == null) ? 0 : LAST_NAME.hashCode());
		result = prime * result + PERSON_ID;
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
		PersonDestination other = (PersonDestination) obj;
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
		if (PERSON_ID != other.PERSON_ID)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PersonDestination [PERSON_ID=" + PERSON_ID + ", FIRST_NAME=" + FIRST_NAME + ", LAST_NAME=" + LAST_NAME
				+ "]";
	}

	
}
