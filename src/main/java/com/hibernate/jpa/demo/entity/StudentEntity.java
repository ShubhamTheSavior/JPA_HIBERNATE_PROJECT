package com.hibernate.jpa.demo.entity;

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
public class StudentEntity {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(nullable=false)
	private String name;
	
	@OneToOne(fetch=FetchType.LAZY) //By default the fetching type of one to one is EAGER fetching
	private PassportEntity passportEntity;
	
	
	@ManyToMany			//By default many to many relationship is LAZY fetch
	@JoinTable(name="STUDENT_COURSE",  // It is used to give the name to the relationship table
	joinColumns=@JoinColumn(name="student_id"), // It is used to give name to the column of owning side
	inverseJoinColumns=@JoinColumn(name="course_id")) //It is used to give the name to the column which contains mapped by
	private List<CourseEntity> courses=new ArrayList<>();
	
	protected StudentEntity() {}

	public StudentEntity(String name) {
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
	
	public PassportEntity getPassportEntity() {
		return passportEntity;
	}

	public void setPassportEntity(PassportEntity passportEntity) {
		this.passportEntity = passportEntity;
	}

	public List<CourseEntity> getCourses() {
		return courses;
	}

	public void addCourses(CourseEntity courses) {
		this.courses.add(courses);
	}
	
	public void removeCourses(CourseEntity courses) {
		this.courses.remove(courses);
	}

	@Override
	public String toString() {
		return "StudentEntity [id=" + id + ", name=" + name + "]";
	}
	
	
}
