/**
 * 
 */
package com.changepond.jenkins.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author muthukumar.m
 *
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "createdBy", "updatedAt", "updatedBy" }, allowGetters = true)
public abstract class AuditModel implements Serializable {
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", nullable = false, updatable = false)
	@CreatedDate
	private Date createdAt;
	
	@Column(name = "createdBy", nullable = false, updatable = false)
	@CreatedBy
	private String createdBy;
	

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at", nullable = false)
	@LastModifiedDate
	private Date updatedAt;
	
	@Column(name = "updatedBy", nullable = true, updatable = false)
	@LastModifiedBy
	private String updatedBy;
	

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	
}