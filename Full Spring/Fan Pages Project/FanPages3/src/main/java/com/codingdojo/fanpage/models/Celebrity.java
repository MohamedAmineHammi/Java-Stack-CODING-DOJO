package com.codingdojo.fanpage.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "celebrities")
public class Celebrity {

	// Member Variables
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "Name is required!")
	@Size(min = 3, message = "Celebrity Name must be at Least 03 characters")
	private String name;

	@NotEmpty(message = "Details is required!")
	@Size(min = 10, message = "Celebrity Details must be at Least 10 characters")
	private String details;

	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;

	
	//M:1
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user")

	private User user;
	
	// M:M
		@ManyToMany(fetch = FetchType.LAZY)
		@JoinTable(name = "celeb_followers", joinColumns = @JoinColumn(name = "celebrity_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
		private List<User> followers;

	public List<User> getFollowers() {
			return followers;
		}

		public void setFollowers(List<User> followers) {
			this.followers = followers;
		}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Celebrity() {
	}

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	// Other Getters And Setters

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

}
