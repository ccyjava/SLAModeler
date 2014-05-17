package edu.pku.sei.apel.main.action;

import edu.pku.sei.apel.ctrl.editpart.SLAEditPartFactory;
import edu.pku.sei.apel.main.palette.SLAPaletteFactory;
import edu.pku.sei.gmp.editor.GMPEditorInput;
import edu.pku.sei.gmp.editor.action.AbstractOpenDiagramAction;
import edu.pku.sei.gmp.model.common.GMPModel;

public class SLAOpenDiagramAction extends AbstractOpenDiagramAction {

	public SLAOpenDiagramAction(Object treeObj) {
		// TODO Auto-generated constructor stub
		super(treeObj);
	}

	public SLAOpenDiagramAction() {
		super();
	}

	@Override
	public void configureEditorInput(GMPEditorInput input) {
		GMPModel model = input.getDiagram().getModel();
		input.setEditPartFactory(new SLAEditPartFactory());
		input.setPaletteFactory(new SLAPaletteFactory(model));

	}

}
