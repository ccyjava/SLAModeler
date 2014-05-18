package edu.pku.sei.sla.util;

import edu.pku.sei.sla.model.sla.ComputeService;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ComputeService cs = new ComputeService();
		try {
			System.out.println(Class.forName("noclass"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
