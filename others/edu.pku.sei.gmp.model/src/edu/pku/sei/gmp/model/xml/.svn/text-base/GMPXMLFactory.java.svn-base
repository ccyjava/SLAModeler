package edu.pku.sei.gmp.model.xml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import edu.pku.sei.gmp.model.concept.GMPElement;

public abstract class GMPXMLFactory {
	
	HashMap<Integer, HashMap<GMPElement, List<String>>> dynamicSetMap = 
		new HashMap<Integer, HashMap<GMPElement, List<String>>>();
	
	public abstract GMPElement create(String type);

	public abstract GMPElement id2element(int id);
	
	
	public void registerDynamicSet(int id, GMPElement element, String featureId) {
		HashMap<GMPElement, List<String>> featureMap = dynamicSetMap.get(id);
		if (featureMap == null) {
			featureMap = new HashMap<GMPElement, List<String>>();
			List<String> featureList = new ArrayList<String>();
			featureList.add(featureId);
			featureMap.put(element, featureList);
			dynamicSetMap.put(id, featureMap);
		} else {
			List<String> featureList = featureMap.get(element);
			if (featureList == null) {
				featureList = new ArrayList<String>();
				featureList.add(featureId);
				featureMap.put(element, featureList);
			} else {
				featureList.add(featureId);
			}
		}
	}

	public void checkDynamicSet(int id, Object value) {
		HashMap<GMPElement, List<String>> map = dynamicSetMap.get(id);
		if (map != null) {
			for (GMPElement element : map.keySet()) {
				for (String feature : map.get(element)) {
					element.dynamicSet(feature, value);
				}
			}
		}
	}
	
}
