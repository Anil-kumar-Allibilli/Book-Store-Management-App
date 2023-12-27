package com.sprint.bspro.controller;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sprint.bspro.dto.AdminRequestDTO;
import com.sprint.bspro.dto.LoginDTO;
import com.sprint.bspro.entity.Admin;
import com.sprint.bspro.entity.ContactInfo;
import com.sprint.bspro.entity.MailStructure;
import com.sprint.bspro.repository.IBookStoreUserRepository;
import com.sprint.bspro.security.JWTUtil;
import com.sprint.bspro.service.EmailServiceImpl;
import com.sprint.bspro.service.IAdminService;
import com.sprint.bspro.service.IAppCustomerService;
import com.sprint.bspro.service.IAuthorService;
import com.sprint.bspro.service.IBookStoreUserService;

@WebMvcTest(BookStoreUserController.class)
class BookStoreUserControllerTest {

	 @Autowired
	 private MockMvc mvc;
	 
	 @MockBean
	 IBookStoreUserService bookStoreUserService;
	 
	 @MockBean
		IAdminService adminService;
	 @MockBean
		IAuthorService authorService;
	 @MockBean
		IAppCustomerService appCustomerService;
	 @MockBean
		private AuthenticationManager authenticationManager;
	 @MockBean
		private JWTUtil jwtUtil;
	 @MockBean 
		private EmailServiceImpl emailService;
	 @MockBean
		IBookStoreUserRepository bookStoreUserRepository;
	 @MockBean 
	 	private JavaMailSender javaMailSender;
	
	@Test
	void testValidateUser() throws Exception {
		
		when(bookStoreUserService.appLogin("vinay","1")).thenReturn("author");
		mvc.perform( MockMvcRequestBuilders
			      .post("/login/check")
			      .content(asJsonString(new LoginDTO("vinay", "1", "")))
			      .contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON))
		      .andExpect(MockMvcResultMatchers.jsonPath("$.role").exists())
		      .andExpect(MockMvcResultMatchers.jsonPath("$.role").value("author"));
	}
	
	@Test
	void testValidateUserName() throws Exception {
		
		when(bookStoreUserService.appCheckUser("vinay")).thenReturn("vinay");
		mvc.perform( MockMvcRequestBuilders
			      .post("/login/check/username")
			      .content(asJsonString(new LoginDTO("vinay", "1", "")))
			      .contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON))
		      .andExpect(MockMvcResultMatchers.jsonPath("$.role").exists());
	}
	
	@Test
	void testSendMail() throws Exception {
		MailStructure mail = new MailStructure("vinaysripath@gmail.com","123","otp");
		when(emailService.sendSimpleMail(mail)).thenReturn("done");
		mvc.perform( MockMvcRequestBuilders
			      .post("/login/sendmail")
			      .content(asJsonString(new MailStructure("vinaysripath@gmail.com","123","otp")))
			      .contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON))
		.equals("done");
	}
	
	@Test
	void testAddAdmin() throws Exception {
		ContactInfo contact = new ContactInfo();
		Admin admin = new Admin("ralph","1234","","",contact);
		when(adminService.createAppAdmin(admin)).thenReturn(admin);
		mvc.perform( MockMvcRequestBuilders
			      .post("/login/check/username")
			      .content(asJsonString(new Admin("ralph","1234","","",contact)))
			      .contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON))
		      .andExpect(MockMvcResultMatchers.jsonPath("$.username").exists())
		      .andExpect(MockMvcResultMatchers.jsonPath("$.username").value("ralph"));
	}
	
	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}

}
