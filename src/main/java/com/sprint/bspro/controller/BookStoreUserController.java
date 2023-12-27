package com.sprint.bspro.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprint.bspro.dto.AdminRequestDTO;
import com.sprint.bspro.dto.AdminResponseDTO;
import com.sprint.bspro.dto.AppCustomerRequestDTO;
import com.sprint.bspro.dto.AppCustomerResponseDTO;
import com.sprint.bspro.dto.AuthorRequestDTO;
import com.sprint.bspro.dto.AuthorResponseDTO;
import com.sprint.bspro.dto.LoginDTO;
import com.sprint.bspro.dto.ResetPasswordDTO;
import com.sprint.bspro.entity.Admin;
import com.sprint.bspro.entity.AppCustomer;
import com.sprint.bspro.entity.Author;
import com.sprint.bspro.entity.MailStructure;
import com.sprint.bspro.security.JWTUtil;
import com.sprint.bspro.service.EmailServiceImpl;
import com.sprint.bspro.service.IAdminService;
import com.sprint.bspro.service.IAppCustomerService;
import com.sprint.bspro.service.IAuthorService;
import com.sprint.bspro.service.IBookStoreUserService;
import com.sprint.bspro.util.AdminDTOMapper;
import com.sprint.bspro.util.AppCustomerDTOMapper;
import com.sprint.bspro.util.AuthorDTOMapper;
@CrossOrigin
@RestController
@RequestMapping("/login")
public class BookStoreUserController {
	static int otp;
	@Autowired
	IBookStoreUserService bookStoreUserService;
	@Autowired
	IAdminService adminService;
	@Autowired
	IAuthorService authorService;
	@Autowired
	IAppCustomerService appCustomerService;
	Logger logger = LoggerFactory.getLogger(AuthorController.class);

	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JWTUtil jwtUtil;
	
	@Autowired 
	private EmailServiceImpl emailService;
	
	
	/** * Validates a user's login credentials.
	 * 
	 * @param login The LoginDTO containing the user's login information.
	 * @return The LoginDTO with the user's role set after validation.
	 */
	@PostMapping("/check")
	public LoginDTO validateUser(@Valid @RequestBody LoginDTO login) throws Exception {
		String s =  bookStoreUserService.appLogin(login.getUsername(), login.getPassword());
		
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword()));
			
		} catch (Exception e) {
			throw new Exception("Bad credentials ");
		}

		UserDetails userDetails =  bookStoreUserService.loadUserByUsername(login.getUsername());
		
		String token = jwtUtil.generateToken(userDetails);
		
		boolean isValid = token!=null?true:false;
		login.setToken(token);
		login.setValid(isValid);
		login.setRole(s);
        logger.info("---SUCCESSFULLY VALIDATED USER---");
		return login;
	}
	/** * Validates a user's username.
	 * 
	 * @param login The LoginDTO containing the user's login information.
	 * @return The LoginDTO with the username validation result and email set if the username exists.
	 */
	
	@PostMapping("/check/username")
	public LoginDTO validateUserName(@Valid @RequestBody LoginDTO login) {
		String s =  bookStoreUserService.appCheckUser(login.getUsername());
		if(s!=null) {
			login.setIsUsername(true);
			login.setEmail(s);
		}
        logger.info("VALIDAED SUCCESSFULLY",login);
		return login;
	}
	/** * Sends an email using the provided MailStructure object.
	 * 
	 * @param details The MailStructure object containing the email details.
	 * @return The status of the email sending operation.
	 */
	
	@PostMapping("/sendmail")
    public String sendMail(@Valid @RequestBody MailStructure details)
    {
		logger.info("Request received to send Email", details);
		otp = (int)(Math.random()*1000000);
		details.setSubject("OTP to set password for BOOK STORE APP");
		details.setMsgBody("Please Enter this OTP to change your Password "+otp);
        String status
            = emailService.sendSimpleMail(details);
        logger.info("----SUCCESSFULLY sent Email--- {}");
        return status;
    }
	/** * Resets the password for a user based on the provided ResetPasswordDTO.
	 * 
	 * @param resetPassword The ResetPasswordDTO containing the user's reset password information.
	 * @return True if the OTP (One-Time Password) matches and the password is successfully updated, false otherwise.
	 */
	@PutMapping("/changepassword")
	public Boolean resetPassword(@Valid @RequestBody ResetPasswordDTO resetPassword ) {
		String otpstr = otp + "";
		if(resetPassword.getOtp().equals(otpstr)) {
			boolean check = bookStoreUserService.appUpdatePassword(resetPassword.getPassword(), resetPassword.getUsername());
			otp = (int)(Math.random()*1000000);
            logger.info("------PASSWORD CHANGED SUCCESSFULL-----");
			return check;
		}
		otp = (int)(Math.random()*1000000);
        logger.warn("---YOU HAVE ENTERED AN INVALID OTP.---");
		return false;
	}
	
	/** * This method adds a new admin to the Book Store App's database based on the provided AdminRequestDTO object.
	* @param adminDTO A valid AdminRequestDTO object containing the details of the admin to be added.
	* * @return An AdminResponseDTO object representing the added admin, or null if the adminDTO is null.
	*/
	@PostMapping("/createadmin")
	public AdminResponseDTO addAdmin(@Valid @RequestBody AdminRequestDTO adminDTO) {
	    logger.info("Request received to ADD Admin", adminDTO);
		if(adminDTO != null) {
			AdminDTOMapper dtoConverter = new AdminDTOMapper();
			Admin admin = dtoConverter.getAdminFromAdminDTO(adminDTO);
			Admin savedAdmin = adminService.createAppAdmin(admin);
	        logger.info("---SUCCESSFULLU CREATED ADMIN---");
			return dtoConverter.getAdminDTOFromAdmin(savedAdmin);
		}
		return null;
	}
	
	/** * Adds a new author based on the provided AuthorRequestDTO.
	 * 
	 * @param authorDTO The AuthorRequestDTO containing the details of the author to be added.
	 * @return The AuthorResponseDTO representing the added author.
	 */
	@PostMapping("/createauthor")
	public AuthorResponseDTO addAuthor(@Valid @RequestBody AuthorRequestDTO authorDTO) {
	    logger.info("Request received to ADD Author", authorDTO);
		if(authorDTO != null) {
			AuthorDTOMapper dtoConverter = new AuthorDTOMapper();
			
			Author author = dtoConverter.getAuthorFromAuthorDTO(authorDTO);
			Author savedAuthor = authorService.createAppAuthor(author);
	        logger.info("---SUCCESSFULLY ADDED AUTHOR---");
			return dtoConverter.getAuthorDTOFromAuthor(savedAuthor);
		}
		return null;
	}
	
	/** * Adds a new customer based on the provided AppCustomerRequestDTO.
	 * 
	 * @param customerDTO The AppCustomerRequestDTO containing the customer information.
	 * @return The AppCustomerResponseDTO representing the added customer, or null if the customerDTO is null.
	 */
	@PostMapping("/addcustomer")
	public AppCustomerResponseDTO addCustomer(@Valid @RequestBody AppCustomerRequestDTO customerDTO) {
        logger.info("Request Received to Add Customer", customerDTO);
		if(customerDTO != null) {
			AppCustomerDTOMapper dtoConverter = new AppCustomerDTOMapper();
			
			AppCustomer customer = dtoConverter.getAppCustomerFromAppCustomerDTO(customerDTO);
			AppCustomer savedCustomer = appCustomerService.createAppCustomer(customer);
            logger.info("SUCCESSFULLUY ADDED CUSTOMER : {}");
			return dtoConverter.getAppCustomerDTOFromAppCustomer(savedCustomer);
		}
		return null;
	}
}
