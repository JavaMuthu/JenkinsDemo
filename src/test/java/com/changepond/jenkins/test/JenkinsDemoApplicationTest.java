/**
 * 
 */
package com.changepond.jenkins.test;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.changepond.jenkins.JenkinsDemoApplication;
import com.changepond.jenkins.model.User;
import com.changepond.jenkins.util.RestAPICommonConstants;

/**
 * @author muthukumar.m
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = JenkinsDemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class JenkinsDemoApplicationTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	private String getRootUrl() {
		return "http://localhost:" + port;
	}

	@Test
	public void getAllUsers() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + RestAPICommonConstants.REST_API_BASE_URL
				+ RestAPICommonConstants.REST_API_USER_BASE_URL + "list", HttpMethod.GET, entity, String.class);

		assertNotNull(response.getBody());
	}

	@Test
	public void testGetUserById() {
		User user = restTemplate.getForObject(getRootUrl() + RestAPICommonConstants.REST_API_BASE_URL
				+ RestAPICommonConstants.REST_API_USER_BASE_URL + "get/1", User.class);
		System.out.println(user.getEmail());
		assertNotNull(user);
	}

	@Test
	public void testCreateUser() {
		User user = new User();
		user.setEmail("admin@gmail.com");
		user.setPassword("admin");
		user.setFname("admin");
		user.setLname("admin");
		user.setCreatedBy("admin");
		user.setCreatedAt(new Date());
		user.setUpdatedBy("admin");
		user.setUpdatedAt(new Date());

		ResponseEntity<User> postResponse = restTemplate.postForEntity(getRootUrl() + RestAPICommonConstants.REST_API_BASE_URL
				+ RestAPICommonConstants.REST_API_USER_BASE_URL + "add", user, User.class);
		assertNotNull(postResponse);
		assertNotNull(postResponse.getBody());
	}
	
	

}
