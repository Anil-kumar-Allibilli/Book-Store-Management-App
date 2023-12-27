package com.sprint.bspro.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.sprint.bspro.entity.AppOrder;
import com.sprint.bspro.repository.IAppCustomerRepository;
import com.sprint.bspro.repository.IAppOrderRepository;

@SpringBootTest
class AppOrderServiceImplTest2 {
	
	@Mock
	private IAppOrderRepository orderRepository;
	
	@Mock
	private IAppCustomerRepository customerRepository;
	
	@InjectMocks
	private AppOrderServiceImpl appOrderService;
	

	@Test
	public void testViewAllOrders() {
		AppOrder order1=new AppOrder();
		AppOrder order2=new AppOrder();
		List<AppOrder> mockOrders=new ArrayList<>();
		mockOrders.add(order1);
		mockOrders.add(order2);
		
		when(orderRepository.findAll()).thenReturn(mockOrders);
		List<AppOrder> result=appOrderService.viewAllOrders();
		assertNotNull(result);
		assertEquals(2,result.size());
	}
	
	

}
