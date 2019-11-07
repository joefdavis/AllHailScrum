package com.project.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.UsersDao;
import com.project.pojo.Comments;
import com.project.pojo.Likes;
import com.project.pojo.LikesC;
import com.project.pojo.Posts;
import com.project.pojo.Users;
@Service
public class LoginService {
    
    
    private UsersDao br;
    
    public List <Users> getAll(){
        return br.getAll();
    }
    
    public List <Posts> getAllPosts(){
        return br.getAllPosts();
    }
    
    public Users getUsernameValue(String Username) {
    	System.out.println("we in the service my money");
    	System.out.println(Username);
        return br.getUsernameValue(Username);
    }
    
    public void InsertUser(Users b) {
    	System.out.println("service me mommy");
    	System.out.println(b);
        br.InsertUserInfo(b); 
    }
    
    public void InsertPost(Posts post) {
        br.InserPosts(post);
   }
    
    public void InsertComments(Comments comments) {
        br.InsertComment(comments);
   }
    
    public void InsertLikes(Likes likes) {
        br.InsertLike(likes);
   }
    
    public void InsertLikesC(LikesC likesc) {
        br.InsertLikeC(likesc);
   }
    
    
    @Autowired
    public void setBr(UsersDao br) {
        this.br = br;
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
