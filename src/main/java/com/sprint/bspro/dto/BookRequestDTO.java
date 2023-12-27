package com.sprint.bspro.dto;

public class BookRequestDTO {
	private String title;
	private String description;
	private int price;
	private int pages;
	private String category;
	private int id;
	private int availableQuantity;
	
	/**
	 * Retrieves the ID associated with this object.
	 *
	 * @return The unique identifier for this object.
	 */
	public int getId() {
		return id;
	}
	/**
	 * Sets the id associated with this object.
	 *
	 * @param id The unique identifier to be set.
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Retrieves the title associated with this object.
	 *
	 * @return The title for this object.
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * Sets the title associated with this object.
	 *
	 * @param title The title to be set.
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * This method is used to get the description.
	 *
	 * @return String This returns the description.
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * This method is used to set the description.
	 *
	 * @param description A string representing the description.
	 */
	
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * This method is used to get the price.
	 *
	 * @return integer This returns the price.
	 */
	public int getPrice() {
		return price;
	}
	/**
	 * This method is used to set the price.
	 *
	 * @param price A integer representing the price.
	 */
	
	public void setPrice(int price) {
		this.price = price;
	}
	/**
	 * This method is used to get the pages.
	 *
	 * @return integer This returns the pages.
	 */
	public int getPages() {
		return pages;
	}
	/**
	 * This method is used to set the pages.
	 *
	 * @param pages A integer representing the pages.
	 */
	public void setPages(int pages) {
		this.pages = pages;
	}
	/**
	 * This method is used to get the category.
	 *
	 * @return String This returns the category.
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * This method is used to set the category.
	 *
	 * @param pages A String representing the category.
	 */
	
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * This method is used to get the availableQuantity.
	 *
	 * @return An integer This returns the availableQuantity.
	 */
	public int getAvailableQuantity() {
		return availableQuantity;
	}
	/**
	 * This method is used to set the availableQuantity.
	 *
	 * @param availableQuantity An integer representing the available quantity.
	 */
	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}
	
	public BookRequestDTO(String title, String description, int price, int pages, String category, int id,
			int availableQuantity) {
		super();
		this.title = title;
		this.description = description;
		this.price = price;
		this.pages = pages;
		this.category = category;
		this.id = id;
		this.availableQuantity = availableQuantity;
	}
	public BookRequestDTO(String title, String description, int price, int pages, String category) {
		super();
		this.title = title;
		this.description = description;
		this.price = price;
		this.pages = pages;
		this.category = category;
	}
	public BookRequestDTO() {
		super();
	}
	
}
