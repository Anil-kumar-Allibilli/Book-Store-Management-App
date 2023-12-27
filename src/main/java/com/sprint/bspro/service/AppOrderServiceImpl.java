package com.sprint.bspro.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.bspro.entity.AppCustomer;
import com.sprint.bspro.entity.AppOrder;
import com.sprint.bspro.entity.Book;
import com.sprint.bspro.repository.IAppCustomerRepository;
import com.sprint.bspro.repository.IAppOrderRepository;
import com.sprint.bspro.repository.IBookRepository;
@Service
public class AppOrderServiceImpl implements IAppOrderService {
	@Autowired
	IAppOrderRepository orderRepository;
	@Autowired
	IAppCustomerRepository customerRepository;
	@Autowired
	IBookRepository bookRepository;
	
	/** Cancels an application order based on the provided order ID.
	 * 
	 * @param oid The order ID of the order to be cancelled.
	 * @return The AppOrder entity with the updated status after cancellation,
        or null if the provided order ID is 0 or no matching order is found.
     */	
	@Override
	@Transactional
	public AppOrder cancelOrder(int oid) {
		if(oid != 0) {
			AppOrder order = orderRepository.findById(oid).get();
			if(order.getOrderStatus().equals("placed successfully")) {
				order.setOrderStatus("cancelled");
			}
			for(Map.Entry<Book, Integer> e: order.getOrderDetails().entrySet()) {
				e.getKey().setAvailableQuantity(e.getKey().getAvailableQuantity()+e.getValue());  
			}
			return order;
		}
		return null;
	}
	/** Adds an application order to the system.
	 * 
	 * @param order The AppOrder entity representing the order to be added.
	 * @return The saved AppOrder entity if the order is successfully placed; otherwise, null.
	 */

	@Override
	@Transactional
	public AppOrder addOrder(AppOrder order) {
		Map<Book,Integer> orderDetail = new HashMap<>();
		
		for(Map.Entry<Book, Integer> e : order.getOrderDetails().entrySet()) {
			String name = e.getKey().getTitle();//
			System.out.println("title--------------------"+name);
			Book book = bookRepository.getBookByTitle(name);
			orderDetail.put(book, e.getValue());
		}
		String user = order.getCustomer().getUsername();//
		AppCustomer customer = customerRepository.getAppCustomerByUsername(user);
		order.setOrderDetails(orderDetail);
		order.setCustomer(customer);
		boolean placeOrder = true;
		
		
		for(Map.Entry<Book, Integer> e: order.getOrderDetails().entrySet()) {
			if(e.getKey().getAvailableQuantity()<e.getValue()) {
				placeOrder = false;
				break;
			}
		}
		if(placeOrder) {
			System.out.println("inside if place order----------------------- ");
			for(Map.Entry<Book, Integer> e: order.getOrderDetails().entrySet()) {
				e.getKey().setAvailableQuantity(e.getKey().getAvailableQuantity()-e.getValue());  
			}
			List<AppOrder> ordersList = customer.getAllPlacedOrders();
			ordersList.add(order);
			
			AppOrder savedOrder = orderRepository.save(order);
			for(Map.Entry<Book, Integer> e: order.getOrderDetails().entrySet()) {
				List<AppOrder>bookOrders = e.getKey().getOrders();
				bookOrders.add(savedOrder);
				e.getKey().setOrders(bookOrders);
			}
			return savedOrder;
		}
		return null;
	}
/** Updates the status of an application order based on the provided order ID.
 * 
 * @param status The new status to be set for the order.
 * @param oid The order ID of the order to have its status updated.
 * @return The AppOrder entity with the updated status,
          or null if the provided order ID is 0, no matching order is found, or the provided status is null.
 */
	@Override
	@Transactional
	public AppOrder updateOrderStatus(String status, int oid) {
		if(oid != 0) {
			AppOrder order = orderRepository.findById(oid).get();
			order.setOrderStatus(status);
			return order;
		}
		return null;
	}
 /**Retrieves and views a list of all application orders from the data source.
 * 
 * @return A List of entities representing all orders in the data source, 
         or an empty list if there are no orders.
 */
	@Override
	public List<AppOrder> viewAllOrders() {
		return orderRepository.findAll();
	}
/** Retrieves and views a list of application orders associated with a specific customer from the data source.
 * 
 * @param username The username of the customer whose orders are to be viewed.
 * @return A List of AppOrder entities representing orders associated with the specified customer,
 *         or null if the provided username is null or no matching customer is found.
 */
	@Override
	public List<AppOrder> viewOrdersByCustomer(String username) {
		if(username != null) {
			AppCustomer customer = customerRepository.getAppCustomerByUsername(username);
			if(customer != null) {
				return orderRepository.getAppOrderByCustomer(customer);
			}
		}
		return null;
	}

	@Override
	public AppOrder viewOrderById(int oid) {
		if(oid != 0) {
			AppOrder order = orderRepository.findById(oid).get();
			return order;
		}
		return null;
	}

}
