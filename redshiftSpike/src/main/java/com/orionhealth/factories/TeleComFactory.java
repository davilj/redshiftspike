package com.orionhealth.factories;

import java.util.LinkedHashMap;

import javax.json.JsonObject;

public class TeleComFactory extends Factory {
	/**
	"telecoms" : [ {
        "telecomType" : "teleType",
        "telecom" : "152-5553",
        "preferred" : false
      }
	**/
	public TeleComFactory(int numberOfNumbers, int propOfDuplicate) {
		super(numberOfNumbers, propOfDuplicate);
	}
	
	
	@Override
	protected JsonObject createJsonObject() {
		
			LinkedHashMap<String, Object> values = new LinkedHashMap<String, Object>();
			values.put("telecomType", "teleType");
			values.put("telecom", (buildRandomNumericString(3) +  "-" + buildRandomNumericString(5)));
			values.put("preferred", buildRandomBoolean());
			return buildObjectFromMap(values);
		}
	
}
