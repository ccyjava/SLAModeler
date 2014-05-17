package edu.pku.sei.gmp.project.util;

import java.util.List;

import org.eclipse.core.resources.IProject;

import edu.pku.sei.gmp.model.common.GMPModel;
import edu.pku.sei.gmp.project.GMPProject;
import edu.pku.sei.gmp.project.registry.GMPProjectRegistry;

public class GMPProjectUtils {
	
	/**
	 * get the GMPProject from a GMPModel
	 * 
	 * @param model
	 * @return
	 */
	public static GMPProject model2project(GMPModel model) {
		for (GMPProject p : GMPProjectRegistry.getInstance().getAllProjects()) {
			for (GMPModel m : p.getModels()) {
				if (m == model) {
					return p;
				}
			}
		}
		return null;
	}
	
	/**
	 * get the correspondence GMPProject from an IProject object.
	 * 
	 * @param project
	 * @return
	 */
	public static GMPProject getGMPProject(IProject project) {
		List<GMPProject> projects = GMPProjectRegistry.getInstance()
				.getAllProjects();
		for (GMPProject p : projects) {
			if (p.getProject().equals(project)) {
				return p;
			}
		}
		return null;
	}
	
}
