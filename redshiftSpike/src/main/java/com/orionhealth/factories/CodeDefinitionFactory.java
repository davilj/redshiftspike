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

public class CodeDefinitionFactory {
	static String[] medArr = { "Anatomy",
			"Biochemistry", "Biomechanics", "Biostatistics", "Biophysics",
			"Cytology",
			"Embryology",
			"Endocrinology",
			"Epidemiology",
			"Genetics",
			"Histology",
			"Immunology",
			"Medical physics",
			"Microbiology",
			"Molecular",
			"Neuroscience",
			"Nutrition",
			"Pathology",
			"Pharmacology",
			"Photobiology",
			"Physiology",
			"Radiobiology",
			"Toxicology" };

	static String[] medShortArr = { "AN",
			"BCH", "BMC", "BS", "BPH",
			"CT",
			"EM",
			"EN",
			"EP",
			"GEN",
			"HST",
			"IMM",
			"MED PHY",
			"MICRO",
			"MOLE",
			"NR",
			"NU",
			"PAT",
			"PHAR",
			"PHOTO",
			"PHYS",
			"RADIO",
			"TOXI" };

	static int lenOfArr;
	static {
		lenOfArr = medShortArr.length;
	}
	
	static Map<Integer, CodeDefinition> mapId2CodeDefinition = new HashMap<Integer, CodeDefinition>();

	public CodeDefinition buildRow() {
		final Integer index = Integer.valueOf((int) (Math.random() * lenOfArr));
		CodeDefinition codeDefinition = mapId2CodeDefinition.get(index);
		if (codeDefinition!=null) {
			return codeDefinition;
		}
		
		synchronized (this) {
				CodeDefinition codeDefinitionCheck = mapId2CodeDefinition.get(index);
				if (codeDefinitionCheck==null) {
					codeDefinitionCheck = new CodeDefinition(index, buildRowWithIndex(index));
					mapId2CodeDefinition.put(index, codeDefinitionCheck);
				} 
				return codeDefinitionCheck;
		}
	}

	protected String buildRowWithIndex(final int index) {
			final String medbranch = medArr[index];
			final String medShort = medShortArr[index];
		return String.format("%s,ORION,%s,%s,0,false,false,Cukes %s description", medShort, medbranch, medbranch, medShort);
	}

	String getColumnNames() {
		return "code.codeDefinition.identifier.code,"
				+ "code.codeDefinition.identifiercodingSystem,"
				+ "code.codeDefinition.description,"
				+ "code.codeDefinition.description.shortDescription,"
				+ "code.codeDefinition.description.orderIndex,"
				+ "code.codeDefinition.description.deleted,"
				+ "code.codeDefinition.description.freeText,"
				+ "code.suppliedDescription";
	}

}

