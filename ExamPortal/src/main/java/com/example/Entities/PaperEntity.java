package com.example.Entities;

import com.example.Enum.Status;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "PaperDetails")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaperEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PaperId",length = 50)
	private Integer paperId;
	
	@Column(name = "PaperSubject",length = 50)
	private String paperSubject;

	@Column(name = "PaperType",length = 40)
	private String paperType;
	
	@Column(name = "PaperSemester",length = 50)
	private String paperSemester;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "PaperStatus",length = 10)
	private Status paperStatus;
	
	
	@ManyToOne
	@JoinColumn(name = "TeachersId")
	private TeachersEntity teachersId;
	
}

