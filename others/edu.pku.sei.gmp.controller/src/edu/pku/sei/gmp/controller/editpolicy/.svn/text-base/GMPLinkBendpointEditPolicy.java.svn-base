package edu.pku.sei.gmp.controller.editpolicy;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.BendpointEditPolicy;
import org.eclipse.gef.requests.BendpointRequest;

import edu.pku.sei.gmp.controller.command.GMPAddBendpointCommand;
import edu.pku.sei.gmp.controller.command.GMPDeleteBendpointCommand;
import edu.pku.sei.gmp.controller.command.GMPMoveBendpointCommand;
import edu.pku.sei.gmp.model.common.GMPConst;
import edu.pku.sei.gmp.model.common.GMPModel;
import edu.pku.sei.gmp.model.common.GMPModelFactory;
import edu.pku.sei.gmp.model.shape.GMPBendpoint;
import edu.pku.sei.gmp.model.shape.GMPLink;

public class GMPLinkBendpointEditPolicy extends BendpointEditPolicy {

	@Override
	protected Command getCreateBendpointCommand(BendpointRequest request) {
		Point loc = request.getLocation();
		getConnection().translateToRelative(loc);
		GMPLink link = (GMPLink) request.getSource().getModel();
		GMPModel model = link.getModel();
		GMPModelFactory factory = model.getModelFactory();
		GMPBendpoint bendpoint = (GMPBendpoint) factory
				.createShapeElement(GMPConst.__BENDPOINT__);
		bendpoint.x = loc.x;
		bendpoint.y = loc.y;
		return new GMPAddBendpointCommand(link, bendpoint, request.getIndex());
	}

	@Override
	protected Command getDeleteBendpointCommand(BendpointRequest request) {
		return new GMPDeleteBendpointCommand((GMPLink) getHost().getModel(), request.getIndex());
	}

	@Override
	protected Command getMoveBendpointCommand(BendpointRequest request) {
		Point loc = request.getLocation();
		getConnection().translateToRelative(loc);
		return new GMPMoveBendpointCommand((GMPLink)request.getSource().getModel(),
				loc, request.getIndex());
	}

}
