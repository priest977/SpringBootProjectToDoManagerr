package com.todo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
public class FileController {
    Logger logger = LoggerFactory.getLogger(FileController.class);
    @PostMapping("/uploadSingle")
    public ResponseEntity<?> uploadFile(@RequestParam("image") MultipartFile file ){
        logger.info("File Name {} ",file.getName());
        logger.info("File Content {}" , file.getContentType());
        logger.info(" Original File Name {}",file.getOriginalFilename());
        logger.info("File Size {}" , file.getSize());
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
