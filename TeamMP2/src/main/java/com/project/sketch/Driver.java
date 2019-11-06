package com.project.sketch;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.project.dao.UsersDao;
import com.project.pojo.Users;
public class Driver {
    
    
    private static ApplicationContext ac = 
            new ClassPathXmlApplicationContext("applicationcontext.xml");
    
    
    
    private static UsersDao br = ac.getBean(UsersDao.class);
    
    
    
    public static void main(String[] args) {
        
        
        
        Users b1 = new Users("bob", "the", "builder@gmail.com", "I like eating cookies,"
                + "maaaaaaaaaaan", null, null);
        
        
        Users b2 = new Users("theD", "joe", "joe@gmail.com",null , null, null);
        
//      br.InsertUserInfo(b1);
//        br.UpdateUsername(b1);
        System.out.println(br.getUsernameValue("joeyjoey"));
        
    
}   
    
    
    
}
