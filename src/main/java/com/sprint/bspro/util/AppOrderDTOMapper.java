package com.sprint.bspro.util;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.sprint.bspro.dto.AppOrderRequestDTO;
import com.sprint.bspro.dto.AppOrderResponseDTO;
import com.sprint.bspro.dto.CartDTO;
import com.sprint.bspro.entity.AppCustomer;
import com.sprint.bspro.entity.AppOrder;
import com.sprint.bspro.entity.Book;
@Component
public class AppOrderDTOMapper {
	
	/** This method is used to convert an AppOrderRequestDTO object to an AppOrder object.
	 * 
	 * @param appOrderDTO The AppOrderRequestDTO object containing the app order information. 
	 * @return An AppOrder object with the information from the AppOrderRequestDTO object.
	 */
	public AppOrder getAppOrderFromAppOrderRequestDTO(AppOrderRequestDTO appOrderDTO) {
		AppOrder appOrder = new AppOrder();
		appOrder.setOrderValue(appOrderDTO.getOrderValue());
		List<CartDTO>orderDetails = appOrderDTO.getOrderDetails();
		Map<Book,Integer> bookMap = new HashMap<>();
		for(CartDTO cart: orderDetails) {
			String name = cart.getBookName();
			Book book = new Book();
			book.setTitle(name);
			bookMap.put(book, cart.getUnits());
		}
		appOrder.setOrderDetails(bookMap);
		String user = appOrderDTO.getUsername();
		AppCustomer customer = new AppCustomer();
		customer.setUsername(user);
		appOrder.setCustomer(customer);
		appOrder.setOrderDate(LocalDate.now().toString());
		appOrder.setOrderStatus("placed successfully");
		return appOrder;
	}
	/** This method is used to convert an AppOrder object to an AppOrderResponseDTO object. 
	 * 
	 * @param appOrder The AppOrder object containing the app order information.
	 * @return An AppOrderResponseDTO object with the information from the AppOrder object.
	 */
	public AppOrderResponseDTO getAppOrderResponseDTOFromAppOrder(AppOrder appOrder) {
		AppOrderResponseDTO responseDTO = new AppOrderResponseDTO();
		responseDTO.setCustomerName(appOrder.getCustomer().getUsername());
		responseDTO.setOrderDate(appOrder.getOrderDate());
		responseDTO.setOrderNumber(appOrder.getOrderNumber());
		responseDTO.setOrderValue(appOrder.getOrderValue());
		responseDTO.setOrderStatus(appOrder.getOrderStatus());
		Map<Book,Integer> orderMap = appOrder.getOrderDetails();
		List<CartDTO> orderDetails = new ArrayList<>();
		for(Map.Entry<Book,Integer> e: orderMap.entrySet()) {
			CartDTO cart = new CartDTO();
			cart.setBookName(e.getKey().getTitle());
			cart.setUnits(e.getValue());
			orderDetails.add(cart);
		}
		responseDTO.setOrderDetails(orderDetails);
		return responseDTO;
	}
}
