package com.tplnt.studentscore.entity.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class StudentDto {

	@Size(min = 1, max = 20, message = "{firstName.size}")
	private String firstName;
	
	@NotBlank(message = "{lastName.notEmpty}")
	@Size(min = 1, max = 20, message = "{lastName.size}")
	private String lastName;
	
	@NotEmpty(message ="{emailAddress.notEmpty}")
	@Email(message = "{emailAddress.pattern}")
	@Size(min = 1, max = 50, message ="{emailAddress.size}")
	private String emailAddress;
	
	
	@NotEmpty(message ="{homeAddress.notEmpty}")
	@Size(min = 1, max = 300, message ="{homeAddress.size}")
	private String homeAddress;
}
