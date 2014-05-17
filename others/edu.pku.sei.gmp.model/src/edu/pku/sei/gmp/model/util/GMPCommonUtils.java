package edu.pku.sei.gmp.model.util;

public class GMPCommonUtils {
	public static int parseInt(String str, int defaultValue) {
		int value = defaultValue;
		try {
			value = Integer.parseInt(str);
		} catch (Exception e) {
			value = defaultValue;
		}
		return value;
	}
}
