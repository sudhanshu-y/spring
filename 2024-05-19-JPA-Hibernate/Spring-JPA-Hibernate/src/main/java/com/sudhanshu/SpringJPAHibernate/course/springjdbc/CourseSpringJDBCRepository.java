package com.sudhanshu.SpringJPAHibernate.course.springjdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sudhanshu.SpringJPAHibernate.course.Course;

@Repository
public class CourseSpringJDBCRepository {
	
	@Autowired
	private JdbcTemplate springJdbcTemplate;
	
	private static String INSERT_QUERY_1 = """
			insert into course
			values (1, 'Spring Boot', 'Udemy');
			""";
	
	private static String INSERT_QUERY_2 = """
			insert into course
			values (?, ?, ?);
			""";
	
	private static String DELETE_QUERY = """
			delete from course
			where id=?
			""";
	
	private static String SELECT_QUERY = """
			select * from course
			where id=?
			""";
	
	public void insertSpringJDBC() {
		springJdbcTemplate.update(INSERT_QUERY_1);
	}
	
	public void insertSpringJdbcFromClass(Course course) {
		springJdbcTemplate.update(INSERT_QUERY_2, course.getId(), course.getName(), course.getAuthor());
	}
	
	public void deleteById(int id) {
		springJdbcTemplate.update(DELETE_QUERY, id);
	}
	
	public Course selectById(int id) {
		return springJdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
		// to map result set into object 
	}
}
