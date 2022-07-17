package com.tplnt.studentscore.entity.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class StudentUpdateDto {

	@Size(max = 20, message ="{firstName.size}")
	private String firstName;

	@Size(max = 20, message = "{lastName.size}")
	private String lastName;
	
	@Email(message = "{emailAddress.pattern}")
	@Size(max = 50, message ="{emailAddress.size}")
	private String emailAddress;

	@Size(min = 1, max = 300, message ="{homeAddress.size}")
	private String homeAddress;
}
