package com.sprint.bspro.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.bspro.entity.Author;
import com.sprint.bspro.entity.Book;
import com.sprint.bspro.entity.Reviews;
import com.sprint.bspro.repository.IAuthorRepository;
import com.sprint.bspro.repository.IBookRepository;
import com.sprint.bspro.repository.IReviewsRepository;
@Service
public class ReviewsServiceImpl implements IReviewsService {
	@Autowired
	IReviewsRepository reviewsRepository;
	@Autowired
	IBookRepository bookRepository;
	@Autowired
	IAuthorRepository authorRepository;
	@Override
	/** This method is used to retrieve a list of all reviews.
	 * 
	 * @return A list of Reviews objects representing all the reviews.
	 */
	
	public List<Reviews> listAllReviews() {
		return reviewsRepository.findAll();
	}
	/**  This method is used to retrieve a list of reviews by a specific category. 
	 * 
	 * @param reviewCategory The category of the reviews to be retrieved.
	 * @return A list of Reviews objects representing the reviews in the specified category. 
	 */
	
	@Override
	public List<Reviews> listAllReviewsByCategory(String reviewCategory) {
		if(reviewCategory != null) {
			return reviewsRepository.getReviewsByReviewCategory(reviewCategory);
		}
		return null;
	}
/** This method is used to add a new review.
 * 
 * @param review The review object to be added.
 * @return The added Reviews object if the review parameter is not null, null otherwise. 
 */
	@Override
	public Reviews addReview(Reviews review) {
		if(review != null) {
			review.setReviewDate(LocalDate.now().toString());
			return reviewsRepository.save(review);
		}
		return null;
	}
	/** This method is used to update an existing review.
	 * 
	 * @param review The review object containing the updated information.
	 * @return The updated Reviews object if the review parameter is not null and the review is found in the repository, null otherwise.
	 */

	@Override
	public Reviews updateReview(Reviews review) {
		Reviews savedReview = reviewsRepository.findById(review.getRid()).get();
		if(savedReview != null) {
			if(review.getRatings()!= 0) {
				savedReview.setRatings(review.getRatings());
				reviewsRepository.save(savedReview);
				return savedReview;
			}
		}
		return null;
	}
/** This method is used to view a specific review by its ID. 
 * 
 * @param rid The ID of the review to be viewed. 
 * @return The Reviews object representing the review with the specified ID if rid is not 0,null otherwise.
 */
	
	@Override
	public Reviews viewReview(int rid) {
		if(rid != 0) {
			return reviewsRepository.findById(rid).get();
		}
		return null;
	}
/** This method is used to retrieve a list of reviews by a specific customer.
 * 
 * @param customerName The name of the customer whose reviews are to be retrieved.
 * @return A list of Reviews objects representing the reviews by the specified customer.
 */
	@Override
	public List<Reviews> listAllReviewsByCustomer(String customerName) {
		if(customerName != null) {
			return reviewsRepository.getReviewsByCustomerName(customerName);
		}
		return null;
	}

	@Override
	public List<Reviews> listAllReviewsByBook(String bookName) {
		Book book = bookRepository.getBookByTitle(bookName);
		if(book != null) {
			List<Reviews> reviewlist = reviewsRepository.getReviewsByBook(book);
			return reviewlist;
		}
		return null;
	}

	@Override
	public List<Reviews> listAllReviewsByAuthor(String authorName) {
		Author author = authorRepository.getAuthorByUsername(authorName);
		if(author != null) {
			List<Reviews> reviewlist = reviewsRepository.getReviewsByAuthor(author);
			System.out.println(reviewlist.get(0).getRatings());
			return reviewlist;
		}
		return null;
	}
	
}
