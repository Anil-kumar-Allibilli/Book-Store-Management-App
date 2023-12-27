package com.sprint.bspro.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.sprint.bspro.entity.Admin;
import com.sprint.bspro.entity.Book;
import com.sprint.bspro.entity.ContactInfo;
import com.sprint.bspro.exceptions.InvalidUserNameException;
import com.sprint.bspro.repository.IAdminRepository;

@SpringBootTest
class AdminServiceImplTest {
	
	@MockBean
	IAdminRepository adminRepository;
	
	@Autowired
	AdminServiceImpl adminService;
	
	
	@Test
	public void testViewAdminByUserName() throws InvalidUserNameException {
		String userName="Harry";
		Admin mockAdmin=new Admin();
		mockAdmin.setUsername(userName);
		
		
		when(adminRepository.getAdminByUsername(userName)).thenReturn(mockAdmin);
		 
        Admin result = adminService.viewAdminByUserName(userName);
 
        assertNotNull(result);
        assertEquals(userName, result.getUsername());
		
	}
	
	@Test
	public void testCreateAdmin() {
		Admin admin=new Admin();
		admin.setUsername("mockAdmin");
		
		Admin savedAdmin=new Admin();
		savedAdmin.setUsername("mockAdmin");
		savedAdmin.setUserCode(5);
		
		when(adminRepository.save(admin)).thenReturn(savedAdmin);
		when(adminRepository.getAdminByUsername("mockAdmin")).thenReturn(savedAdmin);
		
		Admin result=adminService.createAppAdmin(admin);
		
		assertNotNull(result);
		assertEquals("mockAdmin", result.getUsername());
		assertEquals(5,result.getUserCode());
		
	}
	@Test
	public void testCreateAppAdminWithNullInput() {
		Admin result=adminService.createAppAdmin(null);
		
		verify(adminRepository, never()).save(any());
		verify(adminRepository, never()).getAdminByUsername(any());
		
		assertNull(result);

	}
	@Test
    public void testUpdateAdminByName() throws InvalidUserNameException {
		
        String username = "mockAdmin";
        Admin adminToUpdate = new Admin();
        adminToUpdate.setUsername(username);
 
        ContactInfo newContactInfo = new ContactInfo();
        newContactInfo.setCity("NewCity");
        newContactInfo.setCountry("NewCountry");
        newContactInfo.setEmail("new@example.com");
        newContactInfo.setHouseAddress("NewStreet");
        newContactInfo.setPhone(123456789);
 
        adminToUpdate.setContactInfo(newContactInfo);
        adminToUpdate.setFullName("NewFullName");
 
        Admin savedAdmin = new Admin();
        savedAdmin.setUsername(username);
        savedAdmin.setContactInfo(new ContactInfo());
        savedAdmin.setFullName("OldFullName");
 
        
        when(adminRepository.getAdminByUsername(username)).thenReturn(savedAdmin);
        when(adminRepository.save(savedAdmin)).thenReturn(savedAdmin);
 
        Admin result = adminService.updateAdminByName(adminToUpdate, username);
 
        assertNotNull(result);
        assertEquals(username, result.getUsername());
        assertEquals("NewFullName", result.getFullName());
        assertEquals("NewCity", result.getContactInfo().getCity());
        assertEquals("NewCountry", result.getContactInfo().getCountry());
        assertEquals("new@example.com", result.getContactInfo().getEmail());
        assertEquals("NewStreet", result.getContactInfo().getHouseAddress());
        assertEquals(123456789, result.getContactInfo().getPhone());
 
     }
	

	@Test
	public void testUpdateAdminByNameWithInvalidUsername() {
		String invalidUsername="invalidAdmin";
		when(adminRepository.getAdminByUsername(invalidUsername)).thenReturn(null);
		
		assertThrows(InvalidUserNameException.class,()->{
			adminService.updateAdminByName(new Admin(),invalidUsername);
		});
		
	}
 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
