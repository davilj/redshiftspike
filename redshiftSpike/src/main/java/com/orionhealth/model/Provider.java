package com.orionhealth.model;

public class Provider {
	Integer id;
	String row;

	public Provider(Integer id, String row) {
		this.id = id;
		this.row = row;
	}

	public Integer getId() {
		return id;
	}

	public String getRow() {
		return row;
	}
}	
