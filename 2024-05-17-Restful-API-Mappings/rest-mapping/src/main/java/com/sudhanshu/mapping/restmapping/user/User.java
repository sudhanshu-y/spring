package com.sudhanshu.mapping.restmapping.user;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class User {
	private int id;
	
	@Size(min = 2, message = "Name should have at least 2 characters")
	@JsonProperty("Name")
	private String name;
	
	@Past(message = "Birthday should be in past")
	@JsonProperty("Birth_Date")
	private LocalDateTime birthDate;

	public User(int id, String name, LocalDateTime birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDateTime birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}

}
