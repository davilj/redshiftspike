package com.orionhealth.factories;

import java.util.LinkedHashMap;

import javax.json.JsonObject;

public class AddressFactory extends Factory {
	/**
	 * "addresses" : [ { "streetAddressLine1" : "pid2@testWorld's home",
	 * "streetAddressLine2" : "", "city" : "Dnalkcua", "country" : "ZN",
	 * "stateOrProvince" : "Alpha", "postcode" : "0001", "addressType" :
	 * "string", "suburb" : "Hop", "preferred" : false } ],
	 **/
	public AddressFactory(int numberOfAddress, int propOfDuplicate) {
		super(numberOfAddress, propOfDuplicate);
	}

	protected JsonObject createJsonObject() {
		LinkedHashMap<String, Object> values = new LinkedHashMap<String, Object>();
		values.put("streetAddressLine1",
				buildRandomString("streetAddressLine", null, "-", 1000));
		values.put("streetAddressLine2",
				buildRandomString("streetAddressLine", null, "-", 1000));
		values.put("city", buildRandomString("City", null, "-", 1000));
		values.put("country", buildRandomString("Country", null, "-", 1000));
		values.put("postcode", buildRandomNumericString(4));
		values.put("addressType", "string");
		values.put("suburb", buildRandomString("Suburb", null, "-", 1000));
		values.put("preferred", buildRandomBoolean());
		return buildObjectFromMap(values);
	}
}
