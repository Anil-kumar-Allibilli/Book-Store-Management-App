package com.sprint.bspro.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.bspro.dto.AppOrderResponseDTO;
import com.sprint.bspro.entity.AppOrder;
import com.sprint.bspro.entity.Author;
import com.sprint.bspro.entity.Book;
import com.sprint.bspro.entity.Reviews;
import com.sprint.bspro.repository.IAuthorRepository;
import com.sprint.bspro.repository.IBookRepository;
import com.sprint.bspro.repository.IReviewsRepository;
import com.sprint.bspro.util.AppOrderDTOMapper;
@Service
public class BookServiceImpl implements IBookService{

	@Autowired
	IBookRepository bookRepository;
	@Autowired
	IReviewsRepository reviewsRepository;
	@Autowired
	IAuthorRepository authorRepository;
	
	/** Creates a new book and associates it with an existing author in the data source.
	 * 
	 * @param b The Book entity representing the book to be created.
	 * @param aname The username of the author to whom the book is associated.
	 * @return The saved Book entity associated with the author, or null if the provided book entity or
          author username is null, or if the author does not exist.
	 */
	@Override
	public Book createBook(Book b, String aname) {
		if(b != null && aname != null) {
			Author author = authorRepository.getAuthorByUsername(aname);
			List<Book> books = author.getBooks();
			b.setAuthor(author);
			Book savedBook = bookRepository.save(b);
			books.add(b);
			author.setBooks(books);
			authorRepository.save(author);
			return savedBook;
		}
		return null;
	}
/**
 * Retrieves a list of all books from the data source.
 * @return A List containing all books in the data source.
 */
	@Override
	public List<Book> listAllBooks() {
		return bookRepository.findAll();
	}
/** Deletes a book from the data source based on the provided book ID.
 * 
 * @param bId The ID of the book to be deleted.
 * @return The deleted Book entity, or null if the provided book ID is invalid or the deletion fails.
 */
	@Override
	public Book deleteBook(int bId) {
		try {
			Book b = bookRepository.findById(bId).get();
			 Author author = b.getAuthor();
			 List<Book> books = author.getBooks();
			 books.remove(b);
			 authorRepository.save(author);
			bookRepository.deleteById(bId);
			return b;
		}
		catch(Exception e){
		return null;
		}
	}
	/** Edits the details of a book in the data source based on the provided Book entity.
	 * 
	 * @param b The Book entity containing the updated details to be applied to the existing book.
	 * @return The edited Book entity with updated details, or null if the provided book entity is null or
         the book ID is invalid.
	 */
	@Override
	@Transactional
	public Book editBook(Book b) {
		if(b != null) {
			int id = b.getBookId();
			Book book = bookRepository.findById(id).get();
			if(b.getTitle()!=null) {
				book.setTitle(b.getTitle());
			}
			if(b.getDescription()!= null) {
				book.setDescription(b.getDescription());
			}
			if(b.getPrice()!= 0) {
				book.setPrice(b.getPrice());
			}
			if(b.getFeedbacks()!= null) {
				book.setFeedbacks(b.getFeedbacks());
			}
			if(b.getCategory()!= null) {
				book.setCategory(b.getCategory());
			}
			if(b.getPages()!= 0) {
				book.setPages(b.getPages());
			}
			return book;
		}
		return null;
	}
 /** Retrieves a book from the data source based on the provided book ID.
  * 
  * @param bId The ID of the book to be retrieved.
  * @return The Book entity representing the book with the provided ID.

  */
	@Override
	public Book getBookById(int bId ) {
		return bookRepository.findById(bId).get();
	}
	/** Retrieves a book from the data source based on the provided title.
	 * 
	 * @param title The title of the book to be retrieved.
	 * @return The Book entity representing the book with the provided title, or null if the title is null or no
 *         matching book is found.
	 */
	
	@Override
	public Book getBookByTitle(String title ) {
		Book book = bookRepository.getBookByTitle(title);
		return book;
	}
	/** Retrieves a list of books from the data source based on the provided category.
	 * 
	 * @param category The category of the books to be retrieved.
	 * @return A List<Book> containing the book entities with the provided category, or an empty list if the
          category is null or no matching books are found.
	 */
	@Override
	public List<Book> listBooksByCategory(String category) {
		return bookRepository.getBookByCategory(category);
	}
	/** Adds a feedback (review) to a book in the data source based on the provided title and review ID.
	 * 
	 * @param title The title of the book to which the feedback will be added.
	 * @param rid The ID of the review to be added as feedback to the book.
	 * @return The updated Book entity with the added feedback, or null if the book or review is not found,
         or if the addition fails.
	 */
	@Override
	@Transactional
	public Book addFeedbacks(String title, int rid) {
		Book book = bookRepository.getBookByTitle(title);
		if(book != null) {
			List<Reviews> reviews = book.getFeedbacks();
			Reviews review = reviewsRepository.findById(rid).get();
			if(review != null) {
				review.setBook(book);
				reviews.add(review);
				book.setFeedbacks(reviews);
				return book;
			}
		}
		return null;
	}
	
/** Updates the available quantity of a book with the given title.
 * 
 * @param title  the title of the book to update.
 * @param quantity the new available quantity for the book.
 * @return the updated Book object, or null if the book with the given title does not exist.
 */
	
	
	@Override
	@Transactional
	public Book updateAvailableQuantity(String title, int quantity) {
		Book book = bookRepository.getBookByTitle(title);
		if(book != null) {
			int presentQuantity = book.getAvailableQuantity();
			book.setAvailableQuantity(presentQuantity+ quantity);
		}
		return book;
	}

	@Override
	public List<Book> listBooksByAuthor(String authorname) {
		Author author = authorRepository.getAuthorByUsername(authorname);
		if(author != null) {
			List<Book> booklist = bookRepository.getBookByAuthor(author);
			return booklist;
		}
		return null;
	}

	@Override
	public List<Book> listBooksBySearch(String key) {
		if(key != null) {
			return bookRepository.findByTitleContaining(key);
		}
		return null;
	}

	@Override
	public List<AppOrder> getAllOrdersByBook(String bookname) {
		Book book = bookRepository.getBookByTitle(bookname);
		if(book != null) {
			return book.getOrders();
		}
		return null;
	}

	@Override
	public List<AppOrder> getAllOrdersByBookCategory(String category) {
		if(category != null) {
			List<Book> books = bookRepository.getBookByCategory(category);
			List<AppOrder> allOrders = new ArrayList<>();
			for(Book book: books) {
				allOrders.addAll(book.getOrders());
			}
			return allOrders;
		}
		return null;
	}

	@Override
	public List<Book> getBookByQuantity(int maxQuantity) {
		return bookRepository.findByAvailableQuantityLessThanEqual(maxQuantity);
	}

}
