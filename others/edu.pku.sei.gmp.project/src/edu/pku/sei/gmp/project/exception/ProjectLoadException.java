package edu.pku.sei.gmp.project.exception;

public class ProjectLoadException extends Exception {
	private static final long serialVersionUID = -2761793789060412066L;

	public ProjectLoadException() {
		super();
	}
	
	public ProjectLoadException(String msg) {
		super(msg);
	}
	
	public ProjectLoadException(Throwable t) {
		super(t);
	}
	
	public ProjectLoadException(String msg, Throwable t) {
		super(msg, t);
	}
	
}
