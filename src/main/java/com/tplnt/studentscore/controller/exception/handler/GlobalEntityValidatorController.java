package com.tplnt.studentscore.controller.exception.handler;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tplnt.studentscore.entity.exception.StudentDuplicateEntityException;
import com.tplnt.studentscore.entity.exception.StudentNotFoundException;

@RestControllerAdvice
public class GlobalEntityValidatorController {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<String, String>();
		ex.getBindingResult().getAllErrors().forEach(new Consumer<ObjectError>() {
			@Override
			public void accept(ObjectError error) {
				String fieldName = ((FieldError) error).getField();
				String errorMessage = error.getDefaultMessage();
				errors.put(fieldName, errorMessage);
			}
		});
		return errors;
	}
		
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(StudentNotFoundException.class)
	public Object handleDoctorNotFound(StudentNotFoundException ex) {
		Map<String, String> errors = new HashMap<String, String>();
		errors.put("entityName", StudentNotFoundException.entityName);
		errors.put("message", ex.getMessage());
		ex.setCode(HttpStatus.NOT_FOUND.value());
		errors.put("code", ex.getCode().toString());
		return errors;
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(DataIntegrityViolationException.class)
	public Object handleDoctorNotFound(DataIntegrityViolationException ex) {
		Map<String, String> errors = new HashMap<String, String>();
		errors.put("entityName", "Unknown");
		errors.put("message", "One of fields submitted matches that of another entity, all existent and new entities field must be unique.");
		errors.put("code" , Integer.toString(HttpStatus.BAD_REQUEST.value()));
		return errors;
	}
	
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(StudentDuplicateEntityException.class)
	public Object handleDoctorDuplicateEntity(StudentDuplicateEntityException ex) {
		Map<String, String> errors = new HashMap<String, String>();
		errors.put("entityName", StudentDuplicateEntityException.entityName);
		errors.put("message", ex.getMessage());
		ex.setCode(HttpStatus.BAD_REQUEST.value());
		errors.put("code", ex.getCode().toString());
		return errors;
	}
}
