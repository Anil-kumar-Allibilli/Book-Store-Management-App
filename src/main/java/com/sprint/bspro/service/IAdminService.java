package com.sprint.bspro.service;

import org.springframework.stereotype.Service;

import com.sprint.bspro.entity.Admin;
import com.sprint.bspro.exceptions.InvalidUserNameException;
@Service
public interface IAdminService {
	public Admin createAppAdmin(Admin admin);
	public Admin updateAdmin(Admin admin);
	public Admin viewAdmin(int userCode);
	public Admin viewAdminByUserName(String userName) throws InvalidUserNameException;
	public Admin updateAdminByName(Admin admin, String username) throws InvalidUserNameException;
}
