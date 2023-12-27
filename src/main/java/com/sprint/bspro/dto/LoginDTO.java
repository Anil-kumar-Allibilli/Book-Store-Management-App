package com.sprint.bspro.dto;

public class LoginDTO {
	private String username;
	private String password;
	private String role;
	private String email;
	private String token;
	private boolean isValid;
	private boolean isUsername;
	
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
	 * Retrieves the role associated with this object.
	 *
	 * @return The role as a String.
	 */
	public String getRole() {
		return role;
	}
	/**
	 * Sets the role associated with this object.
	 *
	 * @param role The new role to set.
	 */
	public void setRole(String role) {
		this.role = role;
	}
	/**
	 * This method is used to get the username status.
	 *
	 * @return boolean - returns 'true' if the username exists, 'false' otherwise.
	 */
	public boolean getIsUsername() {
		return isUsername;
	}
	/**
	 * This method is used to set the username status.
	 *
	 * @param isUsername - returns 'true' if the username exists, 'false' otherwise.
	 */
	
	public void setIsUsername(boolean isUsername) {
		this.isUsername = isUsername;
	}
	/**
 	 * Retrieves the email associated with this object.
 	 *
 	 * @return The email as a String.
 	 */
	public String getEmail() {
		return email;
	}
	/**
	 * Sets the email associated with this object.
	 *
	 * @param email The new email to set.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public boolean isValid() {
		return isValid;
	}
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	
	public LoginDTO(String username, String password, String role) {
		super();
		this.username = username;
		this.password = password;
		this.role=role;
	}
	public LoginDTO(String username, String password, String role, boolean isUsername) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
		this.isUsername = isUsername;
	}
	public LoginDTO() {
		super();
	}
	
}
