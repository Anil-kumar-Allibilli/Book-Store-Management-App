package com.sprint.bspro.dto;

public class ReviewsResponseDTO {
	private int rid;
	private String comment;
	private String reviewDate;
	private int ratings;
	private String reviewCategory;
	private String customerName;
	
	/**
	 * @return the rid
	 */
	
	public int getRid() {
		return rid;
	}
	/**
	 * @param rid the rid to set
	 */
	public void setRid(int rid) {
		this.rid = rid;
	}
	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}
	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
	/**
     * Gets the review date.
     *
     * @return The review date.
     */
	public String getReviewDate() {
		return reviewDate;
	}
	/**
     * Sets the review date.
     *
     * @param reviewDate The new review date to be set.
     */
	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}
	/**
     * Gets the ratings given in the review.
     *
     * @return The ratings given in the review.
     */
	public int getRatings() {
		return ratings;
	}
	/**
     * Sets the ratings for the review.
     *
     * @param ratings The ratings to be set for the review.
     */
	public void setRatings(int ratings) {
		this.ratings = ratings;
	}
	/**
     * Gets the category of the review.
     *
     * @return The category of the review.
     */
	public String getReviewCategory() {
		return reviewCategory;
	}
	 /**
     * Sets the category for the review.
     *
     * @param reviewCategory The category to be set for the review.
     */
	public void setReviewCategory(String reviewCategory) {
		this.reviewCategory = reviewCategory;
	}
	 /**
     * Gets the name of the customer who provided the review.
     *
     * @return The name of the customer who provided the review.
     */
	public String getCustomerName() {
		return customerName;
	}
	/**
     * Sets the name of the customer who provided the review.
     *
     * @param customerName The name of the customer to be set for the review.
     */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public ReviewsResponseDTO(int rid, String comment, String reviewDate, int ratings, String reviewCategory,
			String customerName) {
		super();
		this.rid = rid;
		this.comment = comment;
		this.reviewDate = reviewDate;
		this.ratings = ratings;
		this.reviewCategory = reviewCategory;
		this.customerName = customerName;
	}
	public ReviewsResponseDTO() {
		super();
	}
}
