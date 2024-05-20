package com.sudhanshu.SpringJPAHibernate.course;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "Course_Details")
public class CourseDetails {
	
	@Id
	private int id;
	
	@Column(name = "name") // not needed when object name and column name are same
	private String name;
	
	
	private String author;

	// default constructor is necessary 
	public CourseDetails() {
		super();
	}
	
	public CourseDetails(int id, String name, String author) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", author=" + author + "]";
	}

}
