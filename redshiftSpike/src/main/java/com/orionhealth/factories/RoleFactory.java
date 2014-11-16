package com.orionhealth.factories;

import java.util.LinkedHashMap;

import javax.json.JsonObject;

public class RoleFactory extends Factory {
	/**
	 "role" : {
        "identifier" : {
          "code" : "PCP",
          "codingSystem" : "ORION"
        },
        "description" : "Primary Care Provider",
        "shortDescription" : "Primary Care Provider",
        "orderIndex" : 1,
        "deleted" : false,
        "freeText" : false
      },
	 */
	private CodeSetFactory idFac;
	
	public RoleFactory(int numberOfRole, int propOfDuplicate) {
		super(numberOfRole, propOfDuplicate);
		this.idFac = new CodeSetFactory(0,100);
	}
	
	@Override
	protected JsonObject createJsonObject() {
		LinkedHashMap<String, Object> values = new LinkedHashMap<String, Object>();
		
		if (Math.random()>0.5) {
			values.put("identifier",this.idFac.createJsonObject("PCP", "ORION"));
			values.put("description","Primary Care Provider");
			values.put("shortDescription", "PCP");
		} else {
			values.put("identifier",this.idFac.createJsonObject("PCP", "ORION"));
			values.put("description","Alternative Care Organisation");
			values.put("shortDescription", "ACO");
		}
		values.put("deleted", buildRandomBoolean());
		values.put("orderIndex", buildRandomNumericString(2));
		values.put("freeText", buildRandomBoolean());
		return buildObjectFromMap(values);
	}
}
