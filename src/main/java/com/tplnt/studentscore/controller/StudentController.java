package com.tplnt.studentscore.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tplnt.studentscore.entity.Student;
import com.tplnt.studentscore.entity.dto.StudentDto;
import com.tplnt.studentscore.entity.dto.StudentUpdateDto;
import com.tplnt.studentscore.service.StudentService;

@RestController
@RequestMapping(value = "api/student" ,
				consumes = { MediaType.APPLICATION_JSON_VALUE },
				produces = { MediaType.APPLICATION_JSON_VALUE } )
public class StudentController {
	
	private StudentService service;
	
	public StudentController(StudentService service) {
		this.service = service;
	}

	@GetMapping({"", "/entries"})
	public List<Student> findStudents(@RequestParam(required = false) String email) {
		return service.findAllStudent(email);
	}
	
	@GetMapping("/detail/{id}")
	public Student findStudent(@PathVariable(name = "id", required = true) Long id) {
		return service.findOneStudent(id);
	}
	
	@PostMapping({"", "/save"})
	public Student saveStudent(@Valid @RequestBody StudentDto studentDto) {
		return service.saveStudent(studentDto);
	}
	
	@PutMapping("/update/{id}")
	public Student updateStudent(@PathVariable(name ="id", required = true) Long id, @Valid @RequestBody StudentUpdateDto studentUpdateDto) {
		return service.updateStudent(id, studentUpdateDto);
	}
	
	@DeleteMapping("/delete{id}")
	public boolean deleteStudent(@PathVariable(name ="id", required = true) Long id) {
		return service.deleteStudent(id);
	}

}
