package com.sprint.bspro.dto;

public class ResetPasswordDTO {
	private String username;
	private String password;
	private String otp;
	
	
	/**
	 * Retrieves the username associated with this object.
	 *
	 * @return The username as a String.
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * Sets the username associated with this object.
	 *
	 * @param username The new username to set.
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * Retrieves the password associated with this object.
	 *
	 * @return The password as a String.
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * Sets the password associated with this object.
	 *
	 * @param password The new password to set.
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * Retrieves the otp associated with this object.
	 *
	 * @return The otp as a String.
	 */
	public String getOtp() {
		return otp;
	}
	/**
	 * Sets the otp associated with this object.
	 *
	 * @param otp The new otp to set.
	 */
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public ResetPasswordDTO(String username, String password, String otp) {
		super();
		this.username = username;
		this.password = password;
		this.otp = otp;
	}
	public ResetPasswordDTO() {
		super();
	}
}
