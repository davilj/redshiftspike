package com.orionhealth.factories;

import java.util.LinkedHashMap;

import javax.json.JsonObject;

public class NameFactory extends Factory {
	/*
	 "name" : {
        "nameType" : "Display Name",
        "prefix" : "Prefix",
        "givenName" : "pid1'sGivenName",
        "middleNames" : "pid1'sMiddleNames",
        "familyName" : "pid1'sFamilyName",
        "fullName" : "",
        "suffix" : "Suffix",
        "title" : "Title",
        "preferred" : true
      },
      */
	
	public NameFactory(int numberOfNames, int propOfDuplicate) {
		super(numberOfNames, propOfDuplicate);
	}
	
	
	@Override
	protected JsonObject createJsonObject() {
		LinkedHashMap<String, Object> values = new LinkedHashMap<String, Object>();
		values.put("nameType","Display Name");
		values.put("prefix","Prefix");
		values.put("givenName",buildRandomString("GivenName", null, "-", 1000));
		values.put("middleNames",buildRandomString("MiddleNames", null, "-", 1000));
		values.put("familyName",buildRandomString("FamilyName", null, "-", 1000));
		values.put("fullName","");
		values.put("suffix","Suffix");
		values.put("title","Title");
		values.put("preferred",buildRandomBoolean());
		return buildObjectFromMap(values);
	}

}
