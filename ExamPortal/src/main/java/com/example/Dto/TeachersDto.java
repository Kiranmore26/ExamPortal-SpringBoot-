package com.example.Dto;

import java.util.List;

import com.example.Entities.PaperEntity;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TeachersDto 
{
	@NotBlank(message = "Fill The Name Column")
	private String teacherName;

	@Email(message = "Enter Valid Email Id")
	private String teacherGmail;
	
	private String teacherMobileNo;
	
	@NotBlank(message = "Fill The Name Column")
	private String teacherCity;

	@NotNull(message = "Age is mandatory")
	@Min(value = 18, message = "Age should not be less than 18")
	@Max(value = 50, message = "Age should not be greater than 50")
	private Integer teacherAge;
	
	
	private List<PaperEntity> paperId;
}
