package com.orionhealth.factories;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import javax.json.JsonObject;

public class CodeSetFactory extends Factory {
	/**
	 * "identifier" : {
        "code" : "pid2",
        "codingSystem" : "testWorld"
      },
	 */
	
	public CodeSetFactory(int numberOfAddress, int propOfDuplicate) {
		super(numberOfAddress, propOfDuplicate);
	}
	
	@Override
	protected JsonObject createJsonObject() {
		LinkedHashMap<String, Object> values = new LinkedHashMap<String, Object>();
		values.put("code",
				buildRandomNumericString(20));
		values.put("codingSystem",
				buildRandomString("nameSpace", null, "-", 1000));
		
		return buildObjectFromMap(values);
	}
	
	public JsonObject createJsonObject(String id, String namespace) {
		LinkedHashMap<String, Object> values = new LinkedHashMap<String, Object>();
		values.put("id",id);
		values.put("namespace",namespace);
		return buildObjectFromMap(values);
	}

}
