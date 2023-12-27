package com.sprint.bspro.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.bspro.entity.AppCustomer;
import com.sprint.bspro.entity.ContactInfo;
import com.sprint.bspro.repository.IAppCustomerRepository;
@Service
public class AppCustomerServiceImpl implements IAppCustomerService {

	@Autowired
	IAppCustomerRepository customerRepository;
	
	/**Creates a new application customer and stores it in the data source.
	 * 
	 * @param customer The AppCustomer entity to be created and stored.
	 * @return The created entity with the user code set, or null if the provided customer is null.
	 */
	@Override
	public AppCustomer createAppCustomer(AppCustomer customer) {
		if(customer != null) {
			customerRepository.save(customer);
			customer.setUserCode(customerRepository.getAppCustomerByUsername(customer.getUsername()).getUserCode());
			return customer;
		}
		return null;
	}

	/** Retrieves a list of all application customers from the data source.
	 * 
	 * @return A List of AppCustomer entities representing all customers in the data source.
	 */
	@Override
	public List<AppCustomer> listCustomers() {
		return customerRepository.findAll();
	}

	/** Deletes an application customer by ID.
	 * 
	 * @param customerId The ID of the customer to be deleted.
	 * @return The deleted entity if the ID is not 0 and the customer is found; otherwise, null.
	 */
	@Override
	public AppCustomer deleteCustomer(int customerId){
		if(customerId != 0) {
			return customerRepository.findById(customerId).get();
		}
		return null;
	}

	/** Updates an application customer's information and stores the changes in the data source.
	 * 
	 * @param customer The entity representing the updated information of the customer.
	 * @return The updated entity, or null if the provided customer is null or the user code is 0.
	 */
	
	@Override
	@Transactional 
	public AppCustomer updateCustomer(AppCustomer customer) {
		if(customer != null) {
			int id = customer.getUserCode();
			AppCustomer savedCustomer = customerRepository.findById(id).get();
			if(savedCustomer != null) {
				if(customer.getContactInfo() != null) {
					ContactInfo cinfo = savedCustomer.getContactInfo();
					
					ContactInfo newInfo = customer.getContactInfo();
					if(newInfo.getCity()!= null) {
						cinfo.setCity(newInfo.getCity());
					}
					if(newInfo.getCountry()!= null) {
						cinfo.setCountry(newInfo.getCountry());
					}
					if(newInfo.getEmail()!= null) {
						cinfo.setEmail(newInfo.getEmail());
					}
					if(newInfo.getHouseAddress()!= null) {
						cinfo.setHouseAddress(newInfo.getHouseAddress());
					}
					if(newInfo.getPhone()!= 0) {
						cinfo.setPhone(newInfo.getPhone());
					}
					savedCustomer.setContactInfo(cinfo);
				}
				if(customer.getFullName()!= null) {
					savedCustomer.setFullName(customer.getFullName());
				}
				return savedCustomer;
			}
		}
		return null;
	}
	/** Updates an application customer's information by username and stores the changes in the data source.
	 * 
	 * @param customer The AppCustomer entity representing the updated information of the customer.
	 * @param username The username used to identify the customer to be updated.
	 * @return The updated AppCustomer entity, or null if the provided customer is null or the username does not exist.
	 */
	
	@Override
	@Transactional
	public AppCustomer updateCustomerByUsername(AppCustomer customer, String username) {
		if(customer != null) {
			AppCustomer savedCustomer = customerRepository.getAppCustomerByUsername(username);
			if(savedCustomer != null) {
				if(customer.getContactInfo() != null) {
					savedCustomer.setContactInfo(customer.getContactInfo());
				}
				if(customer.getFullName()!= null) {
					savedCustomer.setFullName(customer.getFullName());
				}
				return savedCustomer;
			}
		}
		return null;
	}
 /** Retrieves and views an application customer from the data source based on the user code.
  * 
  * @param userCode The user code of the customer to be viewed.
  * @return The AppCustomer entity associated with the provided user code, or null if no matching customer is found.
  */
	
	@Override
	public AppCustomer viewCustomer(int userCode) {
		if(userCode != 0) {
			return customerRepository.findById(userCode).get();
		}
		return null;
	}
/** Retrieves and views an application customer from the data source based on the provided username.
 * 
 * @param username The username of the customer to be viewed.
 * @return The AppCustomer entity associated with the provided username, or null if no matching customer is found.
 */
	
	@Override
	public AppCustomer viewCustomerByUserName(String username) {
		if(username != null) {
			return customerRepository.getAppCustomerByUsername(username);
		}
		return null;
	}
	
}
