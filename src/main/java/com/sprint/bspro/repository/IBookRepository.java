package com.sprint.bspro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sprint.bspro.entity.Author;
import com.sprint.bspro.entity.Book;
@Repository
public interface IBookRepository extends JpaRepository<Book, Integer> {
	
	/** Retrieves a book from the data source based on the provided title.
	 * 
	 * @param title The title of the book to be retrieved.
	 * @return The Book entity associated with the provided title, or null if no matching book is found.
	 */
	public Book getBookByTitle(String title);
	
	
	
	/**Retrieves a book from the data source based on the provided title.
	 * 
	 * @param category The category of the books to be retrieved.
	 * @return A List of Book entities associated with the provided category,
        or an empty list if no matching books are found.
	 */
	
	public List<Book> getBookByCategory(String category);
	public List<Book> getBookByAuthor(Author author);
	public List<Book> findByTitleContaining(String title);
	public List<Book> findByAvailableQuantityLessThanEqual(int maxQuantity);
}
