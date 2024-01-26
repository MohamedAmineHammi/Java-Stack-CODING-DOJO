package com.emine.drivinglicence.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="persons")
public class Person {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message="Fisrt Name must be not null")
	@Size(min=3,max=20)
	private String firstName;
	
	@NotNull(message="Fisrt Name must be not null")
	@Size(min=3,max=20)
	private String lastName;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	// person can have one license (set our relationship in the Person model)
	@OneToOne(mappedBy="person",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private License license;

	// zero arguments constructor
	public Person() {}


	// getters & setters
	
	public License getLicense() {
		return license;
	}


	public void setLicense(License license) {
		this.license = license;
	}


	@PrePersist
	private void Oncreate() {
		this.createdAt=new Date();
	}
	
	@PreUpdate
	private void OnUpdate() {
		this.updatedAt=new Date();
	}
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


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
	
	
	
	
	
	

}
