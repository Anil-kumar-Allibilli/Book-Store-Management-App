package com.sprint.bspro.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sprint.bspro.dto.AppCustomerRequestDTO;
import com.sprint.bspro.dto.AppCustomerResponseDTO;
import com.sprint.bspro.dto.AppOrderRequestDTO;
import com.sprint.bspro.dto.AppOrderResponseDTO;
import com.sprint.bspro.dto.BookResponseDTO;
import com.sprint.bspro.dto.ReviewsRequestDTO;
import com.sprint.bspro.dto.ReviewsResponseDTO;
import com.sprint.bspro.entity.AppCustomer;
import com.sprint.bspro.entity.AppOrder;
import com.sprint.bspro.entity.Book;
import com.sprint.bspro.entity.Reviews;
import com.sprint.bspro.service.IAppCustomerService;
import com.sprint.bspro.service.IAppOrderService;
import com.sprint.bspro.service.IAuthorService;
import com.sprint.bspro.service.IBookService;
import com.sprint.bspro.service.IReviewsService;
import com.sprint.bspro.util.AppCustomerDTOMapper;
import com.sprint.bspro.util.AppOrderDTOMapper;
import com.sprint.bspro.util.BookDTOMapper;
import com.sprint.bspro.util.ReviewsDTOMapper;
@CrossOrigin
@RestController
@RequestMapping("/user")
@Validated
public class CustomerController {
	@Autowired
	IBookService bookService;
	@Autowired
	IAppCustomerService appCustomerService;
	@Autowired
	IReviewsService reviewService;
	@Autowired
	IAuthorService authorService;
	@Autowired
	IAppOrderService orderService;
	Logger logger = LoggerFactory.getLogger(AuthorController.class);
	

	
	/** * Retrieves a book based on the provided book ID.
	 * 
	 * @param title The ID of the book to be retrieved.
	 * @return A ResponseEntity containing the BookResponseDTO representing the retrieved book and the HTTP status code.
	 */

	@GetMapping("/allbooks")
	public List<BookResponseDTO> getAllBooks(){
		logger.info("Request received to get all books");
		List<Book> books = bookService.listAllBooks();
		List<BookResponseDTO> booksDtos = new ArrayList<>();
		BookDTOMapper brc = new BookDTOMapper();
		for(Book book: books) {
			BookResponseDTO bookDto = brc.getBookDTOFromBook(book);
			booksDtos.add(bookDto);
		}
		 logger.info("---------ALL BOOK RETRIVED SUCCESSFULLY------");		 
		return booksDtos;
	}
	
	@GetMapping("/searchbooks")
	public List<BookResponseDTO> getAllBooksBySearch(@RequestParam String key){
		logger.info("Request received to get all book by search", key);
		List<Book> books = bookService.listBooksBySearch(key);
		List<BookResponseDTO> booksDtos = new ArrayList<>();
		BookDTOMapper brc = new BookDTOMapper();
		for(Book book: books) {
			BookResponseDTO bookDto = brc.getBookDTOFromBook(book);
			booksDtos.add(bookDto);
		}
		 logger.info("---SUCCESSFULLY RETRIVES ALL BOOKS BY SEARCH---");		 
		return booksDtos;
	}
	
	@GetMapping("/allbooks/category")
	public List<BookResponseDTO> getAllBooksByCategory(@RequestParam String category){
		logger.info("Request received to get all book by category", category);
		List<Book> books = bookService.listBooksByCategory(category);
		List<BookResponseDTO> booksDtos = new ArrayList<>();
		BookDTOMapper brc = new BookDTOMapper();
		for(Book book: books) {
			BookResponseDTO bookDto = brc.getBookDTOFromBook(book);
			booksDtos.add(bookDto);
		}
		 logger.info("---SUCCESSFULLY RETRIVES ALL BOOKS BY CATEGORY---",category);		 
		return booksDtos;
	}
	
	@GetMapping("/viewbook/author")
	public List<BookResponseDTO> viewBookByAuthor(@RequestParam String authorname) {
		logger.info("Request received to view books by author name", authorname);
		if(authorname!= null) {
			List<Book> listBookByAuthor = bookService.listBooksByAuthor(authorname);
			List<BookResponseDTO> booksDtoList = new ArrayList<>();
			BookDTOMapper dtoConverter = new BookDTOMapper();
			for(Book book: listBookByAuthor) {
				BookResponseDTO converterBook = dtoConverter.getBookDTOFromBook(book);
				booksDtoList.add(converterBook);
			}
			 logger.info("---SUCCESSFULLY RETRIVES ALL BOOKS BY AUTHOR NAME---",authorname);		 
			return booksDtoList;
		}
		return null;
	}
	
	@GetMapping("/bookinfo")
	public ResponseEntity<BookResponseDTO> getBookById(@RequestParam int id) {
		 Book book = bookService.getBookById(id);
		 BookDTOMapper brc = new BookDTOMapper();
		 BookResponseDTO bresponse= brc.getBookDTOFromBook(book);
	     logger.info("---SUCCESSFULLY RETRIVED BOOK BY ID---", id);
		 return new ResponseEntity<BookResponseDTO>(bresponse, HttpStatus.OK);
	}
	/** * Retrieves a book based on the provided book title. 
	 * 
	 * @param title The title of the book to be retrieved.
	 * @return A ResponseEntity containing the BookResponseDTO representing the retrieved book and the HTTP status code.
	 */
	
	@GetMapping("/title/data")
	public ResponseEntity<BookResponseDTO> getBookByTitle(@RequestParam String title) {
		 Book book = bookService.getBookByTitle(title);
		 BookDTOMapper brc = new BookDTOMapper();
		 BookResponseDTO bresponse= brc.getBookDTOFromBook(book);
	     logger.info("---SUCCESSFULLU RETRIVED BOOK BY TITLE---", title);
		 return new ResponseEntity<BookResponseDTO>(bresponse, HttpStatus.OK);
	}

	/** * Retrieves a customer based on the provided user code.
	 * 
	 * @param usercode The user code of the customer to be retrieved.
	 * @return The AppCustomerResponseDTO representing the retrieved customer.
	 */

	@GetMapping("/viewcustomer")
	public AppCustomerResponseDTO getCustomerByUserCode(@RequestParam int usercode) {
        logger.info("Request received to get customer by user Code", usercode);
		AppCustomerDTOMapper dtoConverter = new AppCustomerDTOMapper();
        logger.info("---SUCCESSFULLU RETRIVED CUSTOMER BY USERCODE----.");
		return dtoConverter.getAppCustomerDTOFromAppCustomer(appCustomerService.viewCustomer(usercode));
	}
	/** * Retrieves a customer based on the provided username.
	 * 
	 * @param username The username of the customer to be retrieved.
 	 * @return The AppCustomerResponseDTO representing the retrieved customer.
	 */
	@GetMapping("/viewcustomerbyname")
	public AppCustomerResponseDTO getCustomerByUserName(@RequestParam String username) {
        logger.info("Request received to get customer by user name", username);
		AppCustomerDTOMapper dtoConverter = new AppCustomerDTOMapper();
        logger.info("---SUCCESSFULLU RETRIVED CUSTOMER BY USERNAME----.");
		return dtoConverter.getAppCustomerDTOFromAppCustomer(appCustomerService.viewCustomerByUserName(username));
	}
	/** * Updates the customer information based on the provided AppCustomerRequestDTO.
	 * 
	 * @param customerDTO The AppCustomerRequestDTO containing the updated customer information.
	 * @return 
	 */
	@PutMapping("/updatecustomer")
	public AppCustomerResponseDTO updateCustomer(@Valid @RequestBody AppCustomerRequestDTO customerDTO) {
        logger.info("Request received to Update Customer Information", customerDTO);
		if(customerDTO != null) {
			AppCustomerDTOMapper dtoConverter = new AppCustomerDTOMapper();
			AppCustomer customer = dtoConverter.getAppCustomerFromAppCustomerDTO(customerDTO);
			AppCustomer savedCustomer = appCustomerService.updateCustomer(customer);
            logger.info("---SUCCESSFULLY UPDATED CUSTOMER INFORMATION---");
			return dtoConverter.getAppCustomerDTOFromAppCustomer(savedCustomer);
		}
		return null;
	}
	/** * Updates the customer information based on the provided AppCustomerRequestDTO and username.
	 * 
	 * @param customerDTO The AppCustomerRequestDTO containing the updated customer information.
	 * @param username The username of the customer to be updated.
	 * @return The AppCustomerResponseDTO representing the updated customer, or null if the customerDTO is null.
	 */
	@PutMapping("/updatecustomerbyname")
	public AppCustomerResponseDTO updateCustomerByUsername(@Valid @RequestBody AppCustomerRequestDTO customerDTO, @RequestParam String username) {
        logger.info("Request received to Update Customer by username", customerDTO, username);
		if(customerDTO != null) {
			
			AppCustomerDTOMapper dtoConverter = new AppCustomerDTOMapper();
			AppCustomer customer = dtoConverter.getAppCustomerFromAppCustomerDTO(customerDTO);
			AppCustomer savedCustomer = appCustomerService.updateCustomerByUsername(customer, username);
            logger.info("--SYCCESSFULLY UPDATED CUSTOMER BY USERNAME---");
			return dtoConverter.getAppCustomerDTOFromAppCustomer(savedCustomer);
		}
		return null;
	}
	/** * Adds a new review based on the provided ReviewsRequestDTO and review item.
	 * 
	 * @param reviewDTO The ReviewsRequestDTO containing the review information. 
	 * @param reviewitem The review item associated with the review.
	 * @return The ReviewsResponseDTO representing the added review, or null if the reviewDTO is null.
	 */
	@PostMapping("/addreview")
	public ReviewsResponseDTO addReview(@Valid @RequestBody ReviewsRequestDTO reviewDTO, @RequestParam String reviewitem) {
        logger.info("Request received to add reviews", reviewDTO, reviewitem);
		if(reviewDTO != null) {
			ReviewsDTOMapper dtoConverter = new ReviewsDTOMapper();
			Reviews review = dtoConverter.getReviewsFromReviewsDTO(reviewDTO);
			Reviews savedReview = reviewService.addReview(review);
			if(savedReview.getReviewCategory().equals("author")) {
				authorService.addFeedbacks(reviewitem, savedReview.getRid());
			}
			if(savedReview.getReviewCategory().equals("book")) {
				bookService.addFeedbacks(reviewitem, savedReview.getRid());
			}
			 logger.info(" SUCCESSFULLY REVIEWS ARE ADDED:");
			return dtoConverter.getReviewsDTOFromReviews(savedReview);
		}
		return null;
	}
	/**
	 * Updates a review based on the provided ReviewsRequestDTO.
	 *
	 * @param reviewDTO The ReviewsRequestDTO containing the review data to be updated.
	 * @return A ReviewsResponseDTO representing the updated review, or null if reviewDTO is null.
	 */
	
	@PutMapping("/updatereview")
	public ReviewsResponseDTO updateReview(@Valid @RequestBody ReviewsRequestDTO reviewDTO) {
        logger.info("Request received to update reviews", reviewDTO);
		if(reviewDTO != null) {
			ReviewsDTOMapper dtoConverter = new ReviewsDTOMapper();
			Reviews review = dtoConverter.getReviewsFromReviewsDTO(reviewDTO);
			Reviews savedReview = reviewService.updateReview(review);
            logger.info("SUCCESSFULLY Updated review");
			return dtoConverter.getReviewsDTOFromReviews(savedReview);
		}
		return null;
	}
	/**
	 * Places an order based on the provided AppOrderRequestDTO.
	 *
	 * @param requestDTO The AppOrderRequestDTO containing the order data to be placed.
	 * @return An AppOrderResponseDTO representing the placed order, or null if requestDTO is null.
	 */
	
	@GetMapping("/viewreview/book")
	public List<ReviewsResponseDTO> viewReviewByBook(@RequestParam String bookname) {
        logger.info("Request reveived to view reviews by book name", bookname);
		if(bookname!= null) {
			List<Reviews> listReviewByBook = reviewService.listAllReviewsByBook(bookname);
			List<ReviewsResponseDTO> reviewsDtoList = new ArrayList<>();
			ReviewsDTOMapper dtoConverter = new ReviewsDTOMapper();
			for(Reviews review: listReviewByBook) {
				ReviewsResponseDTO converterReview = dtoConverter.getReviewsDTOFromReviews(review);
				reviewsDtoList.add(converterReview);
			}
            logger.info("SUCCESSFULLY RETRIVED REVIEWS BY BOOK NAME", bookname);
			return reviewsDtoList;
		}
		return null;
	}
	
	@GetMapping("/viewreview/author")
	public List<ReviewsResponseDTO> viewReviewByAuthor(@RequestParam String authorname) {
        logger.info("Request reveived to view reviews by author name", authorname);
		if(authorname!= null) {
			List<Reviews> listReviewByAuthor = reviewService.listAllReviewsByAuthor(authorname);
			List<ReviewsResponseDTO> reviewsDtoList = new ArrayList<>();
			ReviewsDTOMapper dtoConverter = new ReviewsDTOMapper();
			for(Reviews review: listReviewByAuthor) {
				ReviewsResponseDTO converterReview = dtoConverter.getReviewsDTOFromReviews(review);
				reviewsDtoList.add(converterReview);
			}
            logger.info("SUCCESSFULLY RETRIVED REVIEWS BY AUTHOR NAME", authorname);
			return reviewsDtoList;
		}
		return null;
	}
	
	@PostMapping("/placeorder")
	public AppOrderResponseDTO placeOrder(@Valid @RequestBody AppOrderRequestDTO requestDTO) {
        logger.info("Request reveived to place an order", requestDTO);
		if(requestDTO != null) {
			AppOrderDTOMapper dtoMapper = new AppOrderDTOMapper();
			AppOrder order = dtoMapper.getAppOrderFromAppOrderRequestDTO(requestDTO);
			AppOrder placedOrder = orderService.addOrder(order);
            logger.info("SUCCESSFULLY Placed order");
			return dtoMapper.getAppOrderResponseDTOFromAppOrder(placedOrder);
		}
		return null;
	}
	/**
	 * Cancels an order based on the provided order ID.
	 *
	 * @param oid The unique identifier of the order to be canceled.
	 * @return An AppOrderResponseDTO representing the canceled order, or null if the order does not exist.
	 */
	@PutMapping("/cancelorder")
	public AppOrderResponseDTO cancelOrder(@RequestParam int oid) {
        logger.info("Request received to cancel the order", oid);
		AppOrderDTOMapper dtoMapper = new AppOrderDTOMapper();
		AppOrder order = orderService.cancelOrder(oid);
        logger.info("---SUCCESSFULLY Cancelled order with ID: {}", oid);
		return dtoMapper.getAppOrderResponseDTOFromAppOrder(order);
	}
	/**
	 * Retrieves a list of placed orders for a specific customer.
	 *
	 * @param username The username of the customer whose orders are to be retrieved.
	 * @return A list of AppOrderResponseDTO objects representing the placed orders, or null if the username is null.
	 */
	@GetMapping("/allplacedorders")
	public List<AppOrderResponseDTO> getAllPlacedOrders(@RequestParam String username){
        logger.info("Request received to get All Placed Orders", username);
		if(username != null) {
			List<AppOrder> orderList = orderService.viewOrdersByCustomer(username);
			List<AppOrderResponseDTO> orderResponseList = new ArrayList<>();
			AppOrderDTOMapper dtoMapper = new AppOrderDTOMapper();
			for(AppOrder order: orderList) {
				orderResponseList.add(dtoMapper.getAppOrderResponseDTOFromAppOrder(order));
			}
            logger.info("--SUCCESSFULLY RETRIVED ALL PLACEDORDERS--");
			return orderResponseList;
		}
		return null;
	}
	
	@GetMapping("/vieworderbyid")
	public AppOrderResponseDTO viewOrderById(@RequestParam int oid) {
		AppOrderDTOMapper dtoMapper = new AppOrderDTOMapper();
		AppOrder order = orderService.viewOrderById(oid);
        logger.info("--SUCCESSFULLY RETRIVED ORDER  BY ID--",oid);
		return dtoMapper.getAppOrderResponseDTOFromAppOrder(order);
	}
}
