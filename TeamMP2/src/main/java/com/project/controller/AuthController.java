package com.project.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.pojo.Users;


@Controller
@CrossOrigin(origins="*")
@RequestMapping(value="/auth")
public class AuthController {
	 Logger LOGGER=LoggerFactory.getLogger(AuthController.class);
    private LoginService ls;
    @PostMapping(value="/login.app")
    public @ResponseBody Users login(@RequestBody Users user) {
        System.out.println("inside login method in auth controller");
//        System.out.println("inside user controller update method" + username);
//        return us.getByUsername(username);
        System.out.println(ls.getAll());
        System.out.println(user.getUsername());
        for(Users u : ls.getAll()) {
            System.out.println("inside for loop of login method in auth controller");
            if(u.getUsername().equals(user.getUsername())) {
                System.out.println("inside if statement of login auth controller");
                System.out.println(u);
                System.out.println(u.getUsername());
                LOGGER.info("we have a logger!!! and they are " + u.getUsername());
                return u;
            }
        }
        return null;
    }
    public LoginService getUs() {
        return ls;
    }
    @Autowired
    public void setUs(LoginService ls) {
        this.ls = ls;
    }
    
    
}
