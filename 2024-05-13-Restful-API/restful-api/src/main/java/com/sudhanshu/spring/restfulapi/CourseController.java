package com.sudhanshu.spring.restfulapi;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

	@RequestMapping(path = "/courses",method = RequestMethod.GET)
	public static List<Courses> getAllCourses() {
		return Arrays.asList(
				new Courses(1, "Java", "GFG"), 
				new Courses(2, "Spring", "Udemy"),
				new Courses(3, "SDE", "Online")
				);
	}
	
	@GetMapping("/java-courses")
	public static List<Courses> getAllJavaCourses() {
		return Arrays.asList(
				new Courses(1, "Java", "GFG"), 
				new Courses(2, "Spring", "Udemy")
				);
	}
}
