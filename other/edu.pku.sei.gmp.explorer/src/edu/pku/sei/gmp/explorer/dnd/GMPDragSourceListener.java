package edu.pku.sei.gmp.explorer.dnd;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;

public class GMPDragSourceListener implements DragSourceListener {
	
	private TreeViewer viewer;

	public GMPDragSourceListener(TreeViewer viewer) {
		this.viewer = viewer;
	}
	
	@Override
	public void dragFinished(DragSourceEvent event) {
		
	}

	@Override
	public void dragSetData(DragSourceEvent event) {
		if (viewer.getSelection() instanceof StructuredSelection) {
			StructuredSelection selection = (StructuredSelection) viewer
					.getSelection();
			Iterator<?> it = selection.iterator();
			List<Object> list = new ArrayList<Object>();
			for (; it.hasNext();) {
				list.add(it.next());
			}
			event.data = list;
		}
	}

	@Override
	public void dragStart(DragSourceEvent event) {
	
	}

}
