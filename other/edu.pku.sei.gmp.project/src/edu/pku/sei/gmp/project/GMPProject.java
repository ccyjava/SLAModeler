package edu.pku.sei.gmp.project;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.PlatformObject;

import edu.pku.sei.gmp.model.common.GMPModel;
import edu.pku.sei.gmp.project.exception.ProjectLoadException;
import edu.pku.sei.gmp.project.exception.ProjectSaveException;

public abstract class GMPProject extends PlatformObject implements
		IProjectNature {
	protected IProject project;
	public static final String GMP_COMMON_NATURE = "edu.pku.sei.gmp.common.project";
	
	
	/**
	 * 一个项目可能有多个GMPModel，比如元建模工具，可能需要领域元模型以及表示法元模
	 * 型
	 */
	private List<GMPModel> models = new ArrayList<GMPModel>();

	@Override
	public void configure() throws CoreException {
	}

	@Override
	public void deconfigure() throws CoreException {
	}

	@Override
	public IProject getProject() {
		return project;
	}

	@Override
	public void setProject(IProject project) {
		this.project = project;
	}

	public List<GMPModel> getModels() {
		return models;
	}

	public void addModel(GMPModel model) {
		models.add(model);
	}

	public void removeModel(GMPModel model) {
		models.remove(model);
	}

	public abstract String getProjectNature();

	public abstract void load() throws ProjectLoadException;

	public abstract void save() throws ProjectSaveException;
	
	public abstract void initProject();
}
