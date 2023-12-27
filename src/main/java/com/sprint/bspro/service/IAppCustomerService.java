package com.sprint.bspro.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sprint.bspro.entity.AppCustomer;
@Service
public interface IAppCustomerService {
	public AppCustomer createAppCustomer(AppCustomer customer);
	public List<AppCustomer> listCustomers();
	public AppCustomer deleteCustomer(int customerId);
	public AppCustomer updateCustomer(AppCustomer c);
	public AppCustomer updateCustomerByUsername(AppCustomer c, String username);
	public AppCustomer viewCustomer(int userCode);
	public AppCustomer viewCustomerByUserName(String username);
}
