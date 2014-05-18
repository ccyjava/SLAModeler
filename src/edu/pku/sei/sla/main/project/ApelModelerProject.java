package edu.pku.sei.sla.main.project;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;

import edu.pku.sei.gmp.model.common.GMPModel;
import edu.pku.sei.gmp.model.common.GMPModelFactory;
import edu.pku.sei.gmp.model.xml.GMPXMLSaveLoader;
import edu.pku.sei.gmp.project.GMPProject;
import edu.pku.sei.gmp.project.exception.ProjectLoadException;
import edu.pku.sei.gmp.project.exception.ProjectSaveException;
import edu.pku.sei.sla.model.common.SLAModelConst;

import edu.pku.sei.sla.model.sla.SLAModel;
import edu.pku.sei.sla.util.SmartModelFactory;

public class ApelModelerProject extends GMPProject {
	public static String PROJECT_NATURE = "edu.pku.sei.apel.ApelModeler";

	// private static final String bpelModelName = "bpel";
	// private static final String wsdlModelName = "wsdl";
	// private static final String cooperationModelName = "cooperation";
	private static final String slaModelName = "sla";

	public ApelModelerProject(IProject project) {
		super();
		this.project = project;
	}

	@Override
	public String getProjectNature() {
		return PROJECT_NATURE;
	}

	@Override
	public void configure() throws CoreException {
	}

	@Override
	public void deconfigure() throws CoreException {
	}

	@Override
	public void save() throws ProjectSaveException {
		if (project == null)
			return;
		String parentDir = project.getLocation().toOSString();
		String path = "";
		GMPXMLSaveLoader saveLoader = new GMPXMLSaveLoader();

		path = parentDir + "/" + slaModelName;
		SLAModel sModel = getSLAModel();
		saveLoader = new GMPXMLSaveLoader();
		try {
			saveLoader.save(sModel, path, SLAModelConst.__SLAMODEL__);
		} catch (Exception e) {
			throw new ProjectSaveException(e);
		}

	}

	@Override
	public void load() throws ProjectLoadException {

		String parentDir = project.getLocation().toOSString();
		String path = "";

		GMPXMLSaveLoader saveLoader = new GMPXMLSaveLoader();

		initSLAModel();
		path = parentDir + "/" + slaModelName;
		SLAModel sModel = getSLAModel();
		saveLoader = new GMPXMLSaveLoader();
		try {
			saveLoader.load(sModel, path, SLAModelConst.__SLAMODEL__);
		} catch (Exception e) {
			throw new ProjectLoadException(e);
		}
	}

	@Override
	public void initProject() {

		initSLAModel();
	}

	private void initSLAModel() {
		// SLAModelFactory sModelFactory = new SLAModelFactory();
		GMPModelFactory sModelFactory = new SmartModelFactory(
				"edu.pku.sei.sla.model.sla");
		SLAModel sModel = (SLAModel) sModelFactory
				.createModelElement(SLAModelConst.__SLAMODEL__);
		sModel.setModelFactory(sModelFactory);
		sModelFactory.setModel(sModel);
		this.addModel(sModel);
	}

	public SLAModel getSLAModel() {
		for (GMPModel m : getModels())
			if (m instanceof SLAModel)
				return (SLAModel) m;
		return null;
	}

}
