package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Dto.MarksDto;
import com.example.Entities.MarksEntity;
import com.example.Enum.ResponseHandler;
import com.example.Services.MarkService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/marks")
public class MarksController 
{
	@Autowired
	MarkService markService;

	
	ResponseHandler responseHandler = new ResponseHandler();
	
	@PostMapping("/createmarks")
	public ResponseHandler createMarks(@RequestBody MarksDto marksDto,HttpServletRequest httpServletRequest)
	{
		
		try 
		{
			MarksEntity entermarks = markService.entermarks(marksDto, httpServletRequest);
			responseHandler.setStatus(true);
			responseHandler.setMessage("Marks data Saved");
		}
		catch(Exception e)
		{
			responseHandler.setStatus(false);
			responseHandler.setMessage(e.getMessage());
		}
		return responseHandler;
	}
	
	
	@GetMapping("/displayall")
	public List<MarksEntity> displayAll()
	{
		return markService.displayMarks();
	}
	
	@GetMapping("/ById/{id}")
	public MarksEntity displayById(@PathVariable Integer id)
	{
		return markService.displayById(id);
	}
	
	@PutMapping("/update/{id}")
	public ResponseHandler update(@RequestBody MarksDto marksDto,@PathVariable Integer id)
	{
		try 
		{
			MarksEntity update = markService.update(marksDto, id);
			responseHandler.setStatus(true);
			responseHandler.setMessage("Marks Data Updated");
		}
		catch(Exception e)
		{
			responseHandler.setStatus(false);
			responseHandler.setMessage(e.getMessage());
		}
		return responseHandler;
	}
}
