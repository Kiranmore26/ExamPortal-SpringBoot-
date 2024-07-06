package com.example.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PerviousYearPaper")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PreviousYearPaper 
{
	@Id
	@Column(name = "Id")
	private String perviousPaperId;

	@Column(name = "FileName")
	private String fileName;

	@Column(name = "FileType")
	private String fileType;

	@Column(name = "FilePath")
	private String filePath;
}
