package com.hibernate.jpa.demo.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
public class PassportEntity {

	@Id
	@GeneratedValue
	private Integer id;
	
	
	@Column(nullable=false)
	private String number;
	
	@OneToOne(fetch=FetchType.LAZY,mappedBy="passportEntity")//mapped by is to make the other entity as a owning entity which contains column
	private StudentEntity studentEntity;
	
	protected PassportEntity() {}

	public PassportEntity(String name) {
		super();
		this.number = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	

	public StudentEntity getStudentEntity() {
		return studentEntity;
	}

	public void setStudentEntity(StudentEntity studentEntity) {
		this.studentEntity = studentEntity;
	}

	@Override
	public String toString() {
		return "PassportEntity [id=" + id + ", number=" + number + "]";
	}
	
	
}
