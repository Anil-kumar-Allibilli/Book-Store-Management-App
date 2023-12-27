package com.sprint.bspro.exceptions;

public class InvalidUserNameException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;
	private String srcName;

	public InvalidUserNameException() {
		super();
	}
	public InvalidUserNameException(String message, String srcName) {
		this.message=message;
		this.srcName=srcName;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the srcName
	 */
	public String getSrcName() {
		return srcName;
	}
	/**
	 * @param srcName the srcName to set
	 */
	public void setSrcName(String srcName) {
		this.srcName = srcName;
	}
}
