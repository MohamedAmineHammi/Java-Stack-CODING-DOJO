package com.codingdojo.teammanager.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "teams")
public class Team {
// Member variables: 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty(message = "Team name is required!.")
	@Size(min = 3, max = 25, message = "Team name should be between 3 and 25 characters!.")
	private String name;
	@NotEmpty(message = "Team city is required!.")
	@Size(min = 3, max = 25, message = "Team city should be between 3 and 25 characters!.")
	private String city;
// datestamp
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;
// realtional 

//Team vs Mascot : OneToOne
	@OneToOne(mappedBy = "team", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Mascot mascot;
//Team vs Players : OneToMany
	@OneToMany(mappedBy = "team", fetch = FetchType.LAZY)
	private List<Player> players;
//Team vs Coaches : OneToMany
	@OneToMany(mappedBy = "team", fetch = FetchType.LAZY)
	private List<Coache> coaches;
//Team vs fans : ManyToMany
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "teams_fans", 
	joinColumns = @JoinColumn(name = "team_id"), 
	inverseJoinColumns = @JoinColumn(name = "fan_id"))
	private List<Fan> fans;

//zero-args constructor
	public Team() {
	}

// persistent
	@PrePersist
	public void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	public void onUpdate() {
		this.updatedAt = new Date();
	}

// Getters and setters

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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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

	public Mascot getMascot() {
		return mascot;
	}

	public void setMascot(Mascot mascot) {
		this.mascot = mascot;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public List<Coache> getCoaches() {
		return coaches;
	}

	public void setCoaches(List<Coache> coaches) {
		this.coaches = coaches;
	}

	public List<Fan> getFans() {
		return fans;
	}

	public void setFans(List<Fan> fans) {
		this.fans = fans;
	}

}
