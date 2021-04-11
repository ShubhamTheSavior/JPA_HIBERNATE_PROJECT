package com.hibernate.jpa.demo.repository;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hibernate.jpa.demo.entity.CourseEntity;
import com.hibernate.jpa.demo.entity.StudentEntity;

@Repository
@Transactional
public class ManyToManyRapo {

	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;
	
	public void getStudentCourseData() {
		StudentEntity student=em.find(StudentEntity.class, 1001);
		logger.info("student details are--->{}",student);
		logger.info("courses associated with student are--->{}",student.getCourses());
	}
	
	
	public void addStudentAndCourseHarcoded() {
		StudentEntity student=new StudentEntity("iron man");
		CourseEntity course=new CourseEntity("Avengers");
		
		em.persist(student);
		em.persist(course);
		
		student.addCourses(course);
		course.addStudents(student);
		
		em.persist(student);
	}
	
	
	public void addStudentAndCourse(StudentEntity student,CourseEntity course) {
		student.addCourses(course);
		course.addStudents(student);
		em.persist(student);
		em.persist(course);
	}
}
