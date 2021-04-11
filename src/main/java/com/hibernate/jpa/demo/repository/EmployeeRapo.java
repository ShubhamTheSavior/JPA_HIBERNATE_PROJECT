package com.hibernate.jpa.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hibernate.jpa.demo.entity.EmployeeEntity;

@Repository
@Transactional
public class EmployeeRapo {

	@Autowired
	EntityManager em;
	
	public void addEmployee(EmployeeEntity employee) {
		em.persist(employee);
	}
	
	
	public List<EmployeeEntity> retrieveAllEmployees(){
		return em.createQuery("select e from EmployeeEntity e",EmployeeEntity.class).getResultList();
	}
}
