package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Student;
import com.app.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentControllerr {
	

	@Autowired
	private StudentService service;
	
	
	@PostMapping("/save")
	public ResponseEntity<String> saveStd(@RequestBody Student std){
		ResponseEntity<String> rsp=null;
		try {
		Integer id=service.saveStudent(std);
		String msg="student saved successffully with this "+id;
		rsp=new ResponseEntity<String>(msg, HttpStatus.CREATED);
		}catch(Exception e){
			rsp=new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return rsp;
		
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllEmp(){
		List<Student> list=service.getAllStudent();
		
		ResponseEntity<?> rsp=null;
		if(list.isEmpty() ||list==null) {
			String msg="no emp list found";
			rsp=new ResponseEntity<String>(msg,HttpStatus.OK);
		}else {
			rsp=new ResponseEntity<>(list,HttpStatus.OK);
		}
		return rsp;
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable("id") Integer id){
		boolean present=service.isPresent(id);
		ResponseEntity<String> rsp=null;
		if(present) {
			service.deleteStudent(id);
			rsp=new ResponseEntity<String>("successfully '"+id+"' deleted",HttpStatus.OK);
		}else{	
			rsp=new ResponseEntity<String>("successfully '"+id+"' not exist",HttpStatus.BAD_REQUEST);
		}
		return rsp;
		
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateStudent(@PathVariable("id")Integer id,@RequestBody Student std){
		ResponseEntity<String> rsp=null;
		boolean present=service.isPresent(id);
		if(present) {
			service.updateStudent(std);
			rsp=new ResponseEntity<String>("successfully '"+id+"' updated",HttpStatus.OK);
		}else{
			
			rsp=new ResponseEntity<String>("'"+id+"' NOT EXIST",HttpStatus.BAD_REQUEST);
		}
		return rsp;
		
	}
	

	
	

}
