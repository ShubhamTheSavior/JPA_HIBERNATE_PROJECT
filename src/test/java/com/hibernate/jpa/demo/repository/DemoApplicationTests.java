package com.hibernate.jpa.demo.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.hibernate.jpa.demo.entity.CourseEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	CourseRepo courseRepo;
	
	@Autowired
	EntityManager em;
	
	Logger logger=LoggerFactory.getLogger(this.getClass());
	/*
	@Test
	public void findById_test() {
		CourseEntity course=courseRepo.findById(9);
		assertEquals("alankar",course.getName());
		logger.info("context loads");
	}*/
	
	/*@Test
	@DirtiesContext
	public void update_test() {
		//get the course
		CourseEntity course=courseRepo.findById(1);
		assertEquals("gadekar",course.getName());
		//update the course
		course.setName("Shubham Gadekar");
		//update the data
		courseRepo.save(course);
		assertEquals("Shubham Gadekar",course.getName());
	}
	
	*/
	/*
	@Test
	@DirtiesContext
	public void deleteById_test() {
		courseRepo.deleteById(1002);
		assertNull(courseRepo.findById(1002));
	}*/
	
	/*@Test
	public void jpql_basic() {
		List<CourseEntity> resultList=em.createQuery("select c from CourseEntity c").getResultList();
		logger.info("resultList-->{}",resultList);
	}
	
	@Test
	public void jpql_typed() {
		TypedQuery<CourseEntity> typed=em.createQuery("select c from CourseEntity c",CourseEntity.class);
		List<CourseEntity> typedQuery=typed.getResultList();
		logger.info("typedQuery-->{}",typedQuery);
	}
	
	@Test
	public void jpql_where() {
		TypedQuery<CourseEntity> typed=em.createQuery("select c from CourseEntity c where c.id=9",CourseEntity.class);
		List<CourseEntity> typedQuery=typed.getResultList();
		logger.info("whereQuery-->{}",typedQuery);
	}
*/
	
	@Test
	public void jpql_basic() {
		TypedQuery<CourseEntity> typed=em.createNamedQuery("get_all_Courses",CourseEntity.class);
		List<CourseEntity> typedQuery=typed.getResultList();
		logger.info("whereQuery-->{}",typedQuery);
	}
}
