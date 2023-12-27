package com.sprint.bspro.dto;

import javax.validation.constraints.Email;

public class AuthorRequestDTO {
	private int userCode;
	private String password;
	private String username;
	private String userrole; 
	private String name; 
	private String houseAddress;
	private String city;
	private String country;
	@Email
	private String email;
	private long phone;
	private String region;
	private String nativeLanguage;
	private String status = "pending";
	
	
	/**
	 * Retrieves the userCode associated with this object.
	 *
	 * @return The userCode as a integer.
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
	 * @param username The new username to set.
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
	 * Retrieves the name associated with this object.
	 *
	 * @return The name as a String.
	 */
	public String getName() {
		return name;
	}
	/**
	 * Sets the name associated with this object.
	 *
	 * @param name The new name to set.
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @param city The new city to set.
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
	/**
 	 * Retrieves the region associated with this object.
 	 *
 	 * @return The region as a String.
 	 */
	public String getRegion() {
		return region;
	}
	/**
	 * Sets the region associated with this object.
	 *
	 * @param region The new region to set.
	 */
	public void setRegion(String region) {
		this.region = region;
	}
	/**
 	 * Retrieves the nativeLanguage associated with this object.
 	 *
 	 * @return The nativeLanguage as a String.
 	 */
	public String getNativeLanguage() {
		return nativeLanguage;
	}
	/**
	 * Sets the nativeLanguage associated with this object.
	 *
	 * @param nativeLanguage The new region to set.
	 */
	public void setNativeLanguage(String nativeLanguage) {
		this.nativeLanguage = nativeLanguage;
	}
	/**
 	 * Retrieves the status associated with this object.
 	 *
 	 * @return The status as a String.
 	 */
	
	public String getStatus() {
		return status;
	}
	public AuthorRequestDTO(int userCode, String password, String username, String userrole, String name,
			String houseAddress, String city, String country, String email, long phone, String region,
			String nativeLanguage) {
		super();
		this.userCode = userCode;
		this.password = password;
		this.username = username;
		this.userrole = userrole;
		this.name = name;
		this.houseAddress = houseAddress;
		this.city = city;
		this.country = country;
		this.email = email;
		this.phone = phone;
		this.region = region;
		this.nativeLanguage = nativeLanguage;
	}
	public AuthorRequestDTO() {
		super();
	}
}
