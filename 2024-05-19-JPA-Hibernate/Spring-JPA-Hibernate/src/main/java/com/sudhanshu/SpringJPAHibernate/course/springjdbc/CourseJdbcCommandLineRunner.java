package com.sudhanshu.SpringJPAHibernate.course.springjdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sudhanshu.SpringJPAHibernate.course.Course;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner{

	@Autowired
	private CourseSpringJDBCRepository courseSpringJDBCRepository;
	
	@Override
	public void run(String... args) throws Exception {
		courseSpringJDBCRepository.insertSpringJDBC();
		
		courseSpringJDBCRepository.insertSpringJdbcFromClass(new Course(2, "Microservice", "Udemy"));
		courseSpringJDBCRepository.insertSpringJdbcFromClass(new Course(3, "JavaScript", "Udemy"));
		courseSpringJDBCRepository.insertSpringJdbcFromClass(new Course(4, "React", "Udemy"));
		
		courseSpringJDBCRepository.deleteById(3);
		
		System.out.println(courseSpringJDBCRepository.selectById(4));
	}

}
