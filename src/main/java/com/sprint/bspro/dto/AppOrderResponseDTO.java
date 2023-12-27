package com.sprint.bspro.dto;

import java.util.List;


public class AppOrderResponseDTO {
	private int orderValue;
	private List<CartDTO> orderDetails;
	private int orderNumber;
	private String orderDate;
	private String customerName;
	private String orderStatus;
	/**
	 * @return the orderValue
	 */
	public int getOrderValue() {
		return orderValue;
	}
	/**
	 * @param orderValue the orderValue to set
	 */
	public void setOrderValue(int orderValue) {
		this.orderValue = orderValue;
	}
	/**
	 * @return the orderDetails
	 */
	public List<CartDTO> getOrderDetails() {
		return orderDetails;
	}
	/**
	 * @param orderDetails the orderDetails to set
	 */
	public void setOrderDetails(List<CartDTO> orderDetails) {
		this.orderDetails = orderDetails;
	}
	/**
	 * @return the orderNumber
	 */
	public int getOrderNumber() {
		return orderNumber;
	}
	/**
	 * @param orderNumber the orderNumber to set
	 */
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	/**
	 * @return the orderDate
	 */
	public String getOrderDate() {
		return orderDate;
	}
	/**
	 * @param orderDate the orderDate to set
	 */
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	/**
	 * @return the orderStatus
	 */
	public String getOrderStatus() {
		return orderStatus;
	}
	/**
	 * @param orderStatus the orderStatus to set
	 */
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}
	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
}
