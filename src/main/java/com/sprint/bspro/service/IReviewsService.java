package com.sprint.bspro.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sprint.bspro.entity.Reviews;
@Service
public interface IReviewsService {
	public List<Reviews> listAllReviews();
	public List<Reviews> listAllReviewsByCategory(String reviewCategory);
	public List<Reviews> listAllReviewsByCustomer(String customerName);
	public List<Reviews> listAllReviewsByBook(String bookName);
	public List<Reviews> listAllReviewsByAuthor(String authorName);
	public Reviews addReview(Reviews review);
	public Reviews updateReview(Reviews review);
	public Reviews viewReview(int rid);
}
