package com.sprint.bspro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint.bspro.entity.BookStoreUser;
@Repository
public interface IBookStoreUserRepository extends JpaRepository<BookStoreUser, Integer> {
	
	/** Retrieves a bookstore user from the data source based on the provided username.
	 * 
	 * @param username The username of the bookstore user to be retrieved.
	 * @return The BookStoreUser entity associated with the provided username, or null if no matching user is found.
	 */
	
	public BookStoreUser getBookStoreUserByUsername(String username);

}
