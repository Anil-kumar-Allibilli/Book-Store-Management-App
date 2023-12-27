package com.sprint.bspro.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;

import io.swagger.annotations.ApiModel;
@ApiModel(description = "Details about Admin Bean")
@Entity
public class Admin extends BookStoreUser {
	
	private String fullName;
	
	@Embedded
	private ContactInfo contactInfo;
	
	/**
     * Retrieves the full name associated with this entity.
     *
     * @return The full name of the entity.
     */
	
	public String getFullName() {
		return fullName;
	}
	/**
     * Sets the full name for this entity.
     *
     * @param fullName The full name to be set for the entity.
     */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	/**
     * Retrieves the contact information associated with this entity.
     *
     * @return The contact information of the entity. It may be null if no contact information is set.
     */
	public ContactInfo getContactInfo() {
		return contactInfo;
	}
	/**
     * Sets the contact information for this entity.
     *
     * @param contactInfo The {@code ContactInfo} object to be set for the entity. It can be {@code null}.
     */

	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}

	public Admin(String fullName, ContactInfo contactInfo) {
		super();
		this.fullName = fullName;
		this.contactInfo = contactInfo;
	}

	public Admin() {
		super();
	}

	public Admin(String username, String password, String userrole) {
		super( username, password, userrole);
	}
	
	public Admin(String username, String password, String userrole, String fullName, ContactInfo contactInfo) {
		super( username, password, userrole);
		this.fullName = fullName;
		this.contactInfo = contactInfo;
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
