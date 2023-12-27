package com.sprint.bspro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint.bspro.entity.Author;
@Repository
public interface IAuthorRepository extends JpaRepository<Author, Integer> {

	/** Retrieves an author from the data source based on the provided username.
	 * 
	 * @param username The username of the author to be retrieved.
	 * @return The Author object associated with the provided username, or null if no matching author is found.
	 */
	
	public Author getAuthorByUsername(String username);
	public List<Author> findByStatus(String status);
}
