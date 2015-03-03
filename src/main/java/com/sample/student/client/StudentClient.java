package com.sample.student.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sample.student.model.Student;

/**
 * StudentClient class implemented mock to call web service  
 * target object and path is concatenate to build URL
 */

public class StudentClient {

	private Client client;

	public StudentClient() {
		client = ClientBuilder.newClient();
	}

	public List<Student> getAllStudent() {
		WebTarget target = client
				.target("http://localhost:8080/StudentManagement/webapi/");
		List<Student> response = target.path("student")
				.request(MediaType.APPLICATION_JSON)
				.get(new GenericType<List<Student>>() {
				});

		System.out.println(response);
		return response;
	}

	public Student updateStudent(Student student) {
		WebTarget target = client
				.target("http://localhost:8080/StudentManagement/webapi/");
		Response response = target.path("student/" + student.getId())
				.request(MediaType.APPLICATION_JSON)
				.put(Entity.entity(student, MediaType.APPLICATION_JSON));

		if (response.getStatus() != 200) {
			throw new RuntimeException("Error occurred on server "
					+ response.getStatus());
		}

		System.out.println(response);
		return response.readEntity(Student.class);
	}

	public void delete(long studentId) {
		WebTarget target = client
				.target("http://localhost:8080/StudentManagement/webapi/");
		Response response = target.path("student/" + studentId)
				.request(MediaType.APPLICATION_JSON).delete();

		if (response.getStatus() != 200) {
			throw new RuntimeException("Error occurred on server "
					+ response.getStatus());
		}
	}


}
