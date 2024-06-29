package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.Student;
import com.demo.repository.StudentRepository;

@Service
public class StudentService {
	
	
	 @Autowired 
	 StudentRepository studentRepository;
	 
	 public void addStudent(Student e)
	 {
		 studentRepository.save(e);
	 }
	 
	public List<Student> getAllStudents()
	{
		return studentRepository.findAll();
		
		
	}
	
	public Student getStudentById(int id)
	{
		Optional<Student> e=studentRepository.findById(id);
		if(e.isPresent())
		{
			return e.get();
		}
		return null;
	}
	public void deleteStudent(int id) {
		studentRepository.deleteById(id);
	}

}
