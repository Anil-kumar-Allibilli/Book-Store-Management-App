package com.sprint.bspro.util;

import org.springframework.stereotype.Component;

import com.sprint.bspro.dto.AppCustomerRequestDTO;
import com.sprint.bspro.dto.AppCustomerResponseDTO;
import com.sprint.bspro.entity.AppCustomer;
import com.sprint.bspro.entity.ContactInfo;
@Component
public class AppCustomerDTOMapper {
	/** This method is used to convert an AppCustomerRequestDTO object to an AppCustomer object. 
	 * 
	 * @param reqDTO The AppCustomerRequestDTO object containing the app customer information.
	 * @return An AppCustomer object with the information from the AppCustomerRequestDTO object
	 */
	public AppCustomer getAppCustomerFromAppCustomerDTO(AppCustomerRequestDTO reqDTO) {
		AppCustomer ac = new AppCustomer();
		ContactInfo contact = new ContactInfo();
		contact.setCity(reqDTO.getCity());
		contact.setCountry(reqDTO.getCountry());
		contact.setEmail(reqDTO.getEmail());
		contact.setHouseAddress(reqDTO.getHouseAddress());
		contact.setPhone(reqDTO.getPhone());
		ac.setUserCode(reqDTO.getUserCode());
		ac.setFullName(reqDTO.getFullName());
		ac.setContactInfo(contact);
		ac.setPassword(reqDTO.getPassword());
		ac.setUsername(reqDTO.getUsername());
		ac.setUserrole(reqDTO.getUserrole());
		return ac;
	}
	/** This method is used to convert an AppCustomer object to an AppCustomerResponseDTO object.
	 *  
	 * @param customer The AppCustomer object containing the app customer information.
	 * @return An AppCustomerResponseDTO object with the information from the AppCustomer object. 
	 */
	public AppCustomerResponseDTO getAppCustomerDTOFromAppCustomer(AppCustomer customer) {
		AppCustomerResponseDTO adto = new AppCustomerResponseDTO();
		ContactInfo c = customer.getContactInfo();
		adto.setCity(c.getCity());
		adto.setCountry(c.getCountry());
		adto.setEmail(c.getEmail());
		adto.setHouseAddress(c.getHouseAddress());
		adto.setPhone(c.getPhone());
		adto.setFullName(customer.getFullName());
		adto.setUserCode(customer.getUserCode());
		adto.setUsername(customer.getUsername());
		adto.setUserrole(customer.getUserrole());
		adto.setPassword(customer.getPassword());
		return adto;
	}
}
