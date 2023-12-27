package com.sprint.bspro.dto;

public class ReviewsRequestDTO {
	private String comment;
	private int ratings;
	private String reviewCategory;
	private String customerName;
	private int rid;
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
	 * @return the ratings
	 */
	public int getRatings() {
		return ratings;
	}
	/**
	 * @param ratings the ratings to set
	 */
	public void setRatings(int ratings) {
		this.ratings = ratings;
	}
	/**
	 * @return the reviewCategory
	 */
	public String getReviewCategory() {
		return reviewCategory;
	}
	/**
	 * @param reviewCategory the reviewCategory to set
	 */
	public void setReviewCategory(String reviewCategory) {
		this.reviewCategory = reviewCategory;
	}
	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}
	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
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
	public ReviewsRequestDTO(String comment, int ratings, String reviewCategory, String customerName, int rid) {
		super();
		this.comment = comment;
		this.ratings = ratings;
		this.reviewCategory = reviewCategory;
		this.customerName = customerName;
		this.rid = rid;
	}
	public ReviewsRequestDTO(String comment, int ratings, String reviewCategory, String customerName) {
		super();
		this.comment = comment;
		this.ratings = ratings;
		this.reviewCategory = reviewCategory;
		this.customerName = customerName;
	}
	public ReviewsRequestDTO() {
		super();
	}
}
