/*
 * Copyright (c) Orchestral Developments Ltd and the Orion Health group of companies (2001 - 2014).
 *
 * This document is copyright. Except for the purpose of fair reviewing, no part
 * of this publication may be reproduced or transmitted in any form or by any
 * means, electronic or mechanical, including photocopying, recording, or any
 * information storage and retrieval system, without permission in writing from
 * the publisher. Infringers of copyright render themselves liable for
 * prosecution.
 */
package com.orionhealth.factories;

import java.util.HashMap;
import java.util.Map;

import com.orionhealth.model.CodeDefinition;
import com.orionhealth.model.Provider;

public class ProviderFactory extends Factory<Provider> {
	/*
	"model.providerField1.identifier.id" : "pid1",
	"model.providerField1.identifier.namespace" : "testWorld"

	"model.providerField1.name.nameType" : "Display Name",
	"model.providerField1.name.prefix" : "Prefix",
	"model.providerField1.name.givenName" : "pid1'sGivenName",
	"model.providerField1.name.middleNames" : "pid1'sMiddleNames",
	"model.providerField1.name.familyName" : "pid1'sFamilyName",
	"model.providerField1.name.fullName" : "",
	"model.providerField1.name.suffix" : "Suffix",
	"model.providerField1.name.title" : "Title",
	"model.providerField1.name.preferred" : true

	"model.providerField1.role.identifier.code" : "PCP",
	"model.providerField1.role.identifier.codingSystem" : "ORION"
	"model.providerField1.role.description" : "Primary Care Provider",
	"model.providerField1.role.shortDescription" : "Primary Care Provider",
	"model.providerField1.role.orderIndex" : 1,
	"model.providerField1.role.deleted" : false,
	"model.providerField1.role.freeText" : false

	"model.providerField1.specialties.identifier.code" : "END",
	"model.providerField1.specialties.identifier.codingSystem" : "ORION"

	"model.providerField1.specialties.description" : "Endocrinology",
	"model.providerField1.specialties.shortDescription" : "Endo",
	"model.providerField1.specialties.orderIndex" : 0,
	"model.providerField1.specialties.deleted" : false,
	"model.providerField1.specialties.freeText" : false
	"model.providerField1.specialties.identifier.code" : "two",
	"model.providerField1.specialties.identifier.codingSystem" : "123"
	"model.providerField1.specialties.description" : "string",
	"model.providerField1.specialties.shortDescription" : null,
	"model.providerField1.specialties.orderIndex" : 9,
	"model.providerField1.specialties.deleted" : false,
	"model.providerField1.specialties.freeText" : false

	"model.providerField1.addresses.streetAddressLine1" : "pid1@testWorld's home",
	"model.providerField1.addresses.streetAddressLine2" : "",
	"model.providerField1.addresses.city" : "Dnalkcua",
	"model.providerField1.addresses.country" : "ZN",
	"model.providerField1.addresses.stateOrProvince" : "Alpha",
	"model.providerField1.addresses.postcode" : "0001",
	"model.providerField1.addresses.addressType" : "string",
	"model.providerField1.addresses.suburb" : "Hop",
	"model.providerField1.addresses.preferred" : false

	"model.providerField1.telecoms.telecomType" : "teleType",
	"model.providerField1.telecoms.telecom" : "152-5553",
	"model.providerField1.telecoms.preferred" : false
	
	*/
	
	@Override
	protected Provider construct(Integer index, String row) {
		return new Provider(index, row);
	}

	@Override
	protected String buildRowWithIndex(Integer index) {
		return "pid-" + index +
		",testWorld,Display Name-" + index +",Prefix-" + index + 
		",pid-" + index + "-GivenName,pid-" + index + "-MiddleNames,pid-" + index + "-FamilyName,pid-" + index + "-fullName,Suffix,Title,true" + 
		",PCP,ORION,Primary Care Provider,Primary Care Provider,1,false,false" +
		",END,ORION" +

		",Endocrinology,Endo,0,false,false,two,123,string,null,9,false,false" +
		
		",pid-" + index +"@testWorld.com,Street-"+index+",City-" + index + ",ZN,Auckland,0001,string,Hop,false,teleType,555-123456,false";
		
		
	}

	@Override
	public String getColumnNames() {
		return  "model.providerField1.identifier.id,"+
		"model.providerField1.identifier.namespace," +
		"model.providerField1.name.nameType," +
		"model.providerField1.name.prefix,"+
		"model.providerField1.name.givenName,"+
		"model.providerField1.name.middleNames,"+
		"model.providerField1.name.familyName,"+
		"model.providerField1.name.fullName,"+
		"model.providerField1.name.suffix,"+
		"model.providerField1.name.title,"+
		"model.providerField1.name.preferred,"+

		"model.providerField1.role.identifier.code,"+
		"model.providerField1.role.identifier.codingSystem,"+
		"model.providerField1.role.description,"+
		"model.providerField1.role.shortDescription,"+
		"model.providerField1.role.orderIndex,"+
		"model.providerField1.role.deleted,"+
		"model.providerField1.role.freeText,"+

		"model.providerField1.specialties.identifier.code,"+
		"model.providerField1.specialties.identifier.codingSystem,"+

		"model.providerField1.specialties.description," +
		"model.providerField1.specialties.shortDescription,"+
		"model.providerField1.specialties.orderIndex,"+
		"model.providerField1.specialties.deleted,"+
		"model.providerField1.specialties.freeText,"+
		"model.providerField1.specialties.identifier.code,"+
		"model.providerField1.specialties.identifier.codingSystem,"+
		"model.providerField1.specialties.description,"+
		"model.providerField1.specialties.shortDescription,"+
		"model.providerField1.specialties.orderIndex,"+
		"model.providerField1.specialties.deleted,"+
		"model.providerField1.specialties.freeText,"+

		"model.providerField1.addresses.streetAddressLine1,"+
		"model.providerField1.addresses.streetAddressLine2,"+
		"model.providerField1.addresses.city,"+
		"model.providerField1.addresses.country,"+
		"model.providerField1.addresses.stateOrProvince,"+
		"model.providerField1.addresses.postcode,"+
		"model.providerField1.addresses.addressType,"+
		"model.providerField1.addresses.suburb,"+
		"model.providerField1.addresses.preferred,"+

		"model.providerField1.telecoms.telecomType,"+
		"model.providerField1.telecoms.telecom,"+
		"model.providerField1.telecoms.preferred";
	}
}

