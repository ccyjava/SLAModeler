package edu.pku.sei.sla.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import edu.pku.sei.gmp.model.concept.GMPModelElement;

public class Tools {
	public static String getnames(GMPModelElement element) {

		String tnames[] = element.getClass().getName().split("\\.");
		if (tnames.length > 0)
			return tnames[tnames.length - 1];
		return "";
	}

	public static Map<String, Set<String>> getCRT(String path) {
		Map<String, Set<String>> crt = new HashMap<String, Set<String>>();
		try {
			FileReader fr = new FileReader(path);
			BufferedReader br = new BufferedReader(fr);
			String line = "";
			while ((line = br.readLine()) != null) {
				if (line.startsWith("#"))
					continue;
				String e_names[] = line.split(" ");
				for (int i = 1; i < e_names.length; i++) {
					if (!crt.containsKey(e_names[i])) {
						crt.put(e_names[i], new HashSet<String>());
					}
					crt.get(e_names[i]).add(e_names[0]);
				}
			}
			fr.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return crt;
	}

}
