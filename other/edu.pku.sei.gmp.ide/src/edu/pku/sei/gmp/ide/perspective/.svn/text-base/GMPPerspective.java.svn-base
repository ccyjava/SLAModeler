package edu.pku.sei.gmp.ide.perspective;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class GMPPerspective implements IPerspectiveFactory {

	@Override
	public void createInitialLayout(IPageLayout layout) {
		// 得到本透视图的编辑空间标识
		String editorArea = layout.getEditorArea();
		/*
		 * 将GMPModelExplorer加入透视图的左部
		 * "left"视图区的id标识为"left"
		 * IPageLayout.LEFT 在透视图布局中的位置靠左
		 * 0.2f 占用透视图20％的宽度
		 * editorArea 使用透视图的编辑空间
		 */
		IFolderLayout left = layout.createFolder("left", 
				IPageLayout.LEFT, 0.2f, editorArea);
		// 加入视图的参数为plugin.xml中GMPModelExplorer的id标识
		left.addView("edu.pku.sei.gmp.explorer.GMPModelExplorer");
		
		//将大纲视图加入元模型视图的下方
		IFolderLayout leftdown = layout.createFolder("leftdown", 
				IPageLayout.BOTTOM, 0.5f, "left");
		leftdown.addView("org.eclipse.ui.views.ContentOutline");
		
		// 将属性页放到透视图的下方
		IFolderLayout property = layout.createFolder("property", 
				IPageLayout.BOTTOM, 0.7f, editorArea);
		property.addView("edu.pku.sei.gmp.properties.view.GMPPropertyView");
	}

}
