/**
 * 
 */
package com.changepond.jenkins.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


/**
 * @author muthukumar.m
 *
 */
@Entity
@Table(name = "tbl_user")
public class User extends AuditModel{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "username", nullable = false, unique = true)
	@Email(message = "Please provide a valid e-mail")
	@NotEmpty(message = "Please provide an e-mail")
	private String email;
	
	private String password;
	
	@Column(name = "firstname", nullable = false)
	@NotEmpty(message = "Please provide your first name")
	private String fname;
	
	@Column(name = "lastname")
	private String lname;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
}
