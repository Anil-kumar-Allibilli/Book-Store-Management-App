package com.sprint.bspro.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sprint.bspro.dto.AppOrderResponseDTO;
import com.sprint.bspro.entity.AppOrder;
import com.sprint.bspro.entity.Book;
@Service
public interface IBookService {
	public Book createBook(Book b, String aname);
	public List<Book> listAllBooks();
	public Book deleteBook(int bId);
	public Book editBook(Book b);
	public Book getBookById(int bId);
	public Book getBookByTitle(String title);
	public List<Book> listBooksByCategory(String cat);
	public List<Book> listBooksByAuthor(String authorname);
	public List<Book> listBooksBySearch(String key);
	public Book addFeedbacks(String title, int rid);
	public Book updateAvailableQuantity(String title, int quantity);
	public List<AppOrder> getAllOrdersByBook(String bookname);
	public List<AppOrder> getAllOrdersByBookCategory(String category);
	public List<Book> getBookByQuantity(int maxQuantity);
}
