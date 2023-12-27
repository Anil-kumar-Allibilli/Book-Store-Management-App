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

import com.sprint.bspro.dto.AdminRequestDTO;
import com.sprint.bspro.dto.AdminResponseDTO;
import com.sprint.bspro.dto.AppCustomerRequestDTO;
import com.sprint.bspro.dto.AppCustomerResponseDTO;
import com.sprint.bspro.entity.Admin;
import com.sprint.bspro.entity.AppCustomer;
import com.sprint.bspro.service.AppCustomerServiceImpl;
import com.sprint.bspro.util.AppCustomerDTOMapper;

@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class CustomerControllerTest {
	
	@Autowired
	private MockMvc mockmvc;
	
	@MockBean
	private AppCustomerServiceImpl customerService;
	
	@Autowired
	AppCustomerDTOMapper customerDto;
	
	private AppCustomerRequestDTO saveInput;
	private AppCustomerResponseDTO saveOutput;
	
	@BeforeEach
	public void setup() {
		saveInput=new AppCustomerRequestDTO(1,"Anil","abc","Dev","AnilKumar","BMl","Banglore","India","anilkumarj@gmail",569874);
		saveOutput=new AppCustomerResponseDTO(1,"Anil","abc","Dev","AnilKumar","BMl","Banglore","India","anilkumarj@gmail",569874);
	}


	@Test
	public void testAddCustomer() throws Exception{
		AppCustomer a=customerDto.getAppCustomerFromAppCustomerDTO(saveInput);
		Mockito.when(customerService.createAppCustomer(a)).thenReturn(a);
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
