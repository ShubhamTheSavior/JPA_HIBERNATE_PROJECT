package com.hibernate.jpa.demo.repository;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hibernate.jpa.demo.entity.PassportEntity;
import com.hibernate.jpa.demo.entity.StudentEntity;

@Repository
@Transactional
public class StudentRapo {

	@Autowired
	EntityManager em;
	
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	public StudentEntity save(StudentEntity student) {
		if(student.getId()==null) {
			em.persist(student);
		}else{
			em.merge(student);
		}
		return student;
	}
	
	public StudentEntity findById(int id) {
		StudentEntity student=em.find(StudentEntity.class,id);
		logger.info("check student{}",student);
		return student;
	}
	
	public PassportEntity findByPassId(int id) {
		PassportEntity student=em.find(PassportEntity.class,id);
		return student;
	}
	
	public void deleteById(int id) {
		StudentEntity student=findById(id);
		if(student!=null) {
			em.remove(student);
		}
	}
	
	public void playwithEntityManager() {
		StudentEntity student=new StudentEntity("rajesh");
		em.persist(student);
		student.setName("suresh");//It will update the current row i.e rajesh with suresh because transaction is still going on
	}
	
	
	//flush
	public void playwithEntityManagerAgain() {
		StudentEntity studentOne=new StudentEntity("alank");
		em.persist(studentOne);
		em.flush();//It persist the data to database till current situation
		studentOne.setName("alankar");
		em.flush();
		
		StudentEntity studentTwo=new StudentEntity("kalank");
		em.persist(studentTwo);
		em.flush();
		studentTwo.setName("kalankar");
		em.flush();
	} 
	
	//detached and clear
	public void entityManagerPlayAgain() {
		StudentEntity studentOne=new StudentEntity("alank");
		em.persist(studentOne);
		StudentEntity studentTwo=new StudentEntity("kalank");
		em.persist(studentTwo);
		em.flush();
		em.detach(studentTwo);//It will detached the given object from entity manager
		em.clear();//It will detach all the working objects from entity manager
		studentOne.setName("alankar");
		studentTwo.setName("kalankar");
	}
	
	public void passportData() {
		PassportEntity passportEntity=new PassportEntity("A12345");
		em.persist(passportEntity);
		StudentEntity student=new StudentEntity("kumar");
		student.setPassportEntity(passportEntity);
		em.persist(student);
	}
	
	
	public void retrievElementsFromStudent() {
		StudentEntity studentEntity=findById(1001);
		logger.info("studentEntity -->{}",studentEntity);
		logger.info("passportEntity-->{}",studentEntity.getPassportEntity());
	}
	
	public void retrievElementsFromPassport() {
		PassportEntity studentEntity=findByPassId(1001);
		logger.info("studentEntity -->{}",studentEntity);
		logger.info("passportEntity shubham-->{}",studentEntity.getStudentEntity());
	}
	
}
