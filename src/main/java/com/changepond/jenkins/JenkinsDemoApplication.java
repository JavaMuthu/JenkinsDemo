/**
 * 
 */
package com.changepond.jenkins;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author muthukumar.m
 *
 */
@SpringBootApplication
//@EnableEncryptableProperties
@EnableJpaAuditing
public class JenkinsDemoApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(JenkinsDemoApplication.class, args);
	}

}
