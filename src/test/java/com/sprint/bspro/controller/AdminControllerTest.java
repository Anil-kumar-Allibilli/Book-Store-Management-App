package com.sprint.bspro.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.sprint.bspro.dto.AdminRequestDTO;
import com.sprint.bspro.dto.AdminResponseDTO;
import com.sprint.bspro.entity.Admin;
import com.sprint.bspro.exceptions.InvalidUserNameException;
import com.sprint.bspro.service.AdminServiceImpl;
import com.sprint.bspro.service.IAdminService;
import com.sprint.bspro.service.IAppOrderService;
import com.sprint.bspro.service.IAuthorService;
import com.sprint.bspro.service.IBookService;
import com.sprint.bspro.service.IReviewsService;
import com.sprint.bspro.util.AdminDTOMapper;


@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class AdminControllerTest {
	
	@Autowired
	private MockMvc mockmvc;
	
	@MockBean
	IBookService bookService;
	
	@MockBean
	IAuthorService authorService;
	
	@MockBean
	IAppOrderService orderService;
	
	@MockBean
	IReviewsService reviewService;
	
	@MockBean
	private AdminServiceImpl adminService;
	
	@Autowired
	AdminDTOMapper adminDto;
	
	private AdminRequestDTO saveInput;
	
	@BeforeEach
	public void setup() {
		saveInput=new AdminRequestDTO(1,"Anil","abc","Dev","AnilKumar","BMl","Banglore","India","anilkumarj@gmail",569874);
	}
	
	@Test
	public void testAddAdmin() throws Exception {
		Admin a=adminDto.getAdminFromAdminDTO(saveInput);
		Mockito.when(adminService.createAppAdmin(a)).thenReturn(a);
		mockmvc.perform(
				MockMvcRequestBuilders.post("/admin/createadmin").
				contentType(MediaType.APPLICATION_JSON).
				content("{\r\n"
						+ "    \"userCode\": 1,\r\n"
						+ "    \"username\": \"Anil\",\r\n"
						+ "    \"password\": \"abc\",\r\n"
						+ "    \"userrole\": \"Dev\",\r\n"
						+ "     \"fullName\":\"AnilKumar\"\r\n"
						+"     \"houseAddress\":\"BMl\"\r\n "
						+"      \"city\":\"Banglore\"\r\n"
						+"      \"country\":\"India\"\r\n"
						+"      \"email\":\"anilkumarj@gmail.com\"\r\n"
						+"      \"phone\":569874,\r\n"
						+ "\r\n"
						+ "}"));
		
				
		
	}

	
}
