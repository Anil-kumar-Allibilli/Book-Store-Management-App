package com.sprint.bspro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint.bspro.entity.Author;
import com.sprint.bspro.entity.Book;
import com.sprint.bspro.entity.Reviews;
@Repository
public interface IReviewsRepository extends JpaRepository<Reviews, Integer> {
	/** Retrieves a list of reviews from the data source based on the provided review category.
	 * 
	 * @param reviewCategory The review category used to filter reviews.
	 * @return A List of Review entities associated with the provided review category,
          or an empty list if no matching reviews are found.
	 */
	public List<Reviews> getReviewsByReviewCategory(String reviewCategory);
	
	/** Retrieves a list of reviews from the data source based on the provided review customer name.
	 * 
	 * @param CustomerName The review customername used to filter reviews.
	 * @return A List of Review entities associated with the provided review CustomerName,
          or an empty list if no matching reviews are found.
	 */
	
	public List<Reviews> getReviewsByCustomerName(String CustomerName);
	public List<Reviews> getReviewsByBook(Book book);
	public List<Reviews> getReviewsByAuthor(Author author);
}
