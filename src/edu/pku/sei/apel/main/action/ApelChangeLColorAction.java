package edu.pku.sei.apel.main.action;

import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.ColorDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import edu.pku.sei.apel.ctrl.command.ApelChangeLineColorCommand;
import edu.pku.sei.gmp.controller.editpart.GMPNodeEditPart;
import edu.pku.sei.gmp.model.concept.GMPElement;
import edu.pku.sei.gmp.resource.GMPResourceGroupManager;
import edu.pku.sei.gmp.resource.color.GMPColor;

public class ApelChangeLColorAction extends Action {
	private List<GMPNodeEditPart> editparts;
	protected Shell shell = new Shell(PlatformUI.getWorkbench().getActiveWorkbenchWindow()
			.getActivePage().getWorkbenchWindow().getShell(), SWT.DIALOG_TRIM | SWT.RESIZE | SWT.SYSTEM_MODAL);
	
	public ApelChangeLColorAction(List<GMPNodeEditPart> list) {
		super();
		this.setText("Change Line Color");
		this.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
				getImageDescriptor(ISharedImages.IMG_OBJ_ELEMENT));
		editparts = list;
	}

	public void run(){
		ColorDialog cd = new ColorDialog(shell);
		cd.setText("Change Line Color");
		cd.setRGB(new RGB(255, 255, 255));
		RGB color = cd.open();
		if (color == null){
			return;
		}
		Color nColor = GMPResourceGroupManager.getSWTColor(new GMPColor(color));
		ApelChangeLineColorCommand cmd = new ApelChangeLineColorCommand(
				editparts, nColor);
		((GMPElement)editparts.get(0).getModel()).getCommandStack().execute(cmd);	
	}
}
