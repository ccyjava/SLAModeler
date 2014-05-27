package edu.pku.sei.gmp.project.exception;

public class ProjectSaveException extends Exception {

	private static final long serialVersionUID = 8211388591282802819L;

	public ProjectSaveException() {
		super();
	}
	
	public ProjectSaveException(String msg) {
		super(msg);
	}
	
	public ProjectSaveException(Throwable t) {
		super(t);
	}
	
	public ProjectSaveException(String msg, Throwable t) {
		super(msg, t);
	}
}
