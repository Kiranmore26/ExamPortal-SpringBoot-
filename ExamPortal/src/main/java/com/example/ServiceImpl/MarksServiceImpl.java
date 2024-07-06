package com.example.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Dto.MarksDto;
import com.example.Entities.MarksEntity;
import com.example.Entities.StudentEntity;
import com.example.Enum.Status;
import com.example.Repository.MarksRepository;
import com.example.Repository.StudentRepository;
import com.example.Services.MarkService;


import jakarta.servlet.http.HttpServletRequest;

@Service
public class MarksServiceImpl implements MarkService
{
	@Autowired
	MarksRepository marksRepository;

	@Autowired
	StudentRepository studentRepository;
	
	@Override
	public MarksEntity entermarks(MarksDto marksDto, HttpServletRequest httpServletRequest) 
	{
		
		MarksEntity marksEntity = new MarksEntity();
		
		StudentEntity studentEntity= new StudentEntity();
		
		 StudentEntity byStudentIdAndStudentStatus = studentRepository.findByStudentIdAndStudentStatus(marksDto.getStudentId(),Status.Active);
		
		if(byStudentIdAndStudentStatus==null)
		{
			throw new IllegalArgumentException("Id not found ");
		}
		
		marksEntity.setScore(marksDto.getScore());
		marksEntity.setGrade(marksDto.getGrade());
		marksEntity.setStudentId(byStudentIdAndStudentStatus);
		
		marksRepository.save(marksEntity);
		return null;
	}

	@Override
	public List<MarksEntity> displayMarks() 
	{
		// TODO Auto-generated method stub
		List<MarksEntity> marks = marksRepository.findAll();
		
		
		if(marks!=null)
		{
			List<StudentEntity> bystudentStatus = studentRepository.findBystudentStatus(Status.Active);
			
			if(bystudentStatus!=null)
			{
				return marks;				
			}
			else
			{
				throw new IllegalArgumentException("No Student is Active ");
			}
		}
		else
		{
			throw new IllegalArgumentException("Id not found ");
		}
		
	}

	@Override
	public MarksEntity displayById(Integer id) 
	{
		MarksEntity marks = marksRepository.findById(id).get();
		
		
		if(marks!=null)
		{
			return marks;
		}
		else
		{
			throw new IllegalArgumentException("Id not found ");
		}
	}

	@Override
	public MarksEntity update(MarksDto marksDto, Integer id) 
	{
		MarksEntity marksEntity = marksRepository.findById(id).get();
		if(marksEntity!=null)
		{
			marksEntity.setGrade(marksDto.getGrade());
			marksEntity.setScore(marksDto.getScore());
			marksRepository.save(marksEntity);
		}
		else
		{
			throw new IllegalArgumentException("Id not found ");
		}
		return null;
	}
}
