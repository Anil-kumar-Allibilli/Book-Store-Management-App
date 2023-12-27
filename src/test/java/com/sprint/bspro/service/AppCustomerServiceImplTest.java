package com.sprint.bspro.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.sprint.bspro.entity.Admin;
import com.sprint.bspro.entity.AppCustomer;
import com.sprint.bspro.repository.IAppCustomerRepository;

@SpringBootTest
class AppCustomerServiceImplTest {
	@MockBean
	IAppCustomerRepository appCustomerRepository;
	@Autowired
	AppCustomerServiceImpl appCustomerService;

	@Test
	public void testViewCustomerByUserName() {
		String userName="Harry";
		AppCustomer mockAppCustomer=new AppCustomer();
		mockAppCustomer.setUsername(userName);
		
		
		when(appCustomerRepository.getAppCustomerByUsername(userName)).thenReturn(mockAppCustomer);
		 
		AppCustomer result = appCustomerService.viewCustomerByUserName(userName);
 
        assertNotNull(result);
        assertEquals(userName, result.getUsername());

	}
	@Test
	public void testCreateAppCustomer() {
		AppCustomer customer=new AppCustomer();
		customer.setUsername("mockAppCustomer");
		
		AppCustomer savedAppCustomer=new AppCustomer();
		savedAppCustomer.setUsername("mockAppCustomer");
		savedAppCustomer.setUserCode(5);
		
		when(appCustomerRepository.save(customer)).thenReturn(savedAppCustomer);
		when(appCustomerRepository.getAppCustomerByUsername("mockAppCustomer")).thenReturn(savedAppCustomer);
		
		AppCustomer result=appCustomerService.createAppCustomer(customer);
		
		assertNotNull(result);
		assertEquals("mockAppCustomer", result.getUsername());
		assertEquals(5,result.getUserCode());

	}

}
