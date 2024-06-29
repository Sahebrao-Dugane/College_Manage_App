package com.demo.service;

import java.util.List;

import com.demo.entity.Student;

public interface StudentService {
	 List<Student> getAllStudents();
	    Student saveStudent(Student student);
	    com.demo.model.Student getStudentById(Long id);
	    void deleteStudent(Long id);
		com.demo.model.Student saveStudent(com.demo.model.Student student);
}
