package com.example.Dto;

import com.example.Entities.StudentEntity;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class MarksDto 
{
	@Column(name = "MarksId")
	private Integer marksId;

	@Column(name = "Grade")
	private String grade;
	
	@Column(name = "Score")
	private Integer score;
	
	private Integer studentId;
}
