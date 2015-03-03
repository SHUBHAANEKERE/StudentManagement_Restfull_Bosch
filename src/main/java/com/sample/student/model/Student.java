package com.sample.student.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "student")
public class Student {

	private Long id;
	private String name;
	private String address;
	private String city;

	public Student() {

	}

	public Student(Long id, String name, String address, String city) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.city = city;
	}

	@XmlElement(name = "student-id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@XmlElement(name = "student-name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement(name = "student-address")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@XmlElement(name = "student-city")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
