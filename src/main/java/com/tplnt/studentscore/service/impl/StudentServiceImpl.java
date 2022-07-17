package com.tplnt.studentscore.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tplnt.studentscore.entity.Student;
import com.tplnt.studentscore.entity.dto.StudentDto;
import com.tplnt.studentscore.entity.dto.StudentUpdateDto;
import com.tplnt.studentscore.entity.exception.StudentNotFoundException;
import com.tplnt.studentscore.repository.StudentRepository;
import com.tplnt.studentscore.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	private StudentRepository repository;
	
	public StudentServiceImpl(StudentRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Student> findAllStudent(String email) {
		return repository.getAllStudent(email);
	}
	
	@Override
	public Student findOneStudent(Long id) {
		Student student = repository.getOneStudent(id);
		if (student != null) {
			return student;
		}
		else {
			throw new StudentNotFoundException(id);
		}
	}
	
	@Override
	@Transactional
	public Student saveStudent(StudentDto studentDto) {
		Student student = new Student();
		student = modelMapper.map(studentDto, Student.class);
		Student newStudent = repository.createStudent(student);
		return newStudent;
	}
	
	@Override
	@Transactional
	public Student updateStudent(Long id, StudentUpdateDto studentUpdateDto) {
		Student existingDoctor = repository.getOneStudent(id);
		if (existingDoctor == null) {
			throw new StudentNotFoundException(id);
		}

		Student student = new Student();
		student = modelMapper.map(studentUpdateDto, Student.class);
		student.setId(id);
		
		return repository.updateStudent(id, existingDoctor);
	}
	
	@Override
	@Transactional
	public boolean deleteStudent(Long id) {
		boolean removed = repository.deleteStudent(id);
		if (removed) {
			return removed;
		}
		else {
			throw new StudentNotFoundException(id);
		}
	}

}
