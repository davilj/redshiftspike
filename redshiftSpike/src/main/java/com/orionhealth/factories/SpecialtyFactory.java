package com.orionhealth.factories;

import java.util.LinkedHashMap;

import javax.json.JsonObject;

public class SpecialtyFactory extends Factory {
	/**
	 * "specialties" : [ {
        "identifier" : {
          "code" : "END",
          "codingSystem" : "ORION"
        },
        "description" : "Endocrinology",
        "shortDescription" : "Endo",
        "orderIndex" : 0,
        "deleted" : false,
        "freeText" : false
      }
	 */
	
	static final String[] branches = {
	"Anatomy", 
	"Biochemistry","Biomechanics","Biostatistics","Biophysics",
	"Cytology",
	"Embryology","Endocrinology","Epidemiology",
	"Genetics","Histology","Immunology","Microbiology","Molecular","Neuroscience","Nutrition","Pathology","Pharmacology","Photobiology",
	"Physiology","Radiobiology","Toxicology"
	};
	
	private CodeSetFactory idFac;
	
	public SpecialtyFactory(int numberOfAddress, int propOfDuplicate) {
		
	}
	
	public SpecialtyFactory() {
		super(branches.length, 95);
		this.idFac = new CodeSetFactory(0,100);
	}

	@Override
	protected JsonObject createJsonObject() {
		LinkedHashMap<String, Object> values = new LinkedHashMap<String, Object>();
		values.put("identifier",this.idFac.createAsJsonObj());
		String branch = buildMedicineBranchName();
		values.put("description",branch);
		values.put("shortDescription", branch.substring(0,5));
		values.put("deleted", buildRandomBoolean());
		values.put("orderIndex", buildRandomNumericString(2));
		values.put("freeText", buildRandomBoolean());
		return buildObjectFromMap(values);
	}

	private String buildMedicineBranchName() {
		return branches[(int)(Math.random() *  branches.length)];
	}

}
