package com.sprint.bspro.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint.bspro.entity.AppCustomer;
import com.sprint.bspro.entity.AppOrder;
@Repository
public interface IAppOrderRepository extends JpaRepository<AppOrder, Integer> {
	
	/** Retrieves a list of orders associated with the provided customer.
	 * 
	 * @param customer The AppCustomer object for which to retrieve associated orders.
	 * @return A List of AppOrder entities associated with the provided customer,
         or an empty list if no matching orders are found.
	 */
	public List<AppOrder> getAppOrderByCustomer(AppCustomer customer);
}
