package edu.pku.sei.sla.util;

public class SmartInfoCenter {
	String pkg_name;

	String Pkg_prefix;

	String pkg_model_name;

	public String getPkg_prefix() {
		return Pkg_prefix;
	}

	public void setPkg_prefix(String pkgPrefix) {
		Pkg_prefix = pkgPrefix;
	}

	public String getPkg_model_name() {
		return pkg_model_name;
	}

	public void setPkg_model_name(String pkgModelName) {
		pkg_model_name = pkgModelName;
	}

	public static void setInstance(SmartInfoCenter instance) {
		SmartInfoCenter.instance = instance;
	}

	public String getPkg_name() {
		return pkg_name;
	}

	public void setPkg_name(String pkgName) {
		pkg_name = pkgName;
	}

	private static SmartInfoCenter instance = null;

	public static SmartInfoCenter getInstance() {

		if (instance == null)
			instance = new SmartInfoCenter();
		return instance;
	}
}
