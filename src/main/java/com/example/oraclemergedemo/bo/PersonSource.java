package com.example.oraclemergedemo.bo;

public class PersonSource {
	
	private int person_id;
	
	private String first_name;
	
	private String last_name;

	public PersonSource() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PersonSource(int person_id, String first_name, String last_name) {
		super();
		this.person_id = person_id;
		this.first_name = first_name;
		this.last_name = last_name;
	}

	public int getPerson_id() {
		return person_id;
	}

	public void setPerson_id(int person_id) {
		this.person_id = person_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((first_name == null) ? 0 : first_name.hashCode());
		result = prime * result + ((last_name == null) ? 0 : last_name.hashCode());
		result = prime * result + person_id;
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
		PersonSource other = (PersonSource) obj;
		if (first_name == null) {
			if (other.first_name != null)
				return false;
		} else if (!first_name.equals(other.first_name))
			return false;
		if (last_name == null) {
			if (other.last_name != null)
				return false;
		} else if (!last_name.equals(other.last_name))
			return false;
		if (person_id != other.person_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PersonSource [person_id=" + person_id + ", first_name=" + first_name + ", last_name=" + last_name + "]";
	}
	
	

}
