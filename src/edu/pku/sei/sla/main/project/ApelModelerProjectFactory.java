package edu.pku.sei.sla.main.project;

import org.eclipse.core.resources.IProject;

import edu.pku.sei.gmp.project.GMPProject;
import edu.pku.sei.gmp.project.IProjectFactory;

public class ApelModelerProjectFactory implements IProjectFactory {
	@Override
	public GMPProject createProject(IProject proj) {
		return new ApelModelerProject(proj);
	}

	@Override
	public String getNature() {
		return ApelModelerProject.PROJECT_NATURE;
	}
}
