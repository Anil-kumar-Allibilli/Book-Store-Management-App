package com.sprint.bspro.util;

import com.sprint.bspro.dto.ReviewsRequestDTO;
import com.sprint.bspro.dto.ReviewsResponseDTO;
import com.sprint.bspro.entity.Reviews;

public class ReviewsDTOMapper {
	
	/** This method is used to convert a Reviews object to a ReviewsResponseDTO object.
	 * 
	 * @param review The Reviews object containing the review information.
	 * @return A ReviewsResponseDTO object with the information from the Reviews object.
	 */
	public ReviewsResponseDTO getReviewsDTOFromReviews (Reviews review ) {
	
		if(review != null) {
			ReviewsResponseDTO reviewResponse = new ReviewsResponseDTO();
			reviewResponse.setComment(review.getComment());
			reviewResponse.setCustomerName(review.getCustomerName());
			reviewResponse.setRatings(review.getRatings());
			reviewResponse.setReviewCategory(review.getReviewCategory());
			reviewResponse.setReviewDate(review.getReviewDate());
			reviewResponse.setRid(review.getRid());
			return reviewResponse;
		}
		return null;
	}
	/**This method is used to convert a ReviewsRequestDTO object to a Reviews object. 
	 * 
	 * @param reviewDTO The ReviewsRequestDTO object containing the review information.
	 * @return A Reviews object with the information from the ReviewsRequestDTO object.
	 */
	
	public Reviews getReviewsFromReviewsDTO (ReviewsRequestDTO reviewDTO) {
		if(reviewDTO != null) {
			Reviews review = new Reviews();
			review.setComment(reviewDTO.getComment());
			review.setCustomerName(reviewDTO.getCustomerName());
			review.setRatings(reviewDTO.getRatings());
			review.setReviewCategory(reviewDTO.getReviewCategory());
			review.setRid(reviewDTO.getRid());
			return review;
		}
		return null;
	}
}
