package com.example.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Dto.StudentDto;
import com.example.Entities.StudentEntity;
import com.example.Enum.Status;
import com.example.Repository.StudentRepository;
import com.example.Services.StudentService;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class StudentServiceImpl implements StudentService
{
	@Autowired
	StudentRepository studentRepository;

	
	@Override
	public StudentEntity createStudent(StudentDto studentDto, HttpServletRequest httpServletRequest) 
	{
		StudentEntity studentEntity = new StudentEntity();
		
		studentEntity.setStudentName(studentDto.getStudentName());
		studentEntity.setStudentClass(studentDto.getStudentClass());
		studentEntity.setStudentAge(studentDto.getStudentAge());
		studentEntity.setStudentCity(studentDto.getStudentCity());
		studentEntity.setStudentGmail(studentDto.getStudentGmail());
		studentEntity.setStudentMobileNo(studentDto.getStudentMobileNo());
		studentEntity.setStudentGender(studentDto.getStudentGender());
		studentEntity.setStudentStatus(Status.Active);
		studentRepository.save(studentEntity);
		return null;
	}


	@Override
	public List<StudentEntity> displayStudentDetails() 
	{
		// TODO Auto-generated method stub
		 List<StudentEntity> bystudentStatus = studentRepository.findBystudentStatus(Status.Active);
		 
		 if(bystudentStatus!=null)
		 {
			 return studentRepository.findBystudentStatus(Status.Active);
			 
		 }
		 else
		 {
			 throw new IllegalArgumentException("id not found");
		 }
		
	}


	@Override
	public StudentEntity displayById(Integer id) 
	{
		// TODO Auto-generated method stub
		StudentEntity studentEntity = studentRepository.findByStudentIdAndStudentStatus(id,Status.Active);
		
		if(studentEntity!=null)
		{
			if(studentEntity.getStudentStatus()==Status.Active)
			{
				return studentRepository.findByStudentIdAndStudentStatus(id,Status.Active);
			}
			else
			{
				throw new IllegalArgumentException("Id Not Found");		
			}
		}
		else
		{
			throw new IllegalArgumentException("Id Not Found");		
		}
		
	}


	@Override
	public StudentEntity delete(Integer id) 
	{
		
		// TODO Auto-generated method stub
		StudentEntity studentEntity = studentRepository.findByStudentIdAndStudentStatus(id,Status.Active);
		
		if(studentEntity!=null)
		{
			if(studentEntity.getStudentStatus()==Status.Active)
			{
				studentEntity.setStudentStatus(Status.Inactive);
				studentRepository.save(studentEntity);
			}
			else
			{
				throw new IllegalArgumentException("Id Not Found");		
			}	
		}
		else
		{
			throw new IllegalArgumentException("Id Not found");
		}
		return null;
	}


	@Override
	public StudentEntity update(StudentDto studentDto, Integer id) 
	{
		// TODO Auto-generated method stub
		
		StudentEntity Byid = studentRepository.findById(id).get();
		
		if(Byid!=null)
		{
			Byid.setStudentName(studentDto.getStudentName());
			Byid.setStudentClass(studentDto.getStudentClass());
			Byid.setStudentAge(studentDto.getStudentAge());
			Byid.setStudentCity(studentDto.getStudentCity());
			Byid.setStudentGmail(studentDto.getStudentGmail());
			Byid.setStudentMobileNo(studentDto.getStudentMobileNo());
			Byid.setStudentGender(studentDto.getStudentGender());
			Byid.setStudentStatus(Status.Active);
			
			studentRepository.save(Byid);
		}
		else
		{
			throw new IllegalArgumentException("Id Not Found ");
		}
		return null;
	}


	@Override
	public List<StudentEntity> displayByName(String Name) 
	{
		// TODO Auto-generated method stub
		List<StudentEntity> byStudentNameAndStudentStatus = studentRepository.findByStudentNameAndStudentStatus(Name,Status.Active);
		
		if(byStudentNameAndStudentStatus!=null)
		{
			
			return byStudentNameAndStudentStatus;
		}
		else
		{
			throw new IllegalArgumentException("Name Not Found");
		}
	}
}
