package edu.pku.sei.gmp.properties.command;

import java.util.List;

import org.eclipse.gef.commands.Command;

public class GMPCreateListItemCommand extends Command {
	private List<Object> list;
	private Object obj;
	
	public GMPCreateListItemCommand(List<Object> list, Object obj) {
		this.list = list;
		this.obj = obj;
	}
	
	public boolean canExecute() {
		return list != null && obj != null;
	}
	
	public void execute() {
		list.add(obj);
	}
	
	public void undo() {
		list.remove(obj);
	}
}
