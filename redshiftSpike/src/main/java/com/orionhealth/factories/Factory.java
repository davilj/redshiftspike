package com.orionhealth.factories;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.json.Json;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

public abstract class Factory {

	protected List<JsonObject> cache;
	protected int propOfDuplicate;
	
	protected JsonBuilderFactory factory = Json.createBuilderFactory(null);
	
	public Factory(int numberOfAddress, int propOfDuplicate) {
		cache = new ArrayList<JsonObject>(numberOfAddress);
		this.propOfDuplicate = propOfDuplicate;
	}

	public Factory() {
		super();
	}

	public String createAsJsonString() {
		return createAsJsonObj().toString();
	}

	public JsonObject createAsJsonObj() {
		boolean duplicate = (Math.random() * 100) <= this.propOfDuplicate;
		if (duplicate && cache.size()>0) {
			int index = (int)(Math.random() * cache.size());
			return cache.get(index);
		} else {
			JsonObject obj = createJsonObject();
			cache.add(obj);
			return obj;
		}
	}
	
	protected abstract JsonObject createJsonObject();

	protected String buildRandomBoolean() {
		return Math.random() > 0.5?"True":"False";
	}

	protected String buildRandomNumericString(int digits) {
		int number = (int)(digits * 10 * Math.random());
		return String.format("%0"+digits+"d", number);
	}

	protected String buildRandomString(String prefix, String postfix, String concatChar,
			int range) {
				StringBuilder stringBuilder = new StringBuilder();
				stringBuilder.append(prefix==null?"":prefix);
				stringBuilder.append(concatChar==null?"":concatChar);
				if (range == 0 && postfix==null) return stringBuilder.toString();
				
				stringBuilder.append((int)(Math.random() * range));
				
				if (postfix==null) return stringBuilder.toString();
				stringBuilder.append(concatChar==null?"":concatChar);
				stringBuilder.append(postfix==null?"":postfix);
				
				return stringBuilder.toString();
			}

	protected JsonObject buildObjectFromMap(LinkedHashMap<String, Object> buildMap) {
		JsonObjectBuilder builder = this.factory.createObjectBuilder();
		for (Map.Entry<String, Object> key : buildMap.entrySet()) {
			builder.add(key.getKey(), key.getValue().toString());
		}
		return builder.build();
	}

}