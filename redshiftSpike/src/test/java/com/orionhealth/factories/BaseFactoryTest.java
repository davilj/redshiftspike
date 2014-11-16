package com.orionhealth.factories;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;
import org.junit.Test;

public class BaseFactoryTest {

	@Test
	public void testCreateAsJsonString() {
		Set<String> results = new HashSet<String>();
		Factory addressFactory = new AddressFactory(10, 0);
		for (int n=0; n<10;n++) {
			String obj = addressFactory.createAsJsonString();
			assertNotNull(obj);
			results.add(obj);
		}
		assertEquals(10, results.size());
	}
	
	@Test
	public void testCreateAsJsonCreation() {
		
		Factory addressFactory = new AddressFactory(10, 0);
		LinkedHashMap<String, Object> buildMap = new LinkedHashMap<String, Object>();
		buildMap.put("One", new Integer(1));
		buildMap.put("Two", "Two");
		buildMap.put("three", new Double(3.1415));
		String result = addressFactory.buildObjectFromMap(buildMap).toString();
		assertEquals("{\"One\":\"1\",\"Two\":\"Two\",\"three\":\"3.1415\"}", result);
	}

}
