package com.sprint.bspro.dto;

public class CartDTO {
	private String bookName;
	private int units;
	
	
	/**
	 * This method is used to get the book's name.
	 *
	 * @return String This returns the book's name.
	 */

	public String getBookName() {
		return bookName;
	}
	/**
	 * This method is used to set the bookName.
	 *
	 * @param bookName A string representing the bookName.
	 */
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	/**
	 * This method is used to get the units.
	 *
	 * @return integer This returns the units.
	 */
	public int getUnits() {
		return units;
	}
	/**
	 * This method is used to set the units.
	 *
	 * @param units An integer representing the units.
	 */
	public void setUnits(int units) {
		this.units = units;
	}
	public CartDTO(String bookName, int units) {
		super();
		this.bookName = bookName;
		this.units = units;
	}
	public CartDTO() {
		super();
	}
	
}
