package com.sprint.bspro.dto;

import java.util.List;


public class AppOrderRequestDTO {
	private int orderValue;
	private List<CartDTO> orderDetails;
	private String username;
	
	
	/**
	 * Retrieves the order value associated with this object.
	 *
	 * @return The order value as an integer.
	 */
	public int getOrderValue() {
		return orderValue;
	}
	/**
	 * Sets the order value associated with this object.
	 *
	 * @param orderValue The new order value to set.
	 */
	
	public void setOrderValue(int orderValue) {
		this.orderValue = orderValue;
	}
	/**
	 * Retrieves the order details associated with this object.
	 *
	 * @return A list of CartDTO objects representing the order details.
	 */
	public List<CartDTO> getOrderDetails() {
		return orderDetails;
	}
	/**
	 * Sets the order details associated with this object.
	 *
	 * @param orderDetails A list of CartDTO objects representing the order details to set.
	 */
	
	public void setOrderDetails(List<CartDTO> orderDetails) {
		this.orderDetails = orderDetails;
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
	
}
