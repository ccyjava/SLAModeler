package edu.pku.sei.sla.util;

import java.io.File;
import java.io.FilenameFilter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import edu.pku.sei.sla.model.sla.ComputeService;
import edu.pku.sei.sla.model.sla.SLAModelElement;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// ComputeService cs = new ComputeService();
		// try {
		// System.out.println(Class.forName("noclass"));
		// } catch (ClassNotFoundException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// getAllClass();
		try {
			Class.forName("edu.pku.sei.sla.model.sla" + ".ComputerService");
			System.out.println("YES!");
		} catch (Exception e) {
			System.out.println("NO!");
		}

	}

	public static void getAllClass() {
		String packageName = "edu.pku.sei.sla.model.sla";
		List<Class<SLAModelElement>> commands = new ArrayList<Class<SLAModelElement>>();
		URL root = Thread.currentThread().getContextClassLoader().getResource(
				packageName.replace(".", "/"));

		// Filter .class files.
		File[] files = new File(root.getFile()).listFiles(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.endsWith(".class");
			}
		});

		// Find classes implementing ICommand.
		for (File file : files) {
			String className = file.getName().replaceAll(".class$", "");
			Class<?> cls = null;

			try {
				cls = Class.forName(packageName + "." + className);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (SLAModelElement.class.isAssignableFrom(cls)) {
				commands.add((Class<SLAModelElement>) cls);
				System.out.println(cls.getName());
			}
		}
	}

}
