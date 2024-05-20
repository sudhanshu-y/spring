package com.sudhanshu.SpringJPAHibernate.course.springjdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sudhanshu.SpringJPAHibernate.course.CourseDetails;

@Component
public class CourseSpringDataJPACommandLineRunner implements CommandLineRunner {

	@Autowired
	private CourseSpringDataJPAepository courseSpringDataJPAepository;

	@Override
	public void run(String... args) throws Exception {

		courseSpringDataJPAepository.save(new CourseDetails(5, "Microservice Use case", "Web"));
		courseSpringDataJPAepository.save(new CourseDetails(6, "JavaScript Use case", "Udemy"));
		courseSpringDataJPAepository.save(new CourseDetails(7, "React Use case", "Udemy"));

		// if same id is provided then it will override earlier one
		courseSpringDataJPAepository.save(new CourseDetails(7, "Jenkins Use case", "Web"));

		courseSpringDataJPAepository.deleteById(3);

		System.out.println(courseSpringDataJPAepository.findById(4));
		
		System.out.println("From_Spring_Data_JPA:"+courseSpringDataJPAepository.findAll());
		
		System.out.println("findByAuthor_custom"+courseSpringDataJPAepository.findByAuthor("Web"));
		System.out.println("findByAuthor_custom"+courseSpringDataJPAepository.findByAuthor(""));
		System.out.println("findByAuthor_custom"+courseSpringDataJPAepository.findByAuthor("Udemy"));
	}

}
