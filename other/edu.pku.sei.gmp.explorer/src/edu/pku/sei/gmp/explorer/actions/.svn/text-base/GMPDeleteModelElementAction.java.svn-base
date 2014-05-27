package edu.pku.sei.gmp.explorer.actions;

import java.util.List;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.jface.action.Action;

import edu.pku.sei.gmp.common.cmdstack.GMPCommandStack;
import edu.pku.sei.gmp.controller.command.GMPCommandFactoryRegistry;
import edu.pku.sei.gmp.model.common.GMPModel;
import edu.pku.sei.gmp.model.concept.GMPModelElement;
import edu.pku.sei.gmp.project.util.GMPProjectUtils;
import edu.pku.sei.gmp.resource.image.GMPImageProvider;

public class GMPDeleteModelElementAction extends Action {
	private Command deleteCommand;
	private CommandStack commandStack;

	public GMPDeleteModelElementAction(List<?> selectedItems) {
		setText("Delete");
		setImageDescriptor(GMPImageProvider
				.getImageDescriptor(GMPImageProvider.DELETE));
		if (selectedItems == null || selectedItems.isEmpty()) {
			setEnabled(false);
			return;
		}
		if (selectedItems.get(0) instanceof GMPModelElement) {
			GMPModelElement modelElement = (GMPModelElement) selectedItems
					.get(0);
			GMPModel model = modelElement.getModel();
			String projectNature = GMPProjectUtils.model2project(model)
					.getProjectNature();
			deleteCommand = GMPCommandFactoryRegistry.getInstance()
					.getCommandFactory(projectNature).getDeleteCommand(
							modelElement);
			if (deleteCommand == null) {
				setEnabled(false);
			} else {
				commandStack = GMPCommandStack.getCommandStack(model);
				setEnabled(true);
			}
		}
	}

	public void run() {
		if (deleteCommand != null) {
			commandStack.execute(deleteCommand);
		}
	}
}
