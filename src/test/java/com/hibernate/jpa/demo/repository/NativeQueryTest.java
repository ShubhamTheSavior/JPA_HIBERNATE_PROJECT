package com.hibernate.jpa.demo.repository;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.hibernate.jpa.demo.entity.CourseEntity;

public class NativeQueryTest {

	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;
	
	/*@Test
	public void native_query_test() {
		Query query=em.createNativeQuery("select * from course_entity");
		List list=query.getResultList();
		logger.info("select * from course_entity --> {}",list);
	}*/
	
	

}
