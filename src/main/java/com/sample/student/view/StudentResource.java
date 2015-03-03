package com.sample.student.view;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sample.student.model.Student;
import com.sample.student.repository.StudentRepository;
import com.sample.student.repository.StudentRepositoryImpl;


/**
 * StudentResource class contains different service methods to perform request and response 
 * method format produces JSON or XML format
 */
@Path("student")
public class StudentResource {

	private StudentRepository studentRepository = new StudentRepositoryImpl();

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Student> getAllStudent() {
		return studentRepository.findAllStudent();
	}

	@PUT
	@Path("{newStudent}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response updateStudent(Student student) {

		studentRepository.save(student);
		return Response.status(200).entity(student).build();
	}

	@DELETE
	@Path("{deleteStudent}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response deleteStudent(@PathParam("studentId") long studentId) {
		System.out.println("Delete triggered");
		studentRepository.delete(studentId);
		return Response.status(200).build();
	}

}
