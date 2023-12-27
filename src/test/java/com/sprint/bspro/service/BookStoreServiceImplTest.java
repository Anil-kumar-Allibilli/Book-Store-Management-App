package com.sprint.bspro.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.sprint.bspro.entity.BookStoreUser;
import com.sprint.bspro.repository.IBookStoreUserRepository;

@SpringBootTest
class BookStoreServiceImplTest {
	@Mock
	private IBookStoreUserRepository bookStoreUserRepository;
	
	@InjectMocks
	private BookStoreServiceImpl bookService;

	@Test
	public void testAppLogin() {
		String userName="AbcUser";
		String password="AbcPassword";
		BookStoreUser mockUser=new BookStoreUser();
		mockUser.setUsername(userName);
		mockUser.setPassword(password);
		mockUser.setUserrole("customer");
		
		when(bookStoreUserRepository.getBookStoreUserByUsername(userName)).thenReturn(mockUser);
		
		String result=bookService.appLogin(userName, password);
		assertEquals("customer",result);
	}

}
