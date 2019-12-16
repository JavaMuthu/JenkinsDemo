/**
 * 
 */
package com.changepond.jenkins.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.changepond.jenkins.exception.ResourceNotFoundException;
import com.changepond.jenkins.model.User;
import com.changepond.jenkins.service.UserService;
import com.changepond.jenkins.util.RestAPICommonConstants;

/**
 * @author muthukumar.m
 *
 */
@RestController
@RequestMapping(RestAPICommonConstants.REST_API_BASE_URL)
public class UserController {

	private static final Logger logger = LogManager.getLogger(UserController.class);

	@Autowired
	UserService userService;
	
	@GetMapping(RestAPICommonConstants.REST_API_USER_BASE_URL + "sayHello")
	public String sayHello() {
		logger.debug(
				"Hello and Welcome to the Jenkins Demo application. You can create a new User by making a POST request to /api/user endpoint.");
		return "Hello and Welcome to the Jenkins Demo application. You can create a new User by making a POST request to /api/user endpoint.";
	}

	/**
	 * List all the user information from the database
	 * 
	 * @return
	 */
	@GetMapping(RestAPICommonConstants.REST_API_USER_BASE_URL + "list")
	public List<User> listAll() {
		logger.info("List all the user information {}");
		return userService.listAll();
	}

	/*
	 * public ResponseEntity<List<User>> listAll() {
	 * logger.info("List all the user information {}"); List<User> list =
	 * userService.listAll(); if (list.isEmpty()) { return new
	 * ResponseEntity<>(list, HttpStatus.NO_CONTENT); } return new
	 * ResponseEntity<List<User>>(list, HttpStatus.OK); }
	 */

	/**
	 * Create new user information
	 * 
	 * @param user
	 * @return
	 */
	@PostMapping(RestAPICommonConstants.REST_API_USER_BASE_URL + "add")
	public User createUse(@Valid @RequestBody User user) {
		return userService.addOrUpdate(user);
	}

	/**
	 * Get user information based on user id
	 * 
	 * @param userid
	 * @return
	 */
	@GetMapping(RestAPICommonConstants.REST_API_USER_BASE_URL + "get/{id}")
	public User getUserById(@PathVariable(value = "id") Long userid) {
		logger.info("Fetching User with id {}", userid);
		return userService.getById(userid).orElseThrow(() -> new ResourceNotFoundException("User", "id", userid));
	}

	/**
	 * Update user information based on user id
	 * 
	 * @param userid
	 * @param userDetails
	 * @return
	 */
	@PutMapping(RestAPICommonConstants.REST_API_USER_BASE_URL + "update/{id}")
	public User updateUser(@PathVariable(value = "id") Long userid, @Valid @RequestBody User userDetails) {
		logger.info("Fetching User with id {}", userid);
		User user = userService.getById(userid).orElseThrow(() -> new ResourceNotFoundException("User", "id", userid));

		user.setFname(userDetails.getFname());
		user.setLname(userDetails.getLname());
		user.setCreatedBy("Muthu");
		user.setCreatedAt(new Date());
		user.setUpdatedBy("Muthu");
		user.setUpdatedAt(new Date());

		User updatedUser = userService.addOrUpdate(user);
		return updatedUser;
	}

	/**
	 * Remove user based on user id
	 * 
	 * @param userid
	 * @return
	 */
	@DeleteMapping(RestAPICommonConstants.REST_API_USER_BASE_URL + "delete/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long userid) {
		logger.info("Fetching User with id {}", userid);
		User user = userService.getById(userid).orElseThrow(() -> new ResourceNotFoundException("User", "id", userid));

		userService.delete(user);

		return ResponseEntity.ok().build();
	}

	/**
	 * Remove all the user from the database using /deleteAll end points
	 * 
	 * @return
	 */
	@DeleteMapping(RestAPICommonConstants.REST_API_USER_BASE_URL + "deleteAll")
	public ResponseEntity<User> deleteAll() {
		logger.info("Delete all user from the database");
		userService.deleteAll();
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}
}
