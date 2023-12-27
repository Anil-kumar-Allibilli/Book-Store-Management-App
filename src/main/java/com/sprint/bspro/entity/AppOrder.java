package com.sprint.bspro.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;

import io.swagger.annotations.Api;

@Api(value = "All AppOrder Specific AppOrder Endpoints")
@Entity
public class AppOrder {

	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private int orderNumber;
	private String orderDate;
	private int orderValue;
	private String orderStatus;
	
//	@ManyToMany
//	@JoinTable(name = "OrderDetails", 
//	joinColumns = @JoinColumn(name = "orderNumber"), 
//	inverseJoinColumns = @JoinColumn(name = "book"))
//	private List<Book> orderedBooks;
	@ElementCollection
	 @CollectionTable(name = "order_item_mapping", 
    joinColumns = {@JoinColumn(name="OrderNumber",referencedColumnName = "orderNumber")})
	@MapKeyColumn(name = "BookNumber")
  @Column(name = "Units")
	Map<Book, Integer> orderDetails = new HashMap<>();
	
	@ManyToOne
	private AppCustomer customer;
	
	/**
     * Retrieves the order number associated with this order.
     *
     * @return The order number.
     */

	public int getOrderNumber() {
		return orderNumber;
	}

	/**
     * Sets the order number for this order.
     *
     * @param orderNumber The order number to be set.
     */
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	
	/**
     * Retrieves the order date associated with this order.
     *
     * @return The order date.
     */
	public String getOrderDate() {
		return orderDate;
	}

	/**
     * Sets the order date for this order.
     *
     * @param orderDate The order date to be set.
     */
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	 /**
     * Retrieves the order value associated with this order.
     *
     * @return The order value.
     */
	public int getOrderValue() {
		return orderValue;
	}

	 /**
     * Sets the order value for this order.
     *
     * @param orderValue The order value to be set.
     */
	public void setOrderValue(int orderValue) {
		this.orderValue = orderValue;
	}

	/**
     * Retrieves the order status associated with this order.
     *
     * @return The order status.
     */
	public String getOrderStatus() {
		return orderStatus;
	}
	/**
     * Sets the order status for this order.
     *
     * @param orderStatus The order status to be set.
     */
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	/**
     * Retrieves the customer associated with this order.
     *
     * @return The AppCustomer object representing the customer.
     */
	public AppCustomer getCustomer() {
		return customer;
	}
	 /**
     * Sets the customer for this order.
     *
     * @param customer The AppCustomer object to be set.
     */

	public void setCustomer(AppCustomer customer) {
		this.customer = customer;
	}
	/**
     * Retrieves the order details associated with this order.
     *
     * @return A Map containing the order details where keys Book objects and values are quantities.
     */
	public Map<Book, Integer> getOrderDetails() {
		return orderDetails;
	}
	/**
     * Sets the order details for this order.
     *
     * @param orderDetails A Map containing the order details where keys are Book objects and values are quantities.
     */
	public void setOrderDetails(Map<Book, Integer> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public AppOrder(String orderDate, int orderValue, String orderStatus, Map<Book, Integer> orderDetails,
			AppCustomer customer) {
		super();
		this.orderDate = orderDate;
		this.orderValue = orderValue;
		this.orderStatus = orderStatus;
		this.orderDetails = orderDetails;
		this.customer = customer;
	}

	public AppOrder(int orderNumber, String orderDate, int orderValue, String orderStatus) {
		super();
		this.orderNumber = orderNumber;
		this.orderDate = orderDate;
		this.orderValue = orderValue;
		this.orderStatus = orderStatus;
	}

	public AppOrder() {
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
