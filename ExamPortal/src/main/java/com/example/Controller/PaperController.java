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

import com.example.Dto.PaperDto;
import com.example.Entities.PaperEntity;
import com.example.Enum.ResponseHandler;
import com.example.Services.PaperService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/paper")
@Validated
public class PaperController 
{
	@Autowired
	PaperService paperService;
	
	ResponseHandler responseHandler = new ResponseHandler();
	
	@PostMapping("/createPaper")
	public ResponseHandler createPaper(@Valid @RequestBody PaperDto paperDto,HttpServletRequest httpServletRequest)
	{ 
		try
		{
			PaperEntity paper = paperService.createPaper(paperDto, httpServletRequest);
			responseHandler.setStatus(true);
			responseHandler.setMessage("Paper Save Sucessfully");
		}
		catch(Exception e)
		{
			responseHandler.setStatus(false);
			responseHandler.setMessage(e.getMessage());
		}
		return responseHandler;	
	}
	
	
	
	
	@GetMapping("/displayPaper")
	public List<PaperEntity> displayAll()
	{
		return paperService.displayAll();
	}
	
	
	
	@GetMapping("/byIdPaper/{id}")
	public PaperEntity displayById(@PathVariable Integer id)
	{
		return paperService.displayById(id);	
	}
	
	
	
	
	@DeleteMapping("/deletePaper/{id}")
	public ResponseHandler delete(@PathVariable Integer id)
	{
		try
		{
			PaperEntity delete = paperService.delete(id);
			responseHandler.setStatus(true);
			responseHandler.setMessage("Paper Deleted Sucessfully");
		}
		catch(Exception e)
		{
			responseHandler.setStatus(false);
			responseHandler.setMessage(e.getMessage());
		}
		return responseHandler;	
	}
	
	
	@PutMapping("/updatePaper/{id}")
	public ResponseHandler update(@Valid @RequestBody PaperDto paperDto,@PathVariable Integer id)
	{
		try
		{
			PaperEntity update = paperService.update(paperDto, id);
			responseHandler.setStatus(true);
			responseHandler.setMessage("Paper Updated Sucessfully");
		}
		catch(Exception e)
		{
			responseHandler.setStatus(false);
			responseHandler.setMessage(e.getMessage());
		}
		return responseHandler;	
	}
}
