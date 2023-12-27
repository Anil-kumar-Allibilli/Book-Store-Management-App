package com.sprint.bspro.service;

import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;


@Service
public interface IBookStoreUserService extends UserDetailsService {
	public String appLogin(String username, String password);
	public String appCheckUser(String username);
	public Boolean appUpdatePassword(String password, String username);
}
