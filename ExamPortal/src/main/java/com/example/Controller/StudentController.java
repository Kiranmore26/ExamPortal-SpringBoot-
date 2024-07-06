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

import com.example.Dto.StudentDto;
import com.example.Entities.StudentEntity;
import com.example.Enum.ResponseHandler;
import com.example.Services.StudentService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/Student")
@Validated
public class StudentController 
{
	@Autowired
	StudentService studentService;
	
	ResponseHandler responseHandler = new ResponseHandler();
	
	@PostMapping("/createStudent")
	public ResponseHandler createStudent(@Valid @RequestBody StudentDto studentDto,HttpServletRequest httpServletRequest)
	{
		try
		{
			StudentEntity student = studentService.createStudent(studentDto, httpServletRequest);
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
	
	
	
	@GetMapping("/displayStudent")
	public List<StudentEntity> displayStudentDetails()
	{
		return studentService.displayStudentDetails();
		
	}
	
	
	@GetMapping("/byidStudent/{id}")
	public StudentEntity displayById(@PathVariable Integer id)
	{
		return studentService.displayById(id);		
	}
	
	
	@DeleteMapping("/deleteStudent/{id}")
	public ResponseHandler delete(@PathVariable Integer id)
	{
		try
		{
			StudentEntity delete = studentService.delete(id);
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
	
	
	@PutMapping("/updateStudent/{id}")
	public ResponseHandler update(@Valid @RequestBody StudentDto studentDto,@PathVariable Integer id)
	{
		try
		{
			StudentEntity update = studentService.update(studentDto, id);
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
	
	
	
	@GetMapping("/byNameStudent/{Name}")
	public List<StudentEntity> displayByName(@PathVariable String Name)
	{
		return studentService.displayByName(Name);
	}
}
