package com.tut;

import javax.persistence.EntityManager;

public class Controller {
	
	public Student findStudent(EntityManager manager, int inputFind) {
		Student student = manager.find(Student.class, inputFind);
		return student;
	}
	public Student updateStudent(EntityManager manager,int inputUpdate) {
		Student student = manager.find(Student.class, inputUpdate);
		return student;
	}
	public Student deleteStudent(EntityManager manager,int inputDelete) {
		Student student = manager.find(Student.class, inputDelete);
		return student;
	}
}
