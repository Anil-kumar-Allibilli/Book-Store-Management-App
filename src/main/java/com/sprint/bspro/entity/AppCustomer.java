package com.sprint.bspro.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import io.swagger.annotations.Api;

@Api(value = "All AppCustomer Specific AppCustomer Endpoints")
@Entity
public class AppCustomer extends BookStoreUser{

	private String fullName;
	
	@Embedded
	private ContactInfo contactInfo;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<AppOrder> allPlacedOrders;

	public AppCustomer() {
		super();
	}

	public AppCustomer( String username, String password, String userrole) {
		super( username, password, userrole);
	}
	
	public AppCustomer(String fullName, ContactInfo contactInfo, List<AppOrder> allPlacedOrders) {
		super();
		this.fullName = fullName;
		this.contactInfo = contactInfo;
		this.allPlacedOrders = allPlacedOrders;
	}
	
	public AppCustomer( String username, String password, String userrole, String fullName, ContactInfo contactInfo) {
		super( username, password, userrole);
		this.fullName = fullName;
		this.contactInfo = contactInfo;
	}
/**
 * 
 * @return the fullName
 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * @return the contactInfo
	 */
	public ContactInfo getContactInfo() {
		return contactInfo;
	}

	/**
	 * @param contactInfo the contactInfo to set
	 */
	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}

	/**
	 * @return the allPlacedOrders
	 */
	public List<AppOrder> getAllPlacedOrders() {
		return allPlacedOrders;
	}

	/**
	 * @param allPlacedOrders the allPlacedOrders to set
	 */
	public void setAllPlacedOrders(List<AppOrder> allPlacedOrders) {
		this.allPlacedOrders = allPlacedOrders;
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
