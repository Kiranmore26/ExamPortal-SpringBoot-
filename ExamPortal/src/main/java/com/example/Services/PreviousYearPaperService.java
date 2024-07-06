package com.example.Services;

import org.springframework.web.multipart.MultipartFile;

import com.example.Entities.PreviousYearPaper;


public interface PreviousYearPaperService 
{
	PreviousYearPaper savefile(MultipartFile file) throws Exception;
	
	String getFileExtension(String fileName);

	PreviousYearPaper findById(String id);
}
