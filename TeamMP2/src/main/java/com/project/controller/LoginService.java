package com.project.controller;
import com.project.dao.UsersDao;
import com.project.pojo.Users;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
public class LoginService {
    
    
    private UsersDao br;
    
    public List <Users> getAll(){
        return br.getAll();
    }
    
    public Users getUsernameValue(String Username) {
        return br.getUsernameValue(Username);
    }
    
    public void InsertUser(Users b) {
        br.InsertUserInfo(b); 
    }
    
    
    @Autowired
    public void setBr(UsersDao br) {
        this.br = br;
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
