package com.sprint.bspro.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.exceptions.base.MockitoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.sprint.bspro.entity.Author;
import com.sprint.bspro.entity.Book;
import com.sprint.bspro.repository.IAuthorRepository;
import com.sprint.bspro.repository.IBookRepository;

@SpringBootTest
class BookServiceImplTest {
	
	@MockBean
	IBookRepository mockBookRepository;
	
	@Autowired
	BookServiceImpl bookService;
	
	@MockBean
	IAuthorRepository authorRepository;
	
	@Test
	public void listAllBooksTest() {
		
		when(mockBookRepository.findAll()).thenReturn(Stream.of(new Book(1,"Harry poter",null,null,520,560,820,null,null,null),new Book(1,"Harry poter",null,null,520,890,780,null,null,null)).collect(Collectors.toList()));
		
		assertEquals(2,bookService.listAllBooks().size());
	}
	 @Test
	    public void testGetBookById() {
	        int bookId = 1;
	        Book mockBook = new Book();
	        mockBook.setBookId(bookId);
	      
	 
	        when(mockBookRepository.findById(bookId)).thenReturn(Optional.of(mockBook));
	 
	        Book result = bookService.getBookById(bookId);
	 
	        assertNotNull(result);
	        assertEquals(bookId, result.getBookId());
	       	 
	 }	
	 @Test
	    public void testGetBookByTitle() {
	        String title = "Anil";
	        Book mockBook = new Book();
	        mockBook.setTitle(title);
	 
	        when(mockBookRepository.getBookByTitle(title)).thenReturn(mockBook);
	 
	        Book result = bookService.getBookByTitle(title);
	 
	        assertNotNull(result);
	        assertEquals(title, result.getTitle());
	 
	        
	    }
//	 @Test
//	    public void testCreateBook() {
//	        Book bookToCreate = new Book();
//	        bookToCreate.setTitle("Project");
//	        String authorName="Mock Author";
//	        Author mockAuthor=new Author();
//	        mockAuthor.setName(authorName);
////	        List<Book> authorBooks=new ArrayList<>();
//	        
//	        when(authorRepository.getAuthorByUsername(authorName)).thenReturn(mockAuthor);
//	        when(mockBookRepository.save(bookToCreate)).thenReturn(bookToCreate);
//	 
//	        Book result = bookService.createBook(bookToCreate,authorName);
//	 
//	        assertNotNull(result);
//	        assertEquals("Project", result.getTitle());
//	        assertEquals("Mock Author",result.getAuthor());
//	        
//	       
//	 
//	    }	


	 
	 
	
}
