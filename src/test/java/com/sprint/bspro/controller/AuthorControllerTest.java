package com.sprint.bspro.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.sprint.bspro.dto.AuthorRequestDTO;
import com.sprint.bspro.dto.AuthorResponseDTO;
import com.sprint.bspro.entity.Admin;
import com.sprint.bspro.entity.Author;
import com.sprint.bspro.service.AuthorServiceImpl;
import com.sprint.bspro.util.AuthorDTOMapper;

@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class AuthorControllerTest {
	
	@Autowired
	private MockMvc mockmvc;
	
	@MockBean
	private AuthorServiceImpl authorService;
	
	@Autowired
	AuthorDTOMapper authorDto;
	
	private AuthorRequestDTO saveInput;
	private AuthorRequestDTO saveOutput;
	
	@BeforeEach
	public void setup() {
		saveInput=new AuthorRequestDTO(1,"Anil","abc","Dev","AnilKumar","BMl","Banglore","India","anilkumarj@gmail",569874,"Andhra","Telugu");
		saveOutput=new AuthorRequestDTO(1,"Anil","abc","Dev","AnilKumar","BMl","Banglore","India","anilkumarj@gmail",569874,"Andhra","Telugu");
	}

	@Test
	public void testAddAuthor() throws Exception {
					Author a=authorDto.getAuthorFromAuthorDTO(saveInput);
			Mockito.when(authorService.createAppAuthor(a)).thenReturn(a);
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
							+"      \"region\":\"Andhra\"\r\n"
							+"       \"nativeLanguage\":\"Telugu\"\r\n"
							+ "\r\n"
							+ "}"));
			
	}
	
}
