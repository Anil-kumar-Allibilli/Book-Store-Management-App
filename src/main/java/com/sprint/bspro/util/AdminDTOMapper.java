package com.sprint.bspro.util;

import org.springframework.stereotype.Component;

import com.sprint.bspro.dto.AdminRequestDTO;
import com.sprint.bspro.dto.AdminResponseDTO;
import com.sprint.bspro.entity.Admin;
import com.sprint.bspro.entity.ContactInfo;
@Component
public class AdminDTOMapper {
	
	/** This method is used to convert an AdminRequestDTO object to an Admin object. 
	 * 
	 * @param reqDTO The AdminRequestDTO object containing the admin information
	 * @return An Admin object with the information from the AdminRequestDTO object.
	 */
	public Admin getAdminFromAdminDTO(AdminRequestDTO reqDTO) {
		Admin ac = new Admin();
		ContactInfo contact = new ContactInfo();
		contact.setCity(reqDTO.getCity());
		contact.setCountry(reqDTO.getCountry());
		contact.setEmail(reqDTO.getEmail());
		contact.setHouseAddress(reqDTO.getHouseAddress());
		contact.setPhone(reqDTO.getPhone());
		ac.setUserCode(reqDTO.getUserCode());
		ac.setFullName(reqDTO.getFullName());
		ac.setContactInfo(contact);
		ac.setPassword(reqDTO.getPassword());
		ac.setUsername(reqDTO.getUsername());
		ac.setUserrole(reqDTO.getUserrole());
		return ac;
	}
	/** This method is used to convert an Admin object to an AdminResponseDTO object. 
	 * 
	 * @param admin The Admin object containing the admin information
	 * @return An AdminResponseDTO object with the information from the Admin object. 
	 */
	public AdminResponseDTO getAdminDTOFromAdmin(Admin admin) {
		AdminResponseDTO adto = new AdminResponseDTO();
		ContactInfo c = admin.getContactInfo();
		adto.setCity(c.getCity());
		adto.setCountry(c.getCountry());
		adto.setEmail(c.getEmail());
		adto.setHouseAddress(c.getHouseAddress());
		adto.setPhone(c.getPhone());
		adto.setFullName(admin.getFullName());
		adto.setUserCode(admin.getUserCode());
		adto.setUsername(admin.getUsername());
		adto.setUserrole(admin.getUserrole());
		adto.setPassword(admin.getPassword());
		return adto;
	}
}
