package com.sprint.bspro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class BookStoreUser {

	@ApiModelProperty(notes = "Unique UserId for all User")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userCode;
	@NotNull
	@Column(unique = true)
	private String username;
	@NotNull
	private String password;
	private String userrole;
	
	public BookStoreUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BookStoreUser(String username, String password, String userrole) {
		super();
		this.username = username;
		this.password = password;
		this.userrole = userrole;
	}
	
	/**
	 * @return the userCode
	 */
	public int getUserCode() {
		return userCode;
	}
	/**
	 * @param userCode the userCode to set
	 */
	public void setUserCode(int userCode) {
		this.userCode = userCode;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the userrole
	 */
	public String getUserrole() {
		return userrole;
	}
	/**
	 * @param userrole the userrole to set
	 */
	public void setUserrole(String userrole) {
		this.userrole = userrole;
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
