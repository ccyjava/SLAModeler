package edu.pku.sei.gmp.editor.action.common;

import java.util.List;

import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.ui.IWorkbenchPart;

import edu.pku.sei.gmp.controller.editpart.GMPNodeEditPart;
import edu.pku.sei.gmp.model.shape.GMPNode;

public class GMPMoveNodesAction extends SelectionAction {
	
	public static final String UP = "MoveNodesAction.MoveUp";
	public static final String DOWN = "MoveNodesAction.MoveDown";
	public static final String LEFT = "MoveNodesAction.MoveLeft";
	public static final String RIGHT = "MoveNodesAction.MoveRight";
	
	public GMPMoveNodesAction(IWorkbenchPart part) {
		super(part);
	}
	
	public void run(){
		String id = this.getId();
		List<?> selectedObjs = this.getSelectedObjects();
		for(Object obj:selectedObjs) {
			if(!(obj instanceof GMPNodeEditPart))continue;
			GMPNode node = (GMPNode)((GMPNodeEditPart)obj).getModel();
			if(UP.equals(id)) {
				node.setLocationY(node.getLocationY()-1);
			}
			else if(DOWN.equals(id)) {
				node.setLocationY(node.getLocationY()+1);
			}
			else if(LEFT.equals(id)) {
				node.setLocationX(node.getLocationX()-1);
			}
			else if(RIGHT.equals(id)) {
				node.setLocationX(node.getLocationX()+1);
			}
		}
	}

	@Override
	protected boolean calculateEnabled() {
		return (this.getSelectedObjects().size() > 0);
	}
}
