package com.project.controller;

import java.io.ByteArrayOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project.service.S3Services;
 
 
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PictureController {
  
  @Autowired
  S3Services s3Services;
  //UPLOAD
    @PostMapping("/upload")
    public String uploadMultipartFile(@RequestParam("file") MultipartFile file) {
      String username = "name";  //TODO replace this with session
    s3Services.uploadFile(username, file);
    return "Upload Successfully -> KeyName = " + username;
    }    
    //DOWNLOAD
    @GetMapping("/getProfilePic")
    public ResponseEntity<byte[]> downloadFile(@PathVariable String username) {
      ByteArrayOutputStream downloadInputStream = s3Services.downloadFile(username);
    
      return ResponseEntity.ok()
            .contentType(contentType(username))
            .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=\"" + username + "\"")
            .body(downloadInputStream.toByteArray());
    }
    //GET IMAGE TYPE
    private MediaType contentType(String username) {
      String[] arr = username.split("\\.");
      String type = arr[arr.length-1];
      switch(type) {
        case "png": return MediaType.IMAGE_PNG;
        case "jpg": return MediaType.IMAGE_JPEG;
        default: return MediaType.APPLICATION_OCTET_STREAM;
      }
    }
}