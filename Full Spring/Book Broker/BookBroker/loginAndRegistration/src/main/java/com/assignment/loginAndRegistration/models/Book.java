package com.assignment.loginAndRegistration.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="books")
public class Book {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty(message="Title is required!")
    @Size(min = 3, max = 100, message="Title must be between 3 and 100 characters")
    private String title;
    
    @NotEmpty(message="Author is required!")
    @Size(min = 3, max = 100, message="Author must be between 3 and 100 characters")
    private String author;
    
    @NotNull
//    @Min(value=10, message="Thoughts must be at least 10 characters")
    private String thought;
    
    
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;
    
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="borrower_id")
	private User borrower;
    
    public Book() {
    }
    
    public Book(String title, String author, String thought, User user) {
        this.title = title;
        this.author = author;
        this.thought = thought;
        this.user = user;
    }
    
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    

	public Long getId() {
		return id;
	}
	

	public void setId(Long id) {
		this.id = id;
	}
	

	public String getTitle() {
		return title;
	}
	

	public void setTitle(String title) {
		this.title = title;
	}
	

	public String getAuthor() {
		return author;
	}
	

	public void setAuthor(String author) {
		this.author = author;
	}
	

	public String getThought() {
		return thought;
	}
	

	public void setThought(String thought) {
		this.thought = thought;
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
	

	public User getUser() {
		return user;
	}
	

	public void setUser(User user) {
		this.user = user;
	}

	public User getBorrower() {
		return borrower;
	}

	public void setBorrower(User borrower) {
		this.borrower = borrower;
	}


	
	
    
	
}