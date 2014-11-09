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

import org.junit.Assert;
import org.junit.Test;

import com.orionhealth.factories.CodeDefinitionFactory;
import com.orionhealth.model.CodeDefinition;

import junit.framework.TestCase;

public class CodeDefinitionFactoryTest extends TestCase {

	@Test
	public void testGenerationOfCodeDef() {
		final Factory codeDefinitionFactory = new CodeDefinitionFactory();
		final String row = codeDefinitionFactory.buildRowWithIndex(0);
		Assert.assertEquals("AN,ORION,Anatomy,Anatomy,0,false,false,Cukes AN description", row);
	}

	@Test
	public void testGenerationOfCodeDef1() {
		final Factory codeDefinitionFactory = new CodeDefinitionFactory();
		final String row = codeDefinitionFactory.buildRowWithIndex(1);
		Assert.assertEquals("BCH,ORION,Biochemistry,Biochemistry,0,false,false,Cukes BCH description", row);
	}

	@Test
	public void testGenerationOfCodeDef2() {
		final Factory codeDefinitionFactory = new CodeDefinitionFactory();
		final String row = codeDefinitionFactory.buildRowWithIndex(2);
		Assert.assertEquals("BMC,ORION,Biomechanics,Biomechanics,0,false,false,Cukes BMC description", row);
	}
	
	@Test
	public void testFactory() {
		final CodeDefinitionFactory codeDefinitionFactory = new CodeDefinitionFactory();
		final CodeDefinition codeDefinition =  codeDefinitionFactory.create();
		Assert.assertNotNull(codeDefinition.getPrimaryKey());
		Assert.assertNotNull(codeDefinition.getRow());
		
	}
}

