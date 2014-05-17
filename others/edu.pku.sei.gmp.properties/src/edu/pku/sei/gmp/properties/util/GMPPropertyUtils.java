package edu.pku.sei.gmp.properties.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class GMPPropertyUtils {
	
	public static boolean isPrimitive(Class<?> type) {
		if (type.isPrimitive())
			return true;
		if (type.equals(Integer.class) || type.equals(Boolean.class)
				|| type.equals(Float.class) || type.equals(Double.class))
			return true;
		return false;
	}

	public static boolean isPrimitiveOrString(Class<?> type) {
		if (type.equals(String.class))
			return true;
		return isPrimitive(type);
	}

	public static Object createInstance(Class<?> type)
			throws InstantiationException, IllegalAccessException {
		if (type == String.class)
			return "";
		else if (type == int.class || type == Integer.class)
			return 0;
		else if (type == boolean.class || type == Boolean.class)
			return false;
		else if (type == double.class || type == Double.class)
			return 0.0;
		else if (type == float.class || type == Float.class)
			return 0.0f;
		return type.newInstance();
	}
	
	public static List<Field> getAllField(Class<?> type) {
		Class<?> elementClass = type;
		List<Field> allFields = new ArrayList<Field>();
		while (elementClass != Object.class) {
			Field[] fields = elementClass.getDeclaredFields();
			for (Field field : fields) {
				allFields.add(field);
			}
			elementClass = elementClass.getSuperclass();
		}
		return allFields;
	}
	
	public static int parseInt(String str, int defaultValue) {
		int value = defaultValue;
		try {
			value = Integer.parseInt(str);
		} catch (Exception e) {
			value = defaultValue;
		}
		return value;
	}
	
	public static float parseFloat(String str, float defaultValue) {
		float value = defaultValue;
		try {
			value = Float.parseFloat(str);
		} catch (Exception e) {
			value = defaultValue;
		}
		return value;
	}
	
	public static double parseDouble(String str, double defaultValue) {
		double value = defaultValue;
		try {
			value = Double.parseDouble(str);
		} catch (Exception e) {
			value = defaultValue;
		}
		return value;
	}
	
	public static char parseChar(String str, char defaultValue) {
		char value = defaultValue;
		try {
			value = str.charAt(0);
		} catch (Exception e) {
			value = defaultValue;
		}
		return value;
	}
}
