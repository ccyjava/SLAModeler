package edu.pku.sei.gmp.controller.command;

import org.eclipse.gef.commands.Command;

import edu.pku.sei.gmp.model.common.GMPModel;
import edu.pku.sei.gmp.model.tuple.GMPTupleElement;

public class GMPDeleteTupleCommand extends Command {

	private GMPTupleElement tuple;

	public GMPDeleteTupleCommand(GMPTupleElement tuple) {
		super("Delete Element");
		this.tuple = tuple;
	}

	public boolean canExecute() {
		return tuple != null;
	}

	public void execute() {
		GMPModel model = tuple.getModel();
		if (model.getAllTuples().contains(tuple)) {
			model.removeTuple(tuple);
		}
	}

	public void undo() {
		GMPModel model = tuple.getModel();
		if (!model.getAllTuples().contains(tuple)) {
			model.addTuple(tuple);
		}
	}
}
