package com.sample.student.repository;

import java.util.List;

import com.sample.student.model.Student;

/**
 * Created class to simulate the database
 */

public interface StudentRepository {

	public List<Student> findAllStudent();

	public void save(Student student);

	public void delete(long studentId);

}
