
package com.example.Entities;

import java.util.List;

import com.example.Enum.Gender;
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
@Table(name = "StudentDetails")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "StudId",length = 40)
	private Integer studentId;
	
	@Column(name = "StudName",length = 50)
	private String studentName;
	
	@Column(name = "StudClass",length = 20)
	private String studentClass;
	
	@Column(name = "StudCity",length = 20)
	private String studentCity;
	
	@Column(name = "StudAge",length = 10)
	private Integer studentAge;
	
	@Column(name = "StudGmail",length = 20)
	private String studentGmail;
	
	@Column(name = "StudMobileNo",length = 20)
	private String studentMobileNo;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "StudGender",length = 10)
	private Gender studentGender;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "StudStatus",length = 10)
	private Status studentStatus;
	
	@JsonIgnore
	@OneToMany(mappedBy = "studentId",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonManagedReference
	private List<MarksEntity> marksId;
}
