package com.sprint.bspro.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.Api;

@Api(value = "All Book Specific Book Endpoints")
@Entity
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int bookId;
	@NotNull
	private String title;
	private String description;
	private String category;
	private int pages;
	@Min(value=100)
	@NotNull
	private int price;
	private int availableQuantity;
	
	@ManyToOne
	private Author author;
	
	@OneToMany(cascade =  CascadeType.ALL)
	private List<Reviews> feedbacks;
	
	@ManyToMany
	@JoinTable(name = "OrderDetails", 
	joinColumns = @JoinColumn(name = "book"), 
	inverseJoinColumns = @JoinColumn(name = "orderNumber"))
	private List<AppOrder> orders;

	/**
	 * @return the bookId
	 */
	public int getBookId() {
		return bookId;
	}

	/**
	 * @param bookId the bookId to set
	 */
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * @return the feedbacks
	 */
	public List<Reviews> getFeedbacks() {
		return feedbacks;
	}

	/**
	 * @param feedbacks the feedbacks to set
	 */
	public void setFeedbacks(List<Reviews> feedbacks) {
		this.feedbacks = feedbacks;
	}

	/**
	 * @return the orders
	 */
	public List<AppOrder> getOrders() {
		return orders;
	}
	/**
	 * @param orders the orders to set
	 */
	public void setOrders(List<AppOrder> orders) {
		this.orders = orders;
	}
	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the pages
	 */
	public int getPages() {
		return pages;
	}

	/**
	 * @param pages the pages to set
	 */
	public void setPages(int pages) {
		this.pages = pages;
	}
	
	/**
	 * @return the availableQuantity
	 */
	public int getAvailableQuantity() {
		return availableQuantity;
	}

	/**
	 * @param availableQuantity the availableQuantity to set
	 */
	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
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

	public Book(int bookId, String title, String description, String category, int pages, int price,
			int availableQuantity, Author author, List<Reviews> feedbacks, List<AppOrder> orders) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.description = description;
		this.category = category;
		this.pages = pages;
		this.price = price;
		this.availableQuantity = availableQuantity;
		this.author = author;
		this.feedbacks = feedbacks;
		this.orders = orders;
	}

	public Book(String title, String description, String category, int pages, int price) {
		super();
		this.title = title;
		this.description = description;
		this.category = category;
		this.pages = pages;
		this.price = price;
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
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
