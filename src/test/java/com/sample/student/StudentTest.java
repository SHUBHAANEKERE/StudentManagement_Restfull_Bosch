package com.sample.student;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import com.sample.student.client.StudentClient;
import com.sample.student.model.Student;

/**
 * 
 * Junit test cases of the web services 
 *
 */

public class StudentTest{
	@Test
	public void testGetAllStudent() {
		StudentClient clientTest = new StudentClient();
		List<Student> students = clientTest.getAllStudent();

		System.out.println("Number of Students >: " + students.size());
		assertNotNull(students);
	}
	
	@Test
	public void testPutRecord() {
		Student student = new Student();
		student.setId(4l);
		student.setName("Vedant");
		student.setAddress("Savery Dr.");
		student.setCity("Canton");
		
		StudentClient clientTest = new StudentClient();
		student = clientTest.updateStudent(student);
		
		assertNotNull(student);

	}
   
	@Test
	public void testDelete() {
		StudentClient clientTest = new StudentClient();
		clientTest.delete(1l);
	}
}
