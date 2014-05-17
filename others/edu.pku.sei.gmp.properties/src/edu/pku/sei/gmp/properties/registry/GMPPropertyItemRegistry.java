package edu.pku.sei.gmp.properties.registry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import edu.pku.sei.gmp.properties.core.GMPPropertyItem;

/**
 * Custom property item registry. This is a singleton holding a map with a key
 * of model <code>Class</code>, and a value of
 * <code>List&ltGMPPropertyItem&gt</code>. The GMP platform generates default
 * <code>GMPDefaultPropertyItem</code>s for fields in model classes, and if you
 * want to custom one property item for a specific field in a specific class,
 * some steps will be needed:
 * <ul>
 * <li>implement your own <code>GMPPropertyItem</code>, in which you may specify
 * the {@code id}, {@code name}, {@code category}, and {@code getValue}, {@code
 * setValue}, {@code getDescriptor}.</li>
 * <li>register the {@code GMPPropertyItem} object here.</li>
 * 
 * @author yangyz
 * 
 */
public class GMPPropertyItemRegistry {
	private HashMap<Class<?>, List<GMPPropertyItem>> map = 
		new HashMap<Class<?>, List<GMPPropertyItem>>();

	/**
	 * Register the custom property item. You can register multiple items for
	 * one {@code sourceType}, the registry here holds a list of {@code
	 * GMPPropertyItem} for one {@code sourceType}.
	 * 
	 * @param sourceType
	 * @param propertyItem
	 */
	public void registerPropertyItem(Class<?> sourceType,
			GMPPropertyItem propertyItem) {
		assert (sourceType != null && propertyItem != null);
		List<GMPPropertyItem> items = map.get(sourceType);
		if (items == null) {
			items = new ArrayList<GMPPropertyItem>();
			items.add(propertyItem);
			map.put(sourceType, items);
		} else {
			items.add(propertyItem);
		}
	}

	/**
	 * Get all the property items associated with the type {@code sourceType}.
	 * It will return a list of {@code GMPPropertyItem}, in which is all the
	 * property items registered by the {@code sourceType} or its super class as
	 * their key.
	 * 
	 * @param sourceType
	 * @return list of {@code GMPPropertyItem}
	 */
	public List<GMPPropertyItem> getPropertyItem(Class<?> sourceType) {
		List<GMPPropertyItem> result = new ArrayList<GMPPropertyItem>();
		while (!sourceType.equals(Object.class)) {
			List<GMPPropertyItem> list = map.get(sourceType);
			if (list != null) {
				result.addAll(list);
			}
			sourceType = sourceType.getSuperclass();
		}
		List<GMPPropertyItem> list = map.get(Object.class);
		if (list != null) {
			result.addAll(list);
		}
		
		return result;
	}

	private GMPPropertyItemRegistry() {
	}

	private static GMPPropertyItemRegistry instance = null;

	public static GMPPropertyItemRegistry getInstance() {
		if (instance == null) {
			instance = new GMPPropertyItemRegistry();
		}
		return instance;
	}
}
