package com.example.Services;

import java.util.List;

import com.example.Dto.StudentDto;
import com.example.Entities.StudentEntity;

import jakarta.servlet.http.HttpServletRequest;

public interface StudentService 
{
	public StudentEntity createStudent(StudentDto dto,HttpServletRequest httpServletRequest) ;
	
	public List<StudentEntity> displayStudentDetails();
	
	public StudentEntity displayById(Integer id);
	
	public StudentEntity delete(Integer id);
	
	public StudentEntity update(StudentDto studentDto,Integer id);
	
	public List<StudentEntity> displayByName(String Name);
}
