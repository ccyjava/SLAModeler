package edu.pku.sei.sla.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;

import edu.pku.sei.gmp.controller.command.GMPCommandFactory;
import edu.pku.sei.gmp.controller.command.GMPCreateRelationCommand;
import edu.pku.sei.gmp.model.concept.GMPElement;
import edu.pku.sei.gmp.model.concept.GMPModelElement;
import edu.pku.sei.sla.model.sla.ComputeService;

public class SmartCommandFactory extends GMPCommandFactory {
	Map<String, Set<String>> crt;

	public static SmartCommandFactory getInstance() {
		return new SmartCommandFactory();
	}

	public SmartCommandFactory init_contain_relation_table(String path) {
		crt = Tools.getCRT(path);
		return this;
	}

	@Override
	protected boolean buildCompleteRelationCommand(
			GMPCreateRelationCommand cmd, GMPModelElement targetModel) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected Command getCreateRelationCommand(GMPModelElement sourceModel,
			GMPModelElement linkModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Command buildCreateModelElementCommand(GMPModelElement parent,
			GMPModelElement modelElement) {
		if (parent == null || modelElement == null)
			return null;
		String p_name, s_name;
		p_name = Tools.getnames(parent);
		s_name = Tools.getnames(modelElement);
		if (crt.containsKey(p_name)) {
			if (crt.get(p_name).contains(s_name)) {
				System.out.println("SmartCommandFactory create: " + p_name
						+ " " + s_name);
				return new SmartCreateCommand(parent, modelElement);
			}
		}
		return null;
	}

	@Override
	protected void buildDeleteSubModelElementCommand(CompoundCommand cmd,
			GMPModelElement modelElement) {
		if (modelElement != null) {
			for (GMPElement element : modelElement.getChildren()) {
				cmd.add(getDeleteCommand(element));
			}
		}

	}

	@Override
	protected Command getDeleteDirectModelElementCommand(
			GMPModelElement modelElement) {
		if (modelElement != null && modelElement.getContainer() != null) {

			System.out.println("SmartDeleteFactory create: "
					+ Tools.getnames(modelElement));
			return new SmartDeleteCommand(modelElement);
		}
		return null;
	}

}
