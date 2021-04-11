package com.hibernate.jpa.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hibernate.jpa.demo.entity.CourseEntity;

@Repository
@Transactional
public class JpqlQueriesRapo {

	@Autowired
	EntityManager em;
	
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	
	//Course without students
	public void getNoStudentCourses() {
		TypedQuery<CourseEntity> result= em.createQuery("select c from CourseEntity c where c.students is empty",CourseEntity.class);
		List<CourseEntity> courses=result.getResultList();
		logger.info("Course details ---->{}",courses);
	}
	
	
	//Course with at least two students
	public void getAtLeastTwoStudents() {
		TypedQuery<CourseEntity> result=em.createQuery("select c from CourseEntity c where size(c.students)>=2",CourseEntity.class);
		List<CourseEntity> courses=result.getResultList();
		logger.info("Course details ----->{}",courses);
	}
	
	
	//Native Query
	public void getDataWithWhereCondition() {
		Query query=em.createNativeQuery("select * from CourseEntity where id=?",CourseEntity.class);
		query.setParameter(1, 1001L);
		List<CourseEntity> resultList=query.getResultList();
		
	}
	
}
