package com.example.Entities;

import java.util.List;

import com.example.Enum.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TeachersDetails")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeachersEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TeachId" ,length = 40)
	private Integer teacherId;

	@Column(name = "TeachName",length = 50)
	private String teacherName;

	@Column(name = "TeachGmail",length = 20)
	private String teacherGmail;
	
	@Column(name = "TeachMobileNo",length = 20)
	private String teacherMobileNo;
	
	@Column(name = "TeachCity",length = 30)
	private String teacherCity;

	@Column(name = "TeachAge",length = 10)
	private Integer teacherAge;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "TeachStatus",length = 10)
	private Status teacherStatus;

	@JsonIgnore
	@OneToMany(mappedBy = "teachersId",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonManagedReference
	private List<PaperEntity> paperId;
}
