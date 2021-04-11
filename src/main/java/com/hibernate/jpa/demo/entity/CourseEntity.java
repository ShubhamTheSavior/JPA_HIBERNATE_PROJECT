package com.hibernate.jpa.demo.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;
import javax.validation.constraints.Null;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;


@Entity
@NamedQuery(name="get_all_Courses",query="select c from CourseEntity c")
@Cacheable
//SQLDelete is an hibernate annotation which is used to soft delete
@SQLDelete(sql="update course_entity set is_deleted=true where id=?")
//Where is used to suppress the data which is soft deleted while retrieving data
@Where(clause="is_deleted=false")
public class CourseEntity {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(nullable=false)
	private String name;
	
	@CreationTimestamp
	private LocalDateTime lastCreatedDate;
	
	@UpdateTimestamp
	private LocalDateTime lastUpdatedDate;
	
	@OneToMany(mappedBy="courseEntity") // OneToMany -- always lazy fetching by default
	private List<ReviewEntity> reviews=new ArrayList<>();
	
	@ManyToMany(mappedBy="courses")
	private List<StudentEntity> students=new ArrayList<>();
	
	private boolean isDeleted;
	
	protected CourseEntity() {}

	public CourseEntity(String name) {
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

	
	public List<ReviewEntity> getReviews() {
		return reviews;
	}

	public void addReview(ReviewEntity reviews) {
		this.reviews.add(reviews);
	}
	
	public void removeReview(ReviewEntity reviews) {
		this.reviews.remove(reviews);
	}

	public List<StudentEntity> getStudents() {
		return students;
	}

	public void addStudents(StudentEntity students) {
		this.students.add(students);
	}
	
	public void removeStudents(StudentEntity students) {
		this.students.remove(students);
	}
	
	
	//Whenever the row of a specific entity is deleted this is the method that gets fired where you can write the updated code so when anyone 
	//else wants to use that same entity in same transaction then they will get an updated entity
	@PreRemove
	private void preRemove() {
		this.isDeleted=true;
	}
	
	
	@Override
	public String toString() {
		return "CourseEntity [id=" + id + ", name=" + name + "]";
	}
	
	
}
