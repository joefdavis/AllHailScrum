package com.project.controller;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.pojo.Comments;
import com.project.pojo.Likes;
import com.project.pojo.LikesC;
import com.project.pojo.Posts;
import com.project.pojo.Users;
@Controller
@RequestMapping(value="/users")
@CrossOrigin(origins="*")
public class LoginController {
	private static final Logger LOGGER=LoggerFactory.getLogger(LoginController.class);
   
    private LoginService login;
    @GetMapping(value="getAll.app")
    public ResponseEntity<List<Users>> getAll(){
        return new ResponseEntity<List<Users>>(login.getAll(), HttpStatus.OK);
    }
    //add get all posts
    
    @GetMapping(value="getAllPosts.app")
    public ResponseEntity<List<Posts>> getAllPosts(){
        return new ResponseEntity<List<Posts>>(login.getAllPosts(), HttpStatus.OK);
    }
    
    
    
    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////verify login/////////////////////////////////////////////////////
    @PostMapping(value="/login.app")
    public @ResponseBody Users getUserLogin(@RequestBody Users u) {

    	
        System.out.println(u);
        LOGGER.info("we have a logger!!! and they are " + u.getUsername());
      Users newu=login.getUsernameValue(u.getUsername());
       System.out.println("raptar motherrrr FUUUUUUU");
       if(u.getPassword().equals(newu.getPassword())) {
    	   LOGGER.info("we have a logger!!! and they are " + u.getUsername());
    	   return u;
       }
        return null;
    }
    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////// inserting information //////////////////////////////////////////////////////
    @PostMapping(value="/post.app")
    public @ResponseBody Users InsertUser(@RequestBody Users u) {
        System.out.println(u);
        login.InsertUser(u);
        return u;
    }
    
    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////Inserting Post////////////////////////////////////////////////////////////
    @PostMapping(value="/userposts.app")
    public @ResponseBody Posts insert(@RequestBody Posts post) {
        System.out.println(post);
        login.InsertPost(post);
        return post;
    }
    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////Inserting Comments////////////////////////////////////////////////////////////
    @PostMapping(value="/usercomments.app")
    public @ResponseBody Comments insert(@RequestBody Comments comments) {
        System.out.println(comments);
        login.InsertComments(comments);
        return comments;
    }
    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////Inserting likes////////////////////////////////////////////////////////////
    @PostMapping(value="/userlikes.app")
    public @ResponseBody Likes insert(@RequestBody Likes likes) {
        System.out.println(likes);
        login.InsertLikes(likes);
        return likes;
    }
    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////Inserting LikesC////////////////////////////////////////////////////////////
    @PostMapping(value="/userlikesc.app")
    public @ResponseBody LikesC insert(@RequestBody LikesC likesc) {
        System.out.println(likesc);
        login.InsertLikesC(likesc);
        return likesc;
    }
    
    @PostMapping(value="/updateuser.app")
	public @ResponseBody Users update(@RequestBody Users up) {
    	System.out.println(up);
    	login.UpdateUser(up);
    	return up;
    }
    
    public void Logger(String name) {
    	 LOGGER.info("we have a logger!!! and they are " + name);
    }
    public LoginService getLogin() {
        return login;
    }
    
    
    @Autowired
    public void setLogin(LoginService login) {
        this.login = login;
    }
    

    public LoginController() {
        System.out.println("controller");
    }
    
}
