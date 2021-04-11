package com.hibernate.jpa.demo.entity;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;


@Entity
public class FullTimeEmployee extends EmployeeEntity{

	FullTimeEmployee(){}
	
	public FullTimeEmployee(String name,BigDecimal salary){
		super(name);
		this.salary=salary;
	}
	
	
	private BigDecimal salary;


	

}
