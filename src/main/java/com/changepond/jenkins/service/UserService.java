/**
 * 
 */
package com.changepond.jenkins.service;

import java.util.List;
import java.util.Optional;

import com.changepond.jenkins.model.User;

/**
 * @author muthukumar.m
 *
 */
public interface UserService {

	public List<User> listAll();

	public User addOrUpdate(User user);

	public Optional<User> getById(Long id);
	
	public void delete(User user);
	
	public void deleteAll();

}
