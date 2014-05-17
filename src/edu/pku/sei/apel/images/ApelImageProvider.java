package edu.pku.sei.apel.images;

import java.util.Hashtable;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

public class ApelImageProvider {

	static private Hashtable<String, Image> imagesTable = new Hashtable<String, Image>();

	public static final String IMPORTWSDL = "importWsdl.gif";

	public static final String EXPORTBPEL = "exportBpel.gif";

	public static final String DESCRIPTION = "description.gif";

	public static final String PROVIDE = "provide.gif";

	public static final String REQUIRE = "require.gif";

	public static final String AGENT = "agent.png";

	public static final String AGENT_LARGE = "agentLarge.png";

	public static final String CONTACT = "contact.png";

	public static final String CONTACT_LARGE = "contactLarge.png";

	public static final String COLLAPSED = "collapsed.gif";

	// sla

	public static final String COMPUTESEVICE = "agent.png";
	public static final String SLAAGREEMENT = "agent.png";

	// bpel
	public static final String BPEL = "bpel.png";

	public static final String BPEL_LARGE = "bpelLarge.png";

	// Process
	public static final String PROCESS = "process.png";

	// Assign
	public static final String ASSIGN = "assign.png";
	public static final String ASSIGN_LARGE = "assignLarge.png";

	// Catch
	public static final String CATCH = "catch.png";
	public static final String CATCH_LARGE = "catchLarge.png";
	public static final String CATCH_ICON = "catchIcon.gif";

	// CatchAll
	public static final String CATCHALL = "catchAll.png";
	public static final String CATCHALL_LARGE = "catchAllLarge.png";
	public static final String CATCHALL_ICON = "catchAllIcon.gif";

	// Compensate
	public static final String COMPENSATE = "compensate.png";
	public static final String COMPENSATE_LARGE = "compensateLarge.png";

	// CompensateScope
	public static final String COMPENSATESCOPE = "compensateScope.png";
	public static final String COMPENSATESCOPE_LARGE = "compensateScopeLarge.png";

	// CompensationHandler
	public static final String COMPENSATIONHANDLER = "compensationHandler.png";
	public static final String COMPENSATIONHANDLER_ICON = "compensationHandlerIcon.gif";

	// Copy
	public static final String COPY = "copy.png";
	public static final String COPY_ICON = "copyIcon.gif";

	// CorrelationSet
	public static final String CORRELATIONSET = "correlationset.png";

	// CustomActivity
	public static final String CUSTOMACTIVITY = "customActivity.png";
	public static final String CUSTOMACTIVITY_LARGE = "customActivityLarge.png";

	// Else
	public static final String ELSE = "else.png";
	public static final String ELSE_LARGE = "elseLarge.png";
	public static final String ELSE_ICON = "elseIcon.gif";

	// Empty
	public static final String EMPTY = "empty.png";
	public static final String EMPTY_LARGE = "emptyLarge.png";

	// EventHandler
	public static final String EVENTHANDLER = "eventHandler.png";
	public static final String EVENTHANDLERS = "eventHandlers.gif";

	// Exit
	public static final String EXIT = "exit.png";
	public static final String EXIT_LARGE = "exitLarge.png";

	// Expression
	public static final String EXPRESSION = "expression.png";

	// Extension
	public static final String EXTENSION = "extension.png";

	// FaultHandler
	public static final String FAULTHANDLER = "faultHandler.png";
	public static final String FAULTHANDLERSICON = "faultHandlersIcon.gif";

	// Flow
	public static final String FLOW = "flow.png";
	public static final String FLOW_LARGE = "flowLarge.png";

	// ForEach
	public static final String FOREACH = "forEach.png";
	public static final String FOREACH_LARGE = "forEachLarge.png";

	// FromPart
	public static final String FROMPART = "fromPart.png";

	// If
	public static final String IF = "if.png";
	public static final String IF_LARGE = "ifLarge.png";

	// Import
	public static final String IMPORT = "import.png";

	// IfCondition
	public static final String ELSEIF = "elseIf.png";
	public static final String ELSEIF_LARGE = "elseIfLarge.png";
	public static final String ELSEIF_ICON = "elseIfIcon.gif";

	// Variable
	public static final String VARIABLE = "variable.png";

	// Invoke
	public static final String INVOKE = "invoke.png";
	public static final String INVOKE_LARGE = "invokeLarge.png";

	// Link
	public static final String LINK = "link.png";

	// OnAlarm
	public static final String ONALARM = "onAlarm.png";
	public static final String ONALARM_LARGE = "onAlarmLarge.png";
	public static final String ONALARM_ICON = "onAlarmLargeIcon.gif";

	// OnEvent
	public static final String ONEVENT = "onEvent.png";
	public static final String ONEVENT_LARGE = "onEventLarge.png";

	// OnMessage
	public static final String ONMESSAGE = "onMessage.png";
	public static final String ONMESSAGE_LARGE = "onMessageLarge.png";
	public static final String ONMESSAGE_ICON = "onMessageIcon.gif";

	// PartnerLink
	public static final String PARTNERLINK = "partnerLink.png";

	// Pick
	public static final String PICK = "pick.png";
	public static final String PICK_LARGE = "pickLarge.png";

	// Receive
	public static final String RECEIVE = "receive.png";
	public static final String RECEIVE_LARGE = "receiveLarge.png";

	// RepeatUntil
	public static final String REPEATUNTIL = "repeatUntil.png";
	public static final String REPEATUNTIL_LARGE = "repeatUntilLarge.png";

	// Reply
	public static final String REPLY = "reply.png";
	public static final String REPLY_LARGE = "replyLarge.png";

	// Rethrow
	public static final String RETHROW = "rethrow.png";
	public static final String RETHROW_LARGE = "rethrowLarge.png";

	// Scope
	public static final String SCOPE = "scope.png";
	public static final String SCOPE_Large = "scopeLarge.png";

	// Sequence
	public static final String SEQUENCE = "sequence.png";
	public static final String SEQUENCE_LARGE = "sequenceLarge.png";

	// TerminationHandler
	public static final String TERMINATIONHANDLER = "terminationHandler.png";

	// Throw
	public static final String THROW = "throw.png";
	public static final String THROW_LARGE = "throwLarge.png";

	// ToPart
	public static final String TOPART = "toPart.png";

	// Validate
	public static final String VALIDATE = "validate.png";
	public static final String VALIDATE_LARGE = "validateLarge.png";

	// Wait
	public static final String WAIT = "wait.png";
	public static final String WAIT_LARGE = "waitLarge.png";

	// While
	public static final String WHILE = "while.png";
	public static final String WHILE_LARGE = "whileLarge.png";

	

	public static ImageDescriptor getImageDescriptor(String key) {
		return ImageDescriptor.createFromFile(ApelImageProvider.class, key);
	}

	public static Image getImage(final String imageName) {
		Image img = imagesTable.get(imageName);
		if (img != null) {
			return img;
		} else {
			ImageDescriptor imageDescriptor = ApelImageProvider
					.getImageDescriptor(imageName);
			img = imageDescriptor.createImage();
			imagesTable.put(imageName, img);
			return img;
		}
	}

}
