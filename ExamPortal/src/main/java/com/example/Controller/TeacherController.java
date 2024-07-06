package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Dto.TeachersDto;
import com.example.Entities.StudentEntity;
import com.example.Entities.TeachersEntity;
import com.example.Enum.ResponseHandler;
import com.example.Repository.TeacherRepository;
import com.example.Services.TeacherService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/Teacher")
@Validated
public class TeacherController 
{
	@Autowired
	TeacherService teacherService;
	
	ResponseHandler responseHandler = new ResponseHandler();
	
	@PostMapping("/createTeacher")
	public ResponseHandler createTeachers(@Valid @RequestBody TeachersDto teachersDto,HttpServletRequest httpServletRequest)
	{	
		try
		{
			TeachersEntity teachers = teacherService.createTeachers(teachersDto, httpServletRequest);
			responseHandler.setStatus(true);
			responseHandler.setMessage("Data Saved SucessFully ");
		}
		catch (Exception e) 
		{
			responseHandler.setStatus(false);
			responseHandler.setMessage(e.getMessage());
		}
		
		return responseHandler;
	}
	
	
	@GetMapping("/displayTeacher")
	public List<TeachersEntity> displayTeachersDetails()
	{
		return teacherService.displayTeachersDetails();
	}
	
	
	@GetMapping("/byidTeacher/{id}")
	public TeachersEntity displayById(@PathVariable Integer id)
	{
		return teacherService.displayById(id);
	}
	
	
	@DeleteMapping("/deleteTeacher/{id}")
	public ResponseHandler delete(@PathVariable Integer id)
	{	
		try
		{
			TeachersEntity delete = teacherService.delete(id);
			responseHandler.setStatus(true);
			responseHandler.setMessage("Data Deleted SucessFully ");
		}
		catch (Exception e) 
		{
			responseHandler.setStatus(false);
			responseHandler.setMessage(e.getMessage());
		}
		
		return responseHandler;
	}
	
	
	@PutMapping("/updateTeacher/{id}")
	public ResponseHandler update(@Valid @RequestBody TeachersDto teachersDto,@PathVariable Integer id) 
	{	
		try
		{
			TeachersEntity update = teacherService.update(teachersDto, id);
			responseHandler.setStatus(true);
			responseHandler.setMessage("Data Updated SucessFully ");
		}
		catch (Exception e) 
		{
			responseHandler.setStatus(false);
			responseHandler.setMessage(e.getMessage());
		}
		
		return responseHandler;
	}
	
	@GetMapping("/byNameTeacher/{Name}")
	public List<TeachersEntity> displayByName(@PathVariable String Name)
	{
		return teacherService.displayByName(Name);
	}
	
}
