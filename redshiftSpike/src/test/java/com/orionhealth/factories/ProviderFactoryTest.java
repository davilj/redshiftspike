package com.orionhealth.factories;

import org.junit.Assert;

import org.junit.Test;

import com.orionhealth.model.Provider;

public class ProviderFactoryTest {

	@Test
	public void test() {
		ProviderFactory providerFactory = new ProviderFactory();	
		Provider provider = providerFactory.create();
		
		Assert.assertNotNull(provider.getId());
		Assert.assertNotNull(provider.getRow());
		Assert.assertEquals(44,provider.getRow().split(",").length);
		
		
		String columnNamesStr = providerFactory.getColumnNames();
		Assert.assertNotNull(columnNamesStr);
		String[] columnNames = columnNamesStr.split(",");
		Assert.assertEquals(44, columnNames.length);
			
	}

}
