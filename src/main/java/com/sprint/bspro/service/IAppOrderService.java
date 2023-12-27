package com.sprint.bspro.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sprint.bspro.entity.AppOrder;
@Service
public interface IAppOrderService {
	public AppOrder cancelOrder(int od);
	public AppOrder addOrder(AppOrder od);
	public AppOrder viewOrderById(int oid);
	public AppOrder updateOrderStatus(String status, int oid);
	public List<AppOrder> viewAllOrders();
	public List<AppOrder> viewOrdersByCustomer(String username);
}
