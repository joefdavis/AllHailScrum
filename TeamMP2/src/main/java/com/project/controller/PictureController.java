package com.project.controller;

import java.io.ByteArrayOutputStream;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.project.service.S3Services;
 
 
@CrossOrigin(origins = "*")
@RestController
public class PictureController {
  
  public PictureController() {
	  System.out.println("picture");
	}
@Autowired
  S3Services s3Services;
  //UPLOAD
    @PostMapping("/upload.app")
    public String uploadMultipartFile(@RequestParam("file") MultipartFile file) {
      String username = imageName("name");  //TODO replace this with session
    s3Services.uploadFile(username, file);
    return "Upload Successfully -> KeyName = " + username;
    }
    
    public String uploadPostPic(MultipartFile file, String name) {
    s3Services.uploadFile(name, file);
    return "Upload Successfully -> KeyName = " + name;
    } 
  //DOWNLOAD PROFILE
    @GetMapping("/getProfilePic.app")
    public ResponseEntity<byte[]> downloadProfile() {
        String username = imageName("name"); //TODO replace this with session
      ByteArrayOutputStream downloadInputStream = s3Services.downloadFile(username);
    
      return ResponseEntity.ok()
            .contentType(contentType(username))
            .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=\"" + username + "\"")
            .body(downloadInputStream.toByteArray());
    }
    /*//DOWNLOAD POST
    @GetMapping("/getPostPic.app")
    public ResponseEntity<byte[]> downloadFile(@PathVariable String username) {
      ByteArrayOutputStream downloadInputStream = s3Services.downloadFile(username);
    
      return ResponseEntity.ok()
            .contentType(contentType(username))
            .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=\"" + username + "\"")
            .body(downloadInputStream.toByteArray());
    }*/

	private String imageName(String username) {
    return new String (username + ".jpeg");
}


    //GET IMAGE TYPE
    private MediaType contentType(String username) {
      String[] arr = username.split("\\.");
      String type = arr[arr.length-1];
      switch(type) {
        case "jpg": return MediaType.IMAGE_JPEG;
        default: return MediaType.APPLICATION_OCTET_STREAM;
      }
    }
    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver multipartResolver() 
    {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(20848820);
        return multipartResolver;
    }
    
}