package edu.pku.sei.gmp.properties.registry;

import java.util.HashMap;

import edu.pku.sei.gmp.properties.core.GMPElementProperty;

/**
 * Not for registering, just for cache!!!
 * 
 * @author yangyz
 * 
 */
public class GMPElementPropertyRegistry {
	private GMPElementPropertyRegistry() {

	}

	private static GMPElementPropertyRegistry instance = null;

	public static GMPElementPropertyRegistry getInstance() {
		if (instance == null) {
			instance = new GMPElementPropertyRegistry();
		}
		return instance;
	}

	private HashMap<Class<?>, GMPElementProperty> map = new HashMap<Class<?>, GMPElementProperty>();

	public GMPElementProperty getElementProperty(Object source) {
		Class<?> sourceType = source.getClass();
		GMPElementProperty elementProperty = map.get(sourceType);
		if (elementProperty != null) {
			return elementProperty;
		} else {
			elementProperty = new GMPElementProperty(sourceType);
			map.put(sourceType, elementProperty);
			return elementProperty;
		}
	}
}
