package com.hibernate.jpa.demo.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
public class ReviewEntity {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String description;
	
	private String rating;
	
	@ManyToOne // always eager fetching by default
	private CourseEntity courseEntity;
	
	protected ReviewEntity() {}

	public ReviewEntity(String description, String rating) {
		super();
		this.description = description;
		this.rating = rating;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public CourseEntity getCourseEntity() {
		return courseEntity;
	}

	public void setCourseEntity(CourseEntity courseEntity) {
		this.courseEntity = courseEntity;
	}
	
}
