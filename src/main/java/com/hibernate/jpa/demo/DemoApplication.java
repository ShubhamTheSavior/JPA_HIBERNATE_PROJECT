package com.hibernate.jpa.demo;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;

import com.hibernate.jpa.demo.entity.CourseEntity;
import com.hibernate.jpa.demo.entity.FullTimeEmployee;
import com.hibernate.jpa.demo.entity.PartTimeEmployee;
import com.hibernate.jpa.demo.entity.ReviewEntity;
import com.hibernate.jpa.demo.entity.StudentEntity;
import com.hibernate.jpa.demo.repository.CourseRepo;
import com.hibernate.jpa.demo.repository.EmployeeRapo;
import com.hibernate.jpa.demo.repository.JpqlQueriesRapo;
import com.hibernate.jpa.demo.repository.ManyToManyRapo;
import com.hibernate.jpa.demo.repository.OneToManyRapo;
import com.hibernate.jpa.demo.repository.StudentRapo;

@SpringBootApplication
@EntityScan("com.hibernate.jpa.demo.entity")
@ComponentScan("com.hibernate.jpa.demo.repository")
public class DemoApplication implements CommandLineRunner{

	@Autowired
	CourseRepo courseRepo;
	
	@Autowired
	StudentRapo studentRepo;
	
	@Autowired
	OneToManyRapo rapo;
	
	@Autowired
	ManyToManyRapo manyToManyRapo;
	
	@Autowired
	EmployeeRapo employeeRapo;
	
	@Autowired
	JpqlQueriesRapo jpqlRapo;
	
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		courseRepo.deleteById(27);
		
	}

	
	
	/*//courseRepo.save(new CourseEntity("akola"));
			//courseRepo.deleteById(1001);
			//CourseEntity course=courseRepo.findById(1001);
			//logger.info("1001->{}",course);
			//studentRepo.retrievElementsFromPassport();
			
			List<ReviewEntity> review=new ArrayList<>();
			review.add(new ReviewEntity("lay bhari","5"));
			review.add(new ReviewEntity("mastach re","5"));
			rapo.addReview(27,review);
			manyToManyRapo.addStudentAndCourse(new StudentEntity("Hulk"),new CourseEntity("Say Green"));
			employeeRapo.addEmployee(new PartTimeEmployee("jack",new BigDecimal("10000")));
			employeeRapo.addEmployee(new FullTimeEmployee("jill",new BigDecimal("10000")));
			logger.info("all employee data==>{}",employeeRapo.retrieveAllEmployees());
			*/

}
