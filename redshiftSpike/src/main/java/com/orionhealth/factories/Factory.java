package com.orionhealth.factories;

import java.util.HashMap;
import java.util.Map;

public abstract class Factory<P> {
	private Map<Integer, P> mapId2P = new HashMap<Integer, P>();
	private int size;
	

	public Factory() {
		super();
	}
		
	

	public P create() {
		final Integer index = Integer.valueOf((int) (Math.random() * size));
		P aP = mapId2P.get(index);
		if (aP!=null) {
			return aP;
		}
		
		synchronized (this) {
				P aPCheck = mapId2P.get(index);
				if (aPCheck==null) {
					aPCheck = construct(index, buildRowWithIndex(index));
					mapId2P.put(index, aPCheck);
				} 
				return aPCheck;
		}
	}
	
	abstract protected P construct(Integer index, String row);

	abstract protected String buildRowWithIndex(Integer index);

	abstract public String getColumnNames();

	

}