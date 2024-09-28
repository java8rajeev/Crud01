package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.entity.Student;

public interface StudentService {
	
	Integer saveStudent(Student std);
	void deleteStudent(Integer id);
	void updateStudent(Student std);
	Optional<Student> getOneStudent(Integer id);
	List<Student> getAllStudent();
	boolean isPresent(Integer id);
	
	

}
