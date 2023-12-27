package com.sprint.bspro.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.sprint.bspro.entity.Admin;
import com.sprint.bspro.entity.Author;
import com.sprint.bspro.entity.Book;
import com.sprint.bspro.repository.IAuthorRepository;

@SpringBootTest
class AuthorServiceImplTest {
	
	@MockBean
	IAuthorRepository authorRepository;
	
	@Autowired
	AuthorServiceImpl authorService;

	@Test
	public void testViewAuthorByName() {
		String userName="Ravi";
		Author mockAuthor = new Author();
		mockAuthor.setName(userName);
 
        when(authorRepository.getAuthorByUsername(userName)).thenReturn(mockAuthor);
 
        Author result = authorService.viewAuthorByName(userName);
 
        assertNotNull(result);
        assertEquals(userName, result.getName());
 
	}
	@Test
	public void testCreateAppAuthor() {
		Author author=new Author();
		author.setUsername("mockAdmin");
		
		Author savedAuthor=new Author();
		savedAuthor.setUsername("mockAdmin");
		savedAuthor.setUserCode(5);
		
		when(authorRepository.save(author)).thenReturn(savedAuthor);
		when(authorRepository.getAuthorByUsername("mockAdmin")).thenReturn(savedAuthor);
		
		Author result=authorService.createAppAuthor(author);
		
		assertNotNull(result);
		assertEquals("mockAdmin", result.getUsername());
		assertEquals(5,result.getUserCode());
		
	}
	
	

}
