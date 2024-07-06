package com.example.Dto;

import com.example.Entities.TeachersEntity;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PaperDto 
{
	@NotBlank(message = "Fill The PaperSubject Column")
	private String paperSubject;
	
	private String paperType;
	
	private String paperSemester;
	
	private Integer teachersId;
}
 
