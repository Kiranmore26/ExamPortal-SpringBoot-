package com.example.Dto;

import java.util.List;

import com.example.Entities.MarksEntity;
import com.example.Enum.Gender;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class StudentDto 
{
	@NotBlank(message = "Fill The Name Column")
	private String studentName;
	
	private String studentClass;
	
	@NotBlank(message = "Fill the City Column")
	private String studentCity;
	
	@NotNull(message = "Age is mandatory")
	@Min(value = 10, message = "Age should not be less than 10")
	@Max(value = 30, message = "Age should not be greater than 30")
	private Integer studentAge;
	
	@Email(message = "Enter Valid Email Id")
	private String studentGmail;
	
	
	private String studentMobileNo;
	
	private Gender studentGender;
	
	private List<MarksEntity> marksId;
	
}
