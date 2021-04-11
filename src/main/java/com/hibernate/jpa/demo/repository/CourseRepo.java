package com.hibernate.jpa.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import com.hibernate.jpa.demo.entity.CourseEntity;

@Repository
@Transactional
public class CourseRepo {

	@Autowired
	EntityManager em;
	
	Logger logger=LoggerFactory.getLogger(this.getClass());
	
	public CourseEntity save(CourseEntity course) {
		if(course.getId()==null) {
			em.persist(course);
		}else{
			em.merge(course);
		}
		return course;
	}
	
	public void allCourseData() {
		TypedQuery<CourseEntity> query=em.createNamedQuery("get_all_Courses",CourseEntity.class);
		List<CourseEntity> courses=query.getResultList();
		logger.info("select * from course_entity--->{}",courses);
	}
	
	
	public CourseEntity findById(int id) {
		
		CourseEntity course=em.find(CourseEntity.class,id);
		logger.info("CourseEntity details---->{}",course.getReviews());
		CourseEntity course1=em.find(CourseEntity.class,id);
		logger.info("CourseEntity details---->{}",course1.getReviews());
		return course;
	}
	
	
	public CourseEntity findByIdOne(int id) {
		CourseEntity course1=em.find(CourseEntity.class,id);
		logger.info("CourseEntity details---->{}",course1);
		return course1;
	}
	public void deleteById(int id) {
		CourseEntity course=findById(id);
		if(course!=null) {
			em.remove(course);
		}
	}
	
	public void playwithEntityManager() {
		CourseEntity course=new CourseEntity("rajesh");
		em.persist(course);
		course.setName("suresh");//It will update the current row i.e rajesh with suresh because transaction is still going on
	}
	
	
	//flush
	public void playwithEntityManagerAgain() {
		CourseEntity courseOne=new CourseEntity("alank");
		em.persist(courseOne);
		em.flush();//It persist the data to database till current situation
		courseOne.setName("alankar");
		em.flush();
		
		CourseEntity courseTwo=new CourseEntity("kalank");
		em.persist(courseTwo);
		em.flush();
		courseTwo.setName("kalankar");
		em.flush();
	} 
	
	//detached and clear
	public void entityManagerPlayAgain() {
		CourseEntity courseOne=new CourseEntity("alank");
		em.persist(courseOne);
		CourseEntity courseTwo=new CourseEntity("kalank");
		em.persist(courseTwo);
		em.flush();
		em.detach(courseTwo);//It will detached the given object from entity manager
		em.clear();//It will detach all the working objects from entity manager
		courseOne.setName("alankar");
		courseTwo.setName("kalankar");
	}
	
}
