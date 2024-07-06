package com.example.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Dto.TeachersDto;
import com.example.Entities.StudentEntity;
import com.example.Entities.TeachersEntity;
import com.example.Enum.Status;
import com.example.Repository.TeacherRepository;
import com.example.Services.TeacherService;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class TeacherServiceImpl implements TeacherService
{
	@Autowired
	TeacherRepository teacherRepository;

	@Override
	public TeachersEntity createTeachers(TeachersDto teachersDto, HttpServletRequest httpServletRequest) 
	{
		// TODO Auto-generated method stub
		TeachersEntity teachersEntity = new TeachersEntity();
		teachersEntity.setTeacherName(teachersDto.getTeacherName());
		teachersEntity.setTeacherAge(teachersDto.getTeacherAge());
		teachersEntity.setTeacherCity(teachersDto.getTeacherCity());
		teachersEntity.setTeacherGmail(teachersDto.getTeacherGmail());
		teachersEntity.setTeacherMobileNo(teachersDto.getTeacherMobileNo());
		teachersEntity.setTeacherStatus(Status.Active);
		
		teacherRepository.save(teachersEntity);
		
		return null;
	}

	
	
	@Override
	public List<TeachersEntity> displayTeachersDetails() 
	{
		List<TeachersEntity> byTeacherStatus = teacherRepository.findByTeacherStatus(Status.Active);
		
		if(byTeacherStatus!=null)
		{
			return teacherRepository.findByTeacherStatus(Status.Active);
		}
		else
		{
			throw new IllegalArgumentException("Id not Found");
		}
		
		
	}

	
	@Override
	public TeachersEntity displayById(Integer id) 
	{
		// TODO Auto-generated method stub
		TeachersEntity teachersEntity = teacherRepository.findByTeacherIdAndTeacherStatus(id,Status.Active);
		
		if(teachersEntity!=null)
		{
			if(teachersEntity.getTeacherStatus()==Status.Active)
			{
				return teacherRepository.findByTeacherIdAndTeacherStatus(id,Status.Active);
			}
			else
			{
				throw new IllegalArgumentException("Id not Found");				
			}
		}
		else
		{
			throw new IllegalArgumentException("Id not Found");
		}
		
	}



	@Override
	public TeachersEntity delete(Integer id) 
	{
		// TODO Auto-generated method stub
		
		TeachersEntity teachersEntity = teacherRepository.findById(id).get();
		if(teachersEntity!=null)
		{
			teachersEntity.setTeacherStatus(Status.Inactive);
			teacherRepository.save(teachersEntity);
		}
		else
		{
			throw new IllegalArgumentException("Id not found");
		}
		return null;
	}



	@Override
	public TeachersEntity update(TeachersDto teachersDto, Integer id) 
	{
		// TODO Auto-generated method stub
		TeachersEntity teachersEntity = teacherRepository.findById(id).get();
		
		if(teachersEntity!=null)
		{
			teachersEntity.setTeacherName(teachersDto.getTeacherName());
			teachersEntity.setTeacherAge(teachersDto.getTeacherAge());
			teachersEntity.setTeacherCity(teachersDto.getTeacherCity());
			teachersEntity.setTeacherGmail(teachersDto.getTeacherGmail());
			teachersEntity.setTeacherMobileNo(teachersDto.getTeacherMobileNo());
			teachersEntity.setTeacherStatus(Status.Active);
			
			teacherRepository.save(teachersEntity);
		}
		else
		{
			throw new IllegalArgumentException("Id not found");
		}
		return null;
	}



	@Override
	public List<TeachersEntity> displayByName(String Name) 
	{
		// TODO Auto-generated method stub
		List<TeachersEntity> byTeacherNameAndTeacherStatus = teacherRepository.findByTeacherNameAndTeacherStatus(Name,Status.Active);  
		
		if(byTeacherNameAndTeacherStatus!=null)
		{
			return byTeacherNameAndTeacherStatus;
		}
		else
		{
			throw new IllegalArgumentException("Name Not Found ");
		}
		
	}

}
