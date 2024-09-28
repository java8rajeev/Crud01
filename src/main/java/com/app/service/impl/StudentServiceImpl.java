package com.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Student;
import com.app.repo.StudentRepo;
import com.app.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepo repo;

	@Override
	public Integer saveStudent(Student std) {
		// TODO Auto-generated method stub
		return repo.save(std).getStdId();
	}

	@Override
	public void deleteStudent(Integer id) {
		  repo.deleteById(id);
		
	}

	@Override
	public void updateStudent(Student std) {
		repo.save(std);
		
	}

	@Override
	public Optional<Student> getOneStudent(Integer id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public boolean isPresent(Integer id) {
		// TODO Auto-generated method stub
		return repo.existsById(id);
	}

}
