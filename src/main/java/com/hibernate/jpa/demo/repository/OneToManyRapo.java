package com.hibernate.jpa.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hibernate.jpa.demo.entity.CourseEntity;
import com.hibernate.jpa.demo.entity.ReviewEntity;

@Repository
@Transactional
public class OneToManyRapo {

	@Autowired
	EntityManager em;
	
	@Autowired
	CourseRepo courseRapo;
	
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	public void addHardCodedReview() {
		
		//get the course
		CourseEntity course=courseRapo.findById(28);
		logger.info("course.getReviews()--> {}", course.getReviews());
		//add 2 reviews to it
		ReviewEntity review1 =new ReviewEntity("lay bhari","5");
		ReviewEntity review2 =new ReviewEntity("mastach re","5");
		
		//setting the relationship
		course.addReview(review1);
		review1.setCourseEntity(course);
		
		course.addReview(review2);
		review2.setCourseEntity(course);
		
		//save it to database
		em.persist(review1);
		em.persist(review2);
		
	}
	
public void addReview(Integer id,List<ReviewEntity> review) {
		
		
		CourseEntity course=courseRapo.findById(id);
		logger.info("course.getReviews()--> {}", course.getReviews());
		for(ReviewEntity reviewOne : review) {
			course.addReview(reviewOne);
			reviewOne.setCourseEntity(course);
			em.persist(reviewOne);
		}	
		logger.info("course.getReviews()--> {}", course.getReviews());
	}
	
}
