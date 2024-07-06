package com.example.Services;

import java.util.List;

import com.example.Dto.TeachersDto;
import com.example.Entities.StudentEntity;
import com.example.Entities.TeachersEntity;

import jakarta.servlet.http.HttpServletRequest;

public interface TeacherService 
{
	public TeachersEntity createTeachers(TeachersDto teachersDto,HttpServletRequest httpServletRequest);

	public List<TeachersEntity> displayTeachersDetails();
	
	public TeachersEntity displayById(Integer id);
	
	public TeachersEntity delete(Integer id);
	
	public TeachersEntity update(TeachersDto teachersDto,Integer id);
	
	public List<TeachersEntity> displayByName(String Name);
}
