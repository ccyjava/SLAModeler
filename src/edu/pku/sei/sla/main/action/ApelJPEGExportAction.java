package edu.pku.sei.sla.main.action;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.SWTGraphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import edu.pku.sei.gmp.editor.GMPModelerEditor;
import edu.pku.sei.gmp.resource.image.GMPImageProvider;

public class ApelJPEGExportAction extends Action {
	public ApelJPEGExportAction() {
		super("Export as JPEG");
		setImageDescriptor(GMPImageProvider.getImageDescriptor(GMPImageProvider.JPEG));
	}
	@Override
	public void run() {
		try {
			IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			FileDialog fDlg = new FileDialog(page.getActivePart().getSite().getShell(), SWT.SAVE);
			fDlg.setText("Export JPEG file");
			fDlg.setFilterExtensions(new String[]{"*.jpg", "*.jpeg"});
			String filename = fDlg.open();
			if(filename == null)return;
			
			GMPModelerEditor editor = (GMPModelerEditor)page.getActiveEditor();
			ScalableFreeformRootEditPart rootPart = (ScalableFreeformRootEditPart) editor.getGraphicalViewer().getRootEditPart();
			IFigure figure = rootPart.getLayer(ScalableFreeformRootEditPart.PRINTABLE_LAYERS);//To ensure every graphical element is included
			byte[] data = createImage(figure);
			FileOutputStream fos = new FileOutputStream(filename);
			fos.write(data);
			fos.close();
			MessageDialog.openInformation(editor.getSite().getShell(), "JPEG Export",
					"图片已保存到�?" + filename);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * See http://dev.eclipse.org/newslists/news.eclipse.tools.gef/msg05012.html
	 * @param figure
	 * @param format
	 * @return
	 */
	private byte[] createImage(IFigure figure) {
		Rectangle r = figure.getBounds();
		ByteArrayOutputStream result = new ByteArrayOutputStream();
		Image image = null;
		GC gc = null;
		Graphics g = null;
		try {
			image = new Image(null, r.width, r.height);
			gc = new GC(image);
			g = new SWTGraphics(gc);
			g.translate(r.x * -1, r.y * -1);
			figure.paint(g);
			ImageLoader imageLoader = new ImageLoader();
			imageLoader.data = new ImageData[] { image.getImageData() };
			imageLoader.save(result, SWT.IMAGE_JPEG);	
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if (g != null)
				g.dispose();
			if (gc != null)
				gc.dispose();
			if (image != null)
				image.dispose();
		}
		return result.toByteArray();
	}	
}
