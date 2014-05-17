package edu.pku.sei.gmp.common.cmdstack;

import java.util.HashMap;

import org.eclipse.gef.commands.CommandStack;


public class GMPCommandStack {
	private static CommandStack commandStack = new CommandStack();

	private static HashMap<Object, CommandStack> commandStackMap = 
		new HashMap<Object, CommandStack>();

	/**
	 * Get a global command stack.
	 * 
	 * @return
	 */
	public static CommandStack getCommandStack() {
		return commandStack;
	}

	/**
	 * Get a command stack associated with a key.
	 * 
	 * @param key
	 * @return
	 */
	public static CommandStack getCommandStack(Object key) {
		CommandStack cs = commandStackMap.get(key);
		if (cs == null) {
			cs = new CommandStack();
			commandStackMap.put(key, cs);
		}
		return cs;
	}
}
