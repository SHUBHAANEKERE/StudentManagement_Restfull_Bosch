package com.sample.student.repository;

import java.util.ArrayList;
import java.util.List;

import com.sample.student.model.Student;


/**
 * StudentRepositoryImpl class gave the implementation of the StudentRepository interface
 * methods implementation represents Database operation
 */
public class StudentRepositoryImpl implements StudentRepository {
	@Override
	public List<Student> findAllStudent() {
		List<Student> students = new ArrayList<Student>();
		Student student = new Student(1l, "Shubha", "Address", "City");
		students.add(student);
		Student student2 = new Student(1l, "Ravi", "Address", "City");
		students.add(student2);
		return students;
	}

	@Override
	public void save(Student student) {
		System.out.println("Student Updated");
	}

	@Override
	public void delete(long studentId) {
		System.out.println("Student Deleted");

	}

}
