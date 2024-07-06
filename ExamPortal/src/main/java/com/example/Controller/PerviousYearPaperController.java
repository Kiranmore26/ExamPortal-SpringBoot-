package com.example.Controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.example.Entities.PreviousYearPaper;
import com.example.Services.PreviousYearPaperService;

@RestController
public class PerviousYearPaperController 
{
    @Autowired
    PreviousYearPaperService previousYearPaperService;

    @PostMapping(value = "/uploadfile", produces = "application/json")
    public ResponseEntity<?> uploadfile(@RequestParam("file") MultipartFile file) throws Exception 
    {
        try 
        {
            PreviousYearPaper savefile = previousYearPaperService.savefile(file);
            return ResponseEntity.ok(savefile);
        } 
        catch (IOException e) 
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to load the file: " + e.getMessage());
        }
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<Resource> downloadfile(@PathVariable String id) 
    {
        PreviousYearPaper yearPaper = previousYearPaperService.findById(id);
        if (yearPaper == null) 
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        Path path = Paths.get(yearPaper.getFilePath());
        try 
        {
            FileInputStream inputStream = new FileInputStream(path.toFile());
            InputStreamResource resource = new InputStreamResource(inputStream);

            String mediaType = Files.probeContentType(path);
            if (mediaType == null) 
            {
                mediaType = MediaType.APPLICATION_OCTET_STREAM_VALUE;
            }

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + yearPaper.getFileName());
            headers.add(HttpHeaders.CONTENT_TYPE, mediaType);

            return ResponseEntity.ok().headers(headers).body(resource);
        } 
        catch (Exception e) 
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
