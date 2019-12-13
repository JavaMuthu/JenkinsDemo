/**
 * 
 */
package com.changepond.jenkins.serviceimpl;

import org.springframework.stereotype.Service;

/**
 * @author muthukumar.m
 *
 */
@Service
public class IndexService {

	public String welcomeMessage() {
		return "Hello Mock";
	}
}
