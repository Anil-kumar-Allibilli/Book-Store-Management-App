package com.sprint.bspro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.bspro.entity.Admin;
import com.sprint.bspro.entity.ContactInfo;
import com.sprint.bspro.exceptions.InvalidUserNameException;
import com.sprint.bspro.repository.IAdminRepository;
@Service
public class AdminServiceImpl implements IAdminService {
	@Autowired
	IAdminRepository adminRepository;
	
	/** Creates a new application administrator and persists it in the database.
	 * 
	 * @param admin The Admin object to be created and persisted.
	 * @return The created and persisted Admin object with the assigned user code,
       or null if the input admin object is null.
	 */
	@Override
	public Admin createAppAdmin(Admin admin) {
		if(admin != null) {
			adminRepository.save(admin);
			admin.setUserCode(adminRepository.getAdminByUsername(admin.getUsername()).getUserCode());
			return admin;
		}
		return null;
	}

	/** Updates an existing administrator's information in the database based on the provided @code Admin object.
	 * 
	 * @param admin The Admin object containing the updated information for the administrator.
	 * @return The updated Admin object with the modified information,
 *         or null if the input admin object is null or if no matching admin is found.
	 */
	
	@Override
	public Admin updateAdmin(Admin admin) {
		if(admin != null) {
			int id = admin.getUserCode();
			System.out.println("customer id : "+id);
			Admin savedAdmin = adminRepository.findById(id).get();
			if(savedAdmin != null) {
				if(admin.getContactInfo() != null) {
					ContactInfo cinfo = savedAdmin.getContactInfo();
					
					ContactInfo newInfo = admin.getContactInfo();
					if(newInfo.getCity()!= null) {
						cinfo.setCity(newInfo.getCity());
					}
					if(newInfo.getCountry()!= null) {
						cinfo.setCountry(newInfo.getCountry());
					}
					if(newInfo.getEmail()!= null) {
						cinfo.setEmail(newInfo.getEmail());
					}
					if(newInfo.getHouseAddress()!= null) {
						cinfo.setHouseAddress(newInfo.getHouseAddress());
					}
					if(newInfo.getPhone()!= 0) {
						cinfo.setPhone(newInfo.getPhone());
					}
					savedAdmin.setContactInfo(cinfo);
				}
				if(admin.getFullName()!= null) {
					savedAdmin.setFullName(admin.getFullName());
				}
				adminRepository.save(savedAdmin);
				return savedAdmin;
			}
		}
		return null;
	}
	/** Updates an existing administrator's information in the database based on the provided object and username.
	 * 
	 * @param admin object containing the updated information for the administrator.
	 * @param username The username of the admin to be updated.
	 * @return The updated object with the modified information,
            or null if the input admin object is null or if the username is not found.
	 * @throws InvalidUserNameException If the provided username is not found in the database during the update attempt.
	 */
	 
	@Override
	public Admin updateAdminByName(Admin admin, String username) throws InvalidUserNameException {
		if(admin != null) {
			Admin savedAdmin = adminRepository.getAdminByUsername(username);
			if(savedAdmin != null) {
				if(admin.getContactInfo() != null) {
					ContactInfo cinfo = savedAdmin.getContactInfo();
					System.out.println("customer country : "+cinfo.getCountry());
					
					ContactInfo newInfo = admin.getContactInfo();
					System.out.println("new Country : "+newInfo.getCountry());
					if(newInfo.getCity()!= null) {
						cinfo.setCity(newInfo.getCity());
					}
					if(newInfo.getCountry()!= null) {
						cinfo.setCountry(newInfo.getCountry());
					}
					if(newInfo.getEmail()!= null) {
						cinfo.setEmail(newInfo.getEmail());
					}
					if(newInfo.getHouseAddress()!= null) {
						cinfo.setHouseAddress(newInfo.getHouseAddress());
					}
					if(newInfo.getPhone()!= 0) {
						cinfo.setPhone(newInfo.getPhone());
					}
					savedAdmin.setContactInfo(cinfo);
				}
				if(admin.getFullName()!= null) {
					savedAdmin.setFullName(admin.getFullName());
				}
				adminRepository.save(savedAdmin);
				return savedAdmin;
			}
			else {
				throw new InvalidUserNameException("username not found", "update admin");
			}
		}
		return null;
	}
  /** Retrieves and returns an Admin information from the database based on the provided user code.
   * 
   * @param userCode The user code uniquely identifying the admin to be viewed.
   * @return The Admin object representing the administrator with the provided user code,
         or null if the user code is zero or if no matching administrator is found.
   */
	
	@Override
	public Admin viewAdmin(int userCode) {
		if(userCode != 0) {
			return adminRepository.findById(userCode).get();
		}
		return null;
	}
/** Retrieves and returns an administrator's information from the database based on the provided username.
 * 
 * @param username The username uniquely identifying the administrator to be viewed.
 * @return The object representing the administrator with the provided username.
 * @throws InvalidUserNameException If the provided username is null or if no matching administrator is found,
          indicating an invalid username during the view attempt.
 */
	@Override
	public Admin viewAdminByUserName(String username) throws InvalidUserNameException{
		if(username != null) {
			Admin admin = adminRepository.getAdminByUsername(username);
			if(admin != null) {
				return admin;
			}
			else {
				throw new InvalidUserNameException("Invalid Username: please check username","view admin");
			}
		}
		return null;
	}

}
