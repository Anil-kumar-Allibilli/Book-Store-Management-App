package com.sprint.bspro.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Reviews {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int rid;
	private String comment;
	private String reviewDate; // date only month & year ... like Aug 2023
	@NotNull
	private int ratings;
	private String reviewCategory;
	private String customerName;
	@ManyToOne
	private Book book;
	@ManyToOne
	private Author author;
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
	 * @return the reviewDate
	 */
	public String getReviewDate() {
		return reviewDate;
	}
	/**
	 * @param reviewDate the reviewDate to set
	 */
	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}
	/**
	 * @return the ratings
	 */
	public int getRatings() {
		return ratings;
	}
	/**
	 * @param raitings the ratings to set
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
	 * @return the book
	 */
	public Book getBook() {
		return book;
	}
	/**
	 * @param book the book to set
	 */
	public void setBook(Book book) {
		this.book = book;
	}
	/**
	 * @return the author
	 */
	public Author getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(Author author) {
		this.author = author;
	}
	public Reviews(int rid, String comment, String reviewDate, int ratings, String reviewCategory, String customerName) {
		super();
		this.rid = rid;
		this.comment = comment;
		this.reviewDate = reviewDate;
		this.ratings = ratings;
		this.reviewCategory = reviewCategory;
		this.customerName = customerName;
	}
	public Reviews() {
		super();
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	
}
