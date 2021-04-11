package com.hibernate.jpa.demo.repository;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.hibernate.jpa.demo.entity.StudentEntity;

@Transactional
public class StudentEntityTest {

	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	StudentRapo studentRapo;
	
	@Test
	public void retrievElementsFromStudent() {
		StudentEntity studentEntity=studentRapo.findById(1001);
		logger.info("studentEntity -->{}",studentEntity);
	}

}
