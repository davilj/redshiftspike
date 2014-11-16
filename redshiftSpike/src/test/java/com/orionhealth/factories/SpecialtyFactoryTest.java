package com.orionhealth.factories;

import org.junit.Test;

public class SpecialtyFactoryTest {

	@Test
	public void test() {
		SpecialtyFactory factory = new SpecialtyFactory();
		String speciality = factory.createAsJsonString();
		System.out.println(speciality);
	}

}
