package edu.pku.sei.gmp.resource.image;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

/**
 * 
 * @author liyw
 * 
 */
public class GMPImageProvider {
	// These are available images
	public static final String CLASS_IMAGE = "Class.gif";
	public static final String TEMPLATENODE_IMAGE = "listView.gif";
	public static final String ATTRIBUTE_IMAGE = "attribute.gif";
	public static final String COMMENT_IMAGE = "comment.gif";
	public static final String FIELD_PUBLIC_IMAGE = "field_public.gif";
	public static final String FIELD_PROTECTED_IMAGE = "field_protected.gif";
	public static final String FIELD_PRIVATE_IMAGE = "field_private.gif";
	public static final String FIELD_PACKAGE_IMAGE = "field_package.gif";
	public static final String RELATION_IMAGE = "relation.gif";
	public static final String TEMPLATE_NODE_IMAGE = "template_node.gif";
	public static final String TEMPLATE_CONN_IMAGE = "template_conn.gif";
	public static final String TEMPLATE_SUBNODE_IMAGE = "template_subnode.gif";
	public static final String TEMPLATE_PORT_IMAGE = "template_port.gif";
	public static final String TEMPLATE_INTERFACE_IMAGE = "template_interface.gif";
	
	public static final String CONTAIER_IMAGE="collapsed.gif";

	public static final String PROJECT_IMG = "project.ICO";
	public static final String PROJECT_CLOSED_IMG = "project_closed.gif";
	public static final String FOLDER_IMG = "folder.ICO";
	public static final String FILE_IMG = "file.ICO";
	public static final String MODEL_VIEW = "modelView.gif";
	public static final String DIAGRAM = "diagram.gif";
	public static final String UNKNOWN = "unKnown.gif";
	public static final String DELETE = "remove.gif";

	public static final String CLASS_ENTRY = "Class.gif";
	public static final String TEMPLATENODE_ENTRY = "newModel.gif";
	public static final String INTERFACE_ENTRY = "interface_entry.gif";
	public static final String COMMENT = "comment.gif";
	public static final String COMMENT_ENTRY = "comment_entry.gif";
	public static final String ASSOCIATION_ENTRY = "Association.gif";
	public static final String GENERALIZATION_ENTRY = "Generalization.gif";
	public static final String PACKAGE_ENTRY = "package_entry.gif";
	public static final String PACKAGE = "package_entry.gif";
	public static final String RELATION = "relation.gif";
	public static final String PROJECT = "project.gif";
	public static final String FOLDER = "folder.gif";
	public static final String ATTRIBUTE = "attribute.gif";
	public static final String ENUM = "enum.gif";

	public static final String DEFAULT_BLOCK = "newModel.gif";
	public static final String DEFAULT_LINK = "default_link.gif";

	public static final String JPEG = "JPEG.gif";

	// for natation editor palette
	public static final String ELLIPSE = "Ellipse.gif";
	public static final String CIRCLE = "circle.jpg";
	public static final String RECTANGLE = "Rectangle.gif";
	public static final String CORNER_RECTANGLE = "Corner Rectangle.jpg";
	public static final String ROUNDED_RECTANGLE = "Rounded Rectangle.gif";
	public static final String TRIANGLE = "triangle.jpg";
	public static final String DIAMOND = "diamond.jpg";
	public static final String TEXT_OBJECT = "Text Object.gif";
	public static final String COMPOSITION = "Composition.jpg";
	public static final String LINE = "line.JPG";

	// for undo redo save
	public static final String UNDO = "undo_edit.gif";
	public static final String UNDO_DISABLED = "undo_edit_disabled.gif";
	public static final String REDO = "redo_edit.gif";
	public static final String REDO_DISABLED = "redo_edit_disabled.gif";
	public static final String SAVE = "save_edit.gif";
	public static final String SAVE_DISABLED = "save_edit_disabled.gif";

	// For UML Use Case Diagram
	public static final String ACTOR_IMAGE = "Actor.gif";
	public static final String USECASE_IMAGE = "UseCase.gif";
	public static final String EXTEND_IMAGE = "Extend.gif";
	public static final String INCLUDE_IMAGE = "Include.gif";
	public static final String ASSOCIATION_IMAGE = "Association.gif";
	public static final String GENERALIZATION_IMAGE = "Generalization.gif";
	public static final String USECASEDIAGRAM_IMAGE = "UseCaseDiagram.gif";
	public static final String SUBJECT_IMAGE = "Subject.gif";

	// For UML Class Diagram
	public static final String UML_CLASS_IMAGE = "UML_Class.gif";
	public static final String PROPERTY_IMAGE = "Property.gif";
	public static final String OPERATION_IMAGE = "Operation.gif";
	public static final String INTERFACE_IMAGE = "UML_Interface.gif";
	public static final String INSTANCESPECIFICATION_IMAGE = "InstanceSpecification.gif";
	public static final String PACKAGE_IMAGE = "Package.gif";
	public static final String DEPENDENCY_IMAGE = "Dependency.gif";
	public static final String INTERFACEREALIZATION_IMAGE = "InterfaceRealization.gif";
	public static final String REALIZATION_IMAGE = "Realization.gif";
	public static final String USAGE_IMAGE = "Usage.gif";
	public static final String PACKAGEIMPORT_IMAGE = "PackageImport.gif";
	public static final String PACKAGEMERGE_IMAGE = "PackageMerge.gif";
	public static final String CLASSDIAGRAM_IMAGE = "ClassDiagram.gif";

	// For UML Sequence Diagram
	public static final String SEQUENCEDIAGRAM_IMAGE = "SequenceDiagram.gif";
	public static final String INTERACTION_IMAGE = "Interaction.gif";
	public static final String LIFELINE_IMAGE = "Lifeline.gif";
	public static final String EXECUTIONOCCURRENCESPECIFICATION_IMAGE = "ExecutionOccurrence.gif";
	public static final String MESSAGE_IMAGE = "Message.gif";
	public static final String MESSAGE_SYNCHCALL_IMAGE = "Message_synchCall.gif";
	public static final String MESSAGE_ASYNCHCALL_IMAGE = "Message_asynchCall.gif";
	public static final String MESSAGE_REPLAY_IMAGE = "Message_reply.gif";
	public static final String DESTRUCTIONEVENT_IMAGE = "DestructionEvent.gif";
	public static final String STATEINVARIANT_IMAGE = "StateInvariant.gif";
	public static final String INTERACTIONOCCURRENCE_IMAGE = "InteractionOccurrence.gif";
	public static final String COMBINEDFRAGMENT_IMAGE = "CombinedFragment.gif";

	// For UML Activity Diagram
	public static final String ACTIVITYDIAGRAM_IAMGE = "ActivityDiagram.gif";
	public static final String ACTION_IMAGE = "Action.gif";
	public static final String CONTROLFLOW_IMAGE = "ControlFlow.gif";
	public static final String DECISIONNODE_IMAGE = "DecisionNode.gif";
	public static final String MERGENODE_IMAGE = "MergeNode.gif";
	public static final String FORKNODE_IMAGE = "ForkNode.gif";
	public static final String JOINNODE_IMAGE = "JoinNode.gif";
	public static final String INITIALNODE_IMAGE = "InitialNode.gif";
	public static final String ACTIVITYFINAL_IMAGE = "ActivityFinalNode.gif";
	public static final String ACTIVITY_IMAGE = "Activity.gif";
	public static final String FLOWFINAL_IMAGE = "FlowFinalNode.gif";
	public static final String DATASTORENODE_IMAGE = "DataStoreNode.gif";
	public static final String OBJECTFLOW_IMAGE = "ObjectFlow.gif";
	public static final String OBJECTNODE_IMAGE = "ObjectNode.gif";
	public static final String ACTIVITYPARTITION_IMAGE = "ActivityPartition.gif";

	// For UML Component Diagram
	public static final String COMPONENTDIAGRAM_IMAGE = "DiagramComponentDiagram.gif";
	public static final String COMPONENT_IMAGE = "Component.gif";
	public static final String ASSEMBLYCONNECTOR_IMAGE = "Connector_assembly.gif";
	public static final String DELEGATIONCONNECTOR_IMAGE = "Connector_delegation.gif";
	public static final String CONNECTOR_IMAGE = "Connector.gif";
	public static final String PORT_IMAGE = "Port.gif";
	public static final String USESINTERFACE_IMAGE = "required_interface.gif";
	public static final String IMPLEMENTSINTERFACE_IMAGE = "interface_provider.gif";
	public static final String COMPONENTINTERFACE_IMAGE = "Component_Interface.gif";

	// For UML StateMachine Diagram
	public static final String STATEDIAGRAM_IMAGE = "DiagramStateMachineDiagram.gif";
	public static final String STATE_IMAGE = "State.gif";
	public static final String STATEMACHINE_IMAGE = "StateMachine.gif";
	public static final String COMPLEXSTATE_IMAGE = "Complex_State.gif";
	public static final String TRANSION_IMAGE = "Transition.gif";
	public static final String FINALSTATE_IMAGE = "FinalState.gif";
	public static final String REGION_IMAGE = "Region.gif";
	public static final String PSEUDOSTATE_IMAGE = "Pseudostate.gif";
	public static final String INITIALPSEUDOSTATE_IMAGE = "Pseudostate_initial.gif";
	public static final String DEEPHISTORYPSEUDOSTATE_IMAGE = "Pseudostate_deepHistory.gif";
	public static final String SHALLOWHISTORYPSEUDOSTATE_IMAGE = "Pseudostate_shallowHistory.gif";
	public static final String JOINPSEUDOSTATE_IMAGE = "Pseudostate_join.gif";
	public static final String FORKPSEUDOSTATE_IMAGE = "Pseudostate_fork.gif";
	public static final String JUNCTIONPSEUDOSTATE_IMAGE = "Pseudostate_junction.gif";
	public static final String CHOICEPSEUDOSTATE_IMAGE = "Pseudostate_choice.gif";
	public static final String ENTRYPOINTPSEUDOSTATE_IMAGE = "Pseudostate_entryPoint.gif";
	public static final String EXITPOINTPSEUDOSTATE_IMAGE = "Pseudostate_exitPoint.gif";
	public static final String TERNIMATEPSEUDOSTATE_IMAGE = "Pseudostate_terminate.gif";

	// For UML Deployment Diagram
	public static final String DEPLOYMENTDIAGRAM_IMAGE = "Diagram_DeploymentDiagram.gif";
	public static final String ARTIFACT_IMAGE = "Artifact.gif";
	public static final String NODE_IMAGE = "Node.gif";
	public static final String DEVICE_IMAGE = "Device.gif";
	public static final String EXECUTIONENVIRONMENT_IMAGE = "ExecutionEnvironment.gif";
	public static final String DEPLOYMENTSPECIFICATION_IMAGE = "DeploymentSpecification.gif";
	public static final String DEPLOYMENT_IMAGE = "Deployment.gif";
	public static final String MANIFESTATION_IMAGE = "Manifestation.gif";
	public static final String COMMUNICATIONPATH_IMAGE = "CommunicationPath.gif";

	// For UML Package Diagram
	public static final String PACKAGEDIAGRAM_IMAGE = "Diagram_Package.gif";

	// For UML CompositeStructure Diagram
	public static final String COMPOSITESTRUCTUREDIAGRAM_IMAGE = "Diagram_CompositeStructureDiagram.gif";
	public static final String STRUCTUREDCLASS_IMAGE = "StructuredClass.gif";

	// For UML InteractionOverview Diagram
	public static final String INTERACTIONOVERVIEWDIAGRAM_IMAGE = "Diagram_InteractionOverview.gif";

	// For UML Timing Diagram
	public static final String TIMINGDIAGRAM_IMAGE = "Diagram_Timing.gif";

	// For UML Communication Diagram
	public static final String COMMUNICATIONDIAGRAM_IMAGE = "Diagram_Communication.gif";

	// *******************************************************************************************************************************

	// This is the HashMap used to manage the images;
	private static final Map<String, Image> stringToImage = new HashMap<String, Image>();
	// This is the HashMap used to manage the imagesDescriptor;
	private static final Map<String, ImageDescriptor> stringToImageDescriptor = new HashMap<String, ImageDescriptor>();

	/**
	 * This is the interface provided for users to get a image
	 * 
	 * @param key
	 * @return
	 */
	public static Image getImage(String key) {
		// First, try to get the image by searching the HashMap;
		Image img = (Image) stringToImage.get(key);

		// When the image has not been cached into the HashMap but is wanted,
		// cache it;
		if (img == null) {
			img = getImageDescriptor(key).createImage();
			stringToImage.put(key, img);
		}
		return img;
	}

	/**
	 * This is the interface provided for users to get a imageDescriptor
	 * 
	 * @param key
	 * @return
	 */
	public static ImageDescriptor getImageDescriptor(String key) {
		// First, try to get the imageDescriptor by searching the HashMap;
		ImageDescriptor imgDescriptor = (ImageDescriptor) stringToImageDescriptor
				.get(key);

		// When the imageDescriptor has not been cached into the HashMap but is
		// wanted, cache it;
		if (imgDescriptor == null) {
			imgDescriptor = ImageDescriptor.createFromFile(
					GMPImageProvider.class, key);
			stringToImageDescriptor.put(key, imgDescriptor);
		}
		return imgDescriptor;
	}

}
