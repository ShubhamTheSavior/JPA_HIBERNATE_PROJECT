package com.hibernate.jpa.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hibernate.jpa.demo.entity.CourseEntity;

@Repository
@Transactional
public class CriteriaQueriesRapo {

	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;
	
	public void getAllData() {
		//1. Use criteria builder to create criteria query returning the expected result object
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<CourseEntity> cq = cb.createQuery(CourseEntity.class);
		
		//2. Define roots for tables which are involved in the query
		Root<CourseEntity> courseRoot = cq.from(CourseEntity.class);
		
		//3. Define predicates etc using criteria builder
	
		
		//4. Add predicates etc to the criteria query
		
		
		//5. Build the typed query using entity manager and criteria query
		TypedQuery<CourseEntity> query=em.createQuery(cq.select(courseRoot));
		List<CourseEntity> result=query.getResultList();
		logger.info("course detais---->{}",result);
	}
	
	
	public void getLikeData() {
		//1. Use criteria builder to create criteria query returning the expected result object
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<CourseEntity> cq = cb.createQuery(CourseEntity.class);
		
		//2. Define roots for tables which are involved in the query
		Root<CourseEntity> courseRoot = cq.from(CourseEntity.class);
		
		//3. Define predicates etc using criteria builder
		Predicate like = cb.like(courseRoot.get("name"),"%100steps");
		
		//4. Add predicates etc to the criteria query
		cq.where(like);
		
		//5. Build the typed query using entity manager and criteria query
		
		TypedQuery<CourseEntity> query=em.createQuery(cq.select(courseRoot));
		List<CourseEntity> result=query.getResultList();
		logger.info("course detais---->{}",result);
	}
	
}
