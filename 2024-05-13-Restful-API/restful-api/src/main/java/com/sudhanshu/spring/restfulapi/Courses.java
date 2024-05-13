package com.sudhanshu.spring.restfulapi;

public class Courses {
	private int id;
	private String courseName;
	private String courseLearningPlatform;

	public Courses(int id, String courseName, String courseLearningPlatform) {
		super();
		this.id = id;
		this.courseName = courseName;
		this.courseLearningPlatform = courseLearningPlatform;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseLearningPlatform() {
		return courseLearningPlatform;
	}

	public void setCourseLearningPlatform(String courseLearningPlatform) {
		this.courseLearningPlatform = courseLearningPlatform;
	}

	@Override
	public String toString() {
		return "Courses [id=" + id + ", courseName=" + courseName + ", courseLearningPlatform=" + courseLearningPlatform
				+ "]";
	}

}
