package com.sprint.bspro.util;

import org.springframework.stereotype.Component;

import com.sprint.bspro.dto.AuthorRequestDTO;
import com.sprint.bspro.dto.AuthorResponseDTO;
import com.sprint.bspro.entity.Author;
import com.sprint.bspro.entity.ContactInfo;
@Component
public class AuthorDTOMapper {
	/** This method is used to convert an AuthorRequestDTO object to an Author object.
	 * 
	 * @param reqDTO The AuthorRequestDTO object containing the author information.
	 * @return An Author object with the information from the AuthorRequestDTO object
	 */
	public Author getAuthorFromAuthorDTO(AuthorRequestDTO reqDTO) {
		Author ac = new Author();
		ContactInfo contact = new ContactInfo();
		contact.setCity(reqDTO.getCity());
		contact.setCountry(reqDTO.getCountry());
		contact.setEmail(reqDTO.getEmail());
		contact.setHouseAddress(reqDTO.getHouseAddress());
		contact.setPhone(reqDTO.getPhone());
		ac.setUserCode(reqDTO.getUserCode());
		ac.setName(reqDTO.getName());
		ac.setContactInfo(contact);
		ac.setPassword(reqDTO.getPassword());
		ac.setUsername(reqDTO.getUsername());
		ac.setUserrole(reqDTO.getUserrole());
		ac.setNativeLanguage(reqDTO.getNativeLanguage());
		ac.setRegion(reqDTO.getRegion());
		ac.setStatus(reqDTO.getStatus());
		return ac;
	}
	/** This method is used to convert an Author object to an AuthorResponseDTO object.
	 * 
	 * @param author The Author object containing the author information.
	 * @return An AuthorResponseDTO object with the information from the Author object.
	 */
	public AuthorResponseDTO getAuthorDTOFromAuthor(Author author) {
		AuthorResponseDTO adto = new AuthorResponseDTO();
		ContactInfo c = author.getContactInfo();
		adto.setCity(c.getCity());
		adto.setCountry(c.getCountry());
		adto.setEmail(c.getEmail());
		adto.setHouseAddress(c.getHouseAddress());
		adto.setPhone(c.getPhone());
		adto.setName(author.getName());
		adto.setUserCode(author.getUserCode());
		adto.setUsername(author.getUsername());
		adto.setUserrole(author.getUserrole());
		adto.setPassword(author.getPassword());
		adto.setNativeLanguage(author.getNativeLanguage());
		adto.setRegion(author.getRegion());
		adto.setStatus(author.getStatus());
		return adto;
	}
}
