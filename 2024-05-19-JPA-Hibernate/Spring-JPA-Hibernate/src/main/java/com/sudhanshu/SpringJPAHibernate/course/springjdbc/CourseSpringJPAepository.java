package com.sudhanshu.SpringJPAHibernate.course.springjdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sudhanshu.SpringJPAHibernate.course.CourseDetails;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CourseSpringJPAepository {

	// @Autowired // this will also work
	@PersistenceContext // more specific annotation
	private EntityManager entityManager;

	public void insert(CourseDetails courseDetails) {
		entityManager.merge(courseDetails);
	}

	public CourseDetails findById(int id) {
		return entityManager.find(CourseDetails.class, id);
	}

	public void deleteById(int id) {
		CourseDetails courseToDdelete = entityManager.find(CourseDetails.class, id);
		entityManager.remove(courseToDdelete);
	}
}
