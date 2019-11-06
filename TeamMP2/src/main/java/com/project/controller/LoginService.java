package com.project.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.UsersDao;
import com.project.pojo.Users;
@Service
public class LoginService {
    
    
    private UsersDao br;
    
    public List <Users> getAll(){
        return br.getAll();
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
    
    
    @Autowired
    public void setBr(UsersDao br) {
        this.br = br;
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
