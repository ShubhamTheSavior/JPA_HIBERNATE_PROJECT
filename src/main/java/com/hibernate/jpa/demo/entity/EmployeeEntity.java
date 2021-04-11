package com.hibernate.jpa.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;


@Entity
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)//By default the inheritance type of the table is singleton
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)//It is used to generate the table per concrete class
@Inheritance(strategy=InheritanceType.JOINED)//It will create a separate tables for super class and sub classes so that no duplicate columns will not get generated
//@MappedSuperclass//In this case tables only generated for sub classes and in this case we dont need to write @Entity.The advantage of this method is joins will not perform at a time which takes place in JOINED strategy 
//@DiscriminatorColumn(name="EmployeeType")//It is used to give the user defined name to the discriminator column
public abstract class EmployeeEntity {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(nullable=false)
	private String name;
	
	
	
	protected EmployeeEntity() {}

	public EmployeeEntity(String name) {
		super();
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

	@Override
	public String toString() {
		return "EmployeeEntity [id=" + id + ", name=" + name + "]";
	}
	
	
}
