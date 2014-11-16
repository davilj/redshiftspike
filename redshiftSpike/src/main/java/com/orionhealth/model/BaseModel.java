package com.orionhealth.model;

public class BaseModel {
	private int primaryKey;
	private String row;
	
	public BaseModel(int primaryKey, String row) {
		this.primaryKey = primaryKey;
		this.row = row;
	}

	public int getPrimaryKey() {
		return primaryKey;
	}

	public String getRow() {
		return row;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + primaryKey;
		result = prime * result + ((row == null) ? 0 : row.hashCode());
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
		BaseModel other = (BaseModel) obj;
		if (primaryKey != other.primaryKey)
			return false;
		if (row == null) {
			if (other.row != null)
				return false;
		} else if (!row.equals(other.row))
			return false;
		return true;
	}
}
