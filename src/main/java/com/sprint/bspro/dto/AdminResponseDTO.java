package com.sprint.bspro.dto;

public class AdminResponseDTO {
	private int userCode;
	private String password;
	private String username;
	private String userrole; 
	private String fullName; 
	private String houseAddress;
	private String city;
	private String country;
	private String email;
	private long phone;
	
	
	/**
	 * Retrieves the userCode associated with this object.
	 *
	 * @return The userCode as a int.
	 */
	public int getUserCode() {
		return userCode;
	}
	/**
	 * Sets the userCode associated with this object.
	 *
	 * @param userCode The new userCode to set.
	 */
	
	public void setUserCode(int userCode) {
		this.userCode = userCode;
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
	 * @param username The new password to set.
	 */

     public void setUsername(String username) {
		this.username = username;
	}
     /**
 	 * Retrieves the userrole associated with this object.
 	 *
 	 * @return The userrole as a String.
 	 */
     
	public String getUserrole() {
		return userrole;
	}
	/**
	 * Sets the userrole associated with this object.
	 *
	 * @param userrole The new userrole to set.
	 */
	
	public void setUserrole(String userrole) {
		this.userrole = userrole;
	}
	/**
 	 * Retrieves the fullName associated with this object.
 	 *
 	 * @return The fullName as a String.
 	 */
	public String getFullName() {
		return fullName;
	}
	/**
	 * Sets the fullName associated with this object.
	 *
	 * @param fullName The new fullName to set.
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	/**
 	 * Retrieves the houseAddress associated with this object.
 	 *
 	 * @return The houseAddress as a String.
 	 */
	public String getHouseAddress() {
		return houseAddress;
	}
	/**
	 * Sets the houseAddress associated with this object.
	 *
	 * @param houseAddress The new houseAddress to set.
	 */       
	public void setHouseAddress(String houseAddress) {
		this.houseAddress = houseAddress;
	}
	/**
 	 * Retrieves the city associated with this object.
 	 *
 	 * @return The city as a String.
 	 */
	public String getCity() {
		return city;
	}
	/**
	 * Sets the city associated with this object.
	 *
	 * @param city The new houseAddress to set.
	 */ 
	public void setCity(String city) {
		this.city = city;
	}
	/**
 	 * Retrieves the country associated with this object.
 	 *
 	 * @return The country as a String.
 	 */
	public String getCountry() {
		return country;
	}
	/**
	 * Sets the country associated with this object.
	 *
	 * @param country The new country to set.
	 */ 
	public void setCountry(String country) {
		this.country = country;
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
	/**
 	 * Retrieves the phone associated with this object.
 	 *
 	 * @return The phone as a long.
 	 */
	public long getPhone() {
		return phone;
	}
	/**
	 * Sets the phone associated with this object.
	 *
	 * @param phone The new phone to set.
	 */
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public AdminResponseDTO(int userCode, String password, String username, String userrole, String fullName,
			String houseAddress, String city, String country, String email, long phone) {
		super();
		this.userCode = userCode;
		this.password = password;
		this.username = username;
		this.userrole = userrole;
		this.fullName = fullName;
		this.houseAddress = houseAddress;
		this.city = city;
		this.country = country;
		this.email = email;
		this.phone = phone;
	}
	public AdminResponseDTO() {
		super();
	}
}
