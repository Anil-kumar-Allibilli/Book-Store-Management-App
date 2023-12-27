package com.sprint.bspro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint.bspro.entity.Admin;
@Repository
public interface IAdminRepository extends JpaRepository<Admin, Integer> {
	
	/**
	 * 
	 * @param username The username of the administrator to be retrieved.
	 * @return username
	 */
	public Admin getAdminByUsername(String username);
}
