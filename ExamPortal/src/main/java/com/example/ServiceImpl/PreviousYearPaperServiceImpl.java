package com.example.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.example.Entities.PreviousYearPaper;
import com.example.Repository.PreviousYearPaperRepository;
import com.example.Services.PreviousYearPaperService;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class PreviousYearPaperServiceImpl implements PreviousYearPaperService 
{
    private static final String uploadDirectory = "D:\\SpringBoot(Workspace)\\ExamPortal\\src\\main\\resources\\static";

    @Autowired
    PreviousYearPaperRepository previousYearPaperRepository;

    @Override
    public PreviousYearPaper savefile(MultipartFile file) throws Exception 
    {
        String fileName = file.getOriginalFilename();
        String fileExtension = getFileExtension(fileName);
        String storedFileName = UUID.randomUUID().toString() + "." + fileExtension;

        Path path = Paths.get(uploadDirectory + File.separator + storedFileName);
        Files.write(path, file.getBytes());

        PreviousYearPaper yearPaper = new PreviousYearPaper();
        yearPaper.setPerviousPaperId(UUID.randomUUID().toString());
        yearPaper.setFileName(fileName);
        yearPaper.setFileType(file.getContentType());
        yearPaper.setFilePath(path.toString());

        return previousYearPaperRepository.save(yearPaper);
    }

    @Override
    public String getFileExtension(String fileName) 
    {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }

    @Override
    public PreviousYearPaper findById(String id) 
    {
        return previousYearPaperRepository.findById(id).orElse(null);
    }
}
