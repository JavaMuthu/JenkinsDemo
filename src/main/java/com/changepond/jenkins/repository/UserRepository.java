/**
 * 
 */
package com.changepond.jenkins.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.changepond.jenkins.model.User;

/**
 * @author muthukumar.m
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
