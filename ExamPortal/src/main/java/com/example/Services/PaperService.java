package com.example.Services;

import java.util.List;

import com.example.Dto.PaperDto;
import com.example.Entities.PaperEntity;

import jakarta.servlet.http.HttpServletRequest;

public interface PaperService 
{
	public PaperEntity createPaper(PaperDto paperDto,HttpServletRequest httpServletRequest);
	
	public  List<PaperEntity> displayAll ();
	
	public PaperEntity displayById(Integer id);

	public PaperEntity delete(Integer id);

	public PaperEntity update(PaperDto paperDto, Integer id);
	
	
}
