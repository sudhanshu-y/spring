package com.sudhanshu.SpringJPAHibernate.course.springjdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sudhanshu.SpringJPAHibernate.course.CourseDetails;

@Component
public class CourseJPACommandLineRunner implements CommandLineRunner {

	@Autowired
	private CourseSpringJPAepository courseSpringJPAepository;

	@Override
	public void run(String... args) throws Exception {

		courseSpringJPAepository.insert(new CourseDetails(2, "Microservice", "Udemy"));
		courseSpringJPAepository.insert(new CourseDetails(3, "JavaScript", "Udemy"));
		courseSpringJPAepository.insert(new CourseDetails(4, "React", "Udemy"));
		
		// if same id is provided then it will override earlier one
		courseSpringJPAepository.insert(new CourseDetails(4, "Jenkins", "Udemy"));

		courseSpringJPAepository.deleteById(3);

		System.out.println(courseSpringJPAepository.findById(4));
	}

}
