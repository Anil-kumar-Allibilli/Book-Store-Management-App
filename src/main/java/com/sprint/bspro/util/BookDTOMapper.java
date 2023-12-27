package com.sprint.bspro.util;

import java.util.ArrayList;
import java.util.List;

import com.sprint.bspro.dto.BookRequestDTO;
import com.sprint.bspro.dto.BookResponseDTO;
import com.sprint.bspro.dto.ReviewsResponseDTO;
import com.sprint.bspro.entity.Book;
import com.sprint.bspro.entity.Reviews;

public class BookDTOMapper {
	/** This method is used to convert a BookRequestDTO object to a Book object.
	 * 
	 * @param dto The BookRequestDTO object containing the book information.
	 * @return A Book object with the information from the BookRequestDTO object.
	 */
	public Book getBookFromBookDTO(BookRequestDTO dto) {
		Book bk = new Book();
		if(dto.getId()!= 0) {
			bk.setBookId(dto.getId());
		}
		bk.setTitle(dto.getTitle());
		bk.setPrice(dto.getPrice());
		bk.setCategory(dto.getCategory());
		bk.setPages(dto.getPages());
		bk.setDescription(dto.getDescription());
		bk.setAvailableQuantity(dto.getAvailableQuantity());
		System.out.println("the book is ! "+ bk.getBookId());
		return bk;
	}
	/**  This method is used to convert a Book object to a BookResponseDTO object. 
	 * 
	 * @param book The Book object containing the book information.
	 * @return A BookResponseDTO object with the information from the Book object.
	 */
	public BookResponseDTO getBookDTOFromBook(Book book) {
		BookResponseDTO bdto = new BookResponseDTO();
		bdto.setTitle(book.getTitle());
		bdto.setDescription(book.getDescription());
		bdto.setPrice(book.getPrice());
		bdto.setId(book.getBookId());
		bdto.setCategory(book.getCategory());
		bdto.setPages(book.getPages());
		if(book.getFeedbacks()!= null) {
		List<Reviews> reviews = book.getFeedbacks();
		List<ReviewsResponseDTO> reviewDtoList = new ArrayList<>();
		ReviewsDTOMapper dtoMapper = new ReviewsDTOMapper();
		for(Reviews review: reviews) {
			ReviewsResponseDTO reviewResponse = dtoMapper.getReviewsDTOFromReviews(review);
			reviewDtoList.add(reviewResponse);
		}
		bdto.setReviewList(reviewDtoList);
		}
		if(book.getAuthor()!=null) {
			bdto.setAuthor(book.getAuthor().getUsername());
		}
		bdto.setAvailableQuantity(book.getAvailableQuantity());
		return bdto;
	}
}
