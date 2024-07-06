package com.example.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "MarksDetail")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MarksEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MarksId")
	private Integer marksId;

	@Column(name = "Grade")
	private String grade;
	
	@Column(name = "Score")
	private Integer score;
	
	@ManyToOne
	@JoinColumn(name = "StudentId")
	private StudentEntity studentId;
	
	
}
