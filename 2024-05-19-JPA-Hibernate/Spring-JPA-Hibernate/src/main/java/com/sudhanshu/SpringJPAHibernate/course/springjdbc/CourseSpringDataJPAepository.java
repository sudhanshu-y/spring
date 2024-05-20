package com.sudhanshu.SpringJPAHibernate.course.springjdbc;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sudhanshu.SpringJPAHibernate.course.CourseDetails;

public interface CourseSpringDataJPAepository extends JpaRepository<CourseDetails, Integer> {

	List<CourseDetails> findByAuthor(String author);
}
