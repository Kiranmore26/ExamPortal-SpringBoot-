package com.example.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Dto.PaperDto;
import com.example.Entities.PaperEntity;
import com.example.Entities.TeachersEntity;
import com.example.Enum.Status;
import com.example.Repository.PaperRepository;
import com.example.Repository.TeacherRepository;
import com.example.Services.PaperService;

import jakarta.servlet.http.HttpServletRequest;

@Service

public class PaperServiceImpl implements PaperService
{

	@Autowired
	PaperRepository paperRepository;
	
	@Autowired
	TeacherRepository teacherRepository;
	
	@Override
	public PaperEntity createPaper(PaperDto paperDto, HttpServletRequest httpServletRequest) 
	{
		PaperEntity paperEntity = new PaperEntity();
		TeachersEntity teachersEntity= new TeachersEntity();
		
		TeachersEntity byTeacherIdAndTeacherStatus = teacherRepository.findByTeacherIdAndTeacherStatus(paperDto.getTeachersId(), Status.Active);
		
		if(byTeacherIdAndTeacherStatus==null)
		{
			throw new IllegalArgumentException("Id not found ");
		}
		
		paperEntity.setPaperSubject(paperDto.getPaperSubject());
		paperEntity.setPaperSemester(paperDto.getPaperSemester());
		paperEntity.setPaperType(paperDto.getPaperType());
		paperEntity.setPaperStatus(Status.Active);
		paperEntity.setTeachersId(byTeacherIdAndTeacherStatus);
		
		paperRepository.save(paperEntity);
		
		return null;
	}

	
	@Override
	public List<PaperEntity> displayAll() 
	{
		// TODO Auto-generated method stub
		
		List<PaperEntity> byPaperStatus = paperRepository.findByPaperStatus(Status.Active);
		
		
		if(byPaperStatus!=null)
		{
			List<TeachersEntity> byTeacherStatus = teacherRepository.findByTeacherStatus(Status.Active);
			
			if(byTeacherStatus!=null)
			{	
				return paperRepository.findByPaperStatus(Status.Active);			
			}
			else
			{
				throw new IllegalArgumentException("No active teacher Found ");	
			}
		}
		else
		{
			throw new IllegalArgumentException("No active paper found  ");
		}
	}

	@Override
	public PaperEntity displayById(Integer id) 
	{
		// TODO Auto-generated method stub
		PaperEntity paperEntity = paperRepository.findByPaperIdAndPaperStatus(id,Status.Active);
		
		if(paperEntity!=null)
		{
			
			return paperEntity;
		}
		else
		{
			throw new IllegalArgumentException("Id not found ");
		}
		
	}

	@Override
	public PaperEntity delete(Integer id) 
	{
		// TODO Auto-generated method stub
		PaperEntity paperEntity = paperRepository.findById(id).get();
		if(paperEntity!=null)
		{
			paperEntity.setPaperStatus(Status.Inactive);
			paperRepository.save(paperEntity);
		}
		else
		{
			throw new IllegalArgumentException("Id not found ");
		}
		return null;
	}

	
	@Override
	public PaperEntity update(PaperDto paperDto, Integer id) 
	{
		// TODO Auto-generated method stub
		PaperEntity paperEntity = paperRepository.findById(id).get();
		
		TeachersEntity teachersEntity= new TeachersEntity();
		
		
		
		if(paperEntity!=null)
		{
			TeachersEntity byTeacherIdAndTeacherStatus = teacherRepository.findByTeacherIdAndTeacherStatus(paperDto.getTeachersId(), Status.Active);
			
			if(byTeacherIdAndTeacherStatus==null)
			{
				throw new IllegalArgumentException("Id not found ");
			}

			
			paperEntity.setPaperSubject(paperDto.getPaperSubject());
			paperEntity.setPaperSemester(paperDto.getPaperSemester());
			paperEntity.setPaperType(paperDto.getPaperType());
			paperEntity.setTeachersId(byTeacherIdAndTeacherStatus);
			paperEntity.setPaperStatus(Status.Active);
			
			paperRepository.save(paperEntity);
		}
		else
		{
			throw new IllegalArgumentException("Id not found ");
		}
		return null;
	}

}
