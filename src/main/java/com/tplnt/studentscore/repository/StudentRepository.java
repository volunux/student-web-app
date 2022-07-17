package com.tplnt.studentscore.repository;

import java.util.List;

import com.tplnt.studentscore.entity.Student;

public interface StudentRepository {
	
	List<Student> getAllStudent(String email);
	
	Student getOneStudent(Long id);
	
	Student createStudent(Student student);
	
	Student updateStudent(Long id, Student student);
	
	boolean deleteStudent(Long id);
}
