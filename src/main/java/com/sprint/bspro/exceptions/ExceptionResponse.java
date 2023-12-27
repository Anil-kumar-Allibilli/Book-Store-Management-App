package com.sprint.bspro.exceptions;

import org.springframework.stereotype.Component;

@Component
public class ExceptionResponse {
	private String error;
	private String source;
	
	public ExceptionResponse() {
		super();
	}
	public ExceptionResponse(String error, String source) {
		super();
		this.error = error;
		this.source = source;
	}
	/**
     * Retrieves the error message.
     *
     * @return The error message.
     */
	
	public String getError() {
		return error;
	}
	/**
     * Sets the error message.
     *
     * @param error The error message to be set.
     */
	public void setError(String error) {
		this.error = error;
	}
	/**
     * Retrieves the source of the error.
     *
     * @return The source of the error.
     */
	public String getSource() {
		return source;
	}
	/**
     * Sets the source of the error.
     *
     * @param source The source of the error to be set.
     */
	public void setSource(String source) {
		this.source = source;
	}
}
