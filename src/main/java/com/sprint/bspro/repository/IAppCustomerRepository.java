package com.sprint.bspro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint.bspro.entity.AppCustomer;
@Repository
public interface IAppCustomerRepository extends JpaRepository<AppCustomer, Integer> {
	
	/** Retrieves a customer from the database based on the provided username.
	 * 
	 * @param username The username of the customer to be retrieved.
	 * @return The AppCustomer entity associated with the provided username, or null if no matching customer is found.
	 */
	public AppCustomer getAppCustomerByUsername(String username);
}
