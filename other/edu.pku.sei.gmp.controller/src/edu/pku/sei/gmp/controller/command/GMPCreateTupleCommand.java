package edu.pku.sei.gmp.controller.command;

import org.eclipse.gef.commands.Command;

import edu.pku.sei.gmp.model.common.GMPModel;
import edu.pku.sei.gmp.model.tuple.GMPTupleElement;

public class GMPCreateTupleCommand extends Command {
	
	private GMPTupleElement tuple = null;
	
	
	public GMPCreateTupleCommand(GMPTupleElement tuple) {
		super("Create Element");
		this.tuple = tuple;
	}
	
	public boolean canExecute(){
		return tuple != null;
	}
	
	public void execute() {
		GMPModel model = tuple.getModel();
		model.addTuple(tuple);
	}
	
	public void undo() {
		GMPModel model = tuple.getModel();
		model.removeTuple(tuple.getShapeElement());
	}
	
	public void redo() {
		this.execute();
	}
	
	public void setTuple(GMPTupleElement tuple){
		this.tuple = tuple;
	}
}
