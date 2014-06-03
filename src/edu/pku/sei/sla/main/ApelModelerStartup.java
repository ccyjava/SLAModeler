package edu.pku.sei.sla.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

import org.eclipse.ui.IStartup;

import edu.pku.sei.gmp.controller.command.GMPCommandFactory;
import edu.pku.sei.gmp.controller.command.GMPCommandFactoryRegistry;
import edu.pku.sei.gmp.editor.registry.GMPEditorActionProviderRegistry;
import edu.pku.sei.gmp.editor.registry.GMPEditorDropTargetListenerProxyonRegistry;
import edu.pku.sei.gmp.explorer.registry.GMPExplorerActionProviderRegistry;
import edu.pku.sei.gmp.explorer.registry.GMPExplorerDropAdapterProxyonRegistry;
import edu.pku.sei.gmp.explorer.registry.GMPExplorerProviderRegistry;
import edu.pku.sei.gmp.project.registry.GMPProjectRegistry;
import edu.pku.sei.sla.ctrl.command.ApelCommandFactory;
import edu.pku.sei.sla.main.project.ApelModelerProject;
import edu.pku.sei.sla.main.project.ApelModelerProjectFactory;
import edu.pku.sei.sla.main.provider.ApelContentProvider;
import edu.pku.sei.sla.main.provider.ApelEditorActionProvider;
import edu.pku.sei.sla.main.provider.ApelEditorDropTargetListenerProxyon;
import edu.pku.sei.sla.main.provider.ApelExplorerActionProvider;
import edu.pku.sei.sla.main.provider.ApelLabelProvider;
import edu.pku.sei.sla.main.provider.ApelViewerDropAdapterProxyon;
import edu.pku.sei.sla.util.SmartCommandFactory;
import edu.pku.sei.sla.util.SmartInfoCenter;
import edu.pku.sei.sla.util.SmartPaletteFactory;
import edu.pku.sei.sla.util.Test;

public class ApelModelerStartup implements IStartup {
	@Override
	public void earlyStartup() {
		register();
		Test.getAllClass();

		try {
			// FileReader fr = new FileReader("config.txt");
			// BufferedReader br = new BufferedReader(fr);
			// String line = "";
			// while ((line = br.readLine()) != null) {
			// System.out.println(line);
			// }
			FileWriter fw = new FileWriter("a.txt");
			fw.write("test");
			fw.close();
			File f = new File("a.txt");
			System.out.println(f.getCanonicalPath());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * register the project specific facilities to the GMP registries.
	 */
	private void register() {
		// register project factory
		ApelModelerProjectFactory factory = new ApelModelerProjectFactory();
		GMPProjectRegistry.getInstance().registerFactory(factory);

		// register contentProvider,labelProvider for ModelExplorer
		GMPExplorerProviderRegistry.getInstance().registerProvider(
				ApelModelerProject.PROJECT_NATURE, new ApelContentProvider(),
				new ApelLabelProvider());

		// register actionProvider for ModelExplorer
		GMPExplorerActionProviderRegistry.getInstance().registerActionProvider(
				new ApelExplorerActionProvider());

		// register dropAdapterProxyon for ModelExplorer
		GMPExplorerDropAdapterProxyonRegistry.getInstance().registerProxyon(
				ApelModelerProject.PROJECT_NATURE,
				new ApelViewerDropAdapterProxyon());

		// register actionProvider for ModelerEditor
		GMPEditorActionProviderRegistry.getInstance().registerActionProvider(
				new ApelEditorActionProvider());

		// register dropTargetListenerProxyon for ModelerEditor
		GMPEditorDropTargetListenerProxyonRegistry.getInstance()
				.registerProxyon(ApelModelerProject.PROJECT_NATURE,
						new ApelEditorDropTargetListenerProxyon());

		// GMPCommandFactoryRegistry.getInstance().registerCommandFactory(
		// ApelModelerProject.PROJECT_NATURE,
		// ApelCommandFactory.getInstance());

		GMPCommandFactory cf = SmartCommandFactory.getInstance()
				.init_contain_relation_table("config.txt");

		GMPCommandFactoryRegistry.getInstance().registerCommandFactory(
				ApelModelerProject.PROJECT_NATURE, cf);

		SmartInfoCenter.getInstance().setPkg_prefix("edu.pku.sei.sla");
		SmartInfoCenter.getInstance().setPkg_model_name("sla");
		
		SmartPaletteFactory.register("edu.pku.sei.sla.model.sla", "config.txt");
	}
}
