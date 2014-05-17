package edu.pku.sei.sla.main;

import org.eclipse.ui.IStartup;

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

public class ApelModelerStartup implements IStartup {
	@Override
	public void earlyStartup() {
		register();
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

		GMPCommandFactoryRegistry.getInstance().registerCommandFactory(
				ApelModelerProject.PROJECT_NATURE,
				ApelCommandFactory.getInstance());
	}

}
