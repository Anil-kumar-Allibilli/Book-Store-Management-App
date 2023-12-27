package com.sprint.bspro.entity;

import javax.persistence.Embeddable;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Embeddable
public class ContactInfo {

	private String houseAddress; // like ABC-123
	private String city;
	private String country;
	@NotNull
	@Email
	private String email;
	private long phone;
	/**
	 * @return the houseAddress
	 */
	public String getHouseAddress() {
		return houseAddress;
	}
	/**
	 * @param houseAddress the houseAddress to set
	 */
	public void setHouseAddress(String houseAddress) {
		this.houseAddress = houseAddress;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the phone
	 */
	public long getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public ContactInfo(String houseAddress, String city, String country, String email, long phone) {
		super();
		this.houseAddress = houseAddress;
		this.city = city;
		this.country = country;
		this.email = email;
		this.phone = phone;
	}
	public ContactInfo() {
		super();
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
}
