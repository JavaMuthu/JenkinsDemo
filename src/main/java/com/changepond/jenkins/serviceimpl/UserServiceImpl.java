/**
 * 
 */
package com.changepond.jenkins.serviceimpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.changepond.jenkins.model.User;
import com.changepond.jenkins.repository.UserRepository;
import com.changepond.jenkins.service.UserService;

/**
 * @author muthukumar.m
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> listAll() {
		return userRepository.findAll();
	}

	@Override
	public User addOrUpdate(User user) {
		user.setCreatedBy("admin");
		user.setCreatedAt(new Date());
		user.setUpdatedBy("admin");
		user.setUpdatedAt(new Date());
		return userRepository.save(user);
	}

	@Override
	public Optional<User> getById(Long id) {
		return userRepository.findById(id);
	}

	@Override
	public void delete(User user) {
		userRepository.delete(user);
	}

	@Override
	public void deleteAll() {
		userRepository.deleteAll();
	}

}
