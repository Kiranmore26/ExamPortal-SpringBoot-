package com.example.Services;

import java.util.List;

import com.example.Dto.MarksDto;
import com.example.Entities.MarksEntity;

import jakarta.servlet.http.HttpServletRequest;

public interface MarkService 
{
	public MarksEntity entermarks (MarksDto marksDto,HttpServletRequest httpServletRequest);
	
	public List<MarksEntity> displayMarks();
	
	public MarksEntity displayById(Integer id);
	
	public MarksEntity update(MarksDto marksDto,Integer id);
}


