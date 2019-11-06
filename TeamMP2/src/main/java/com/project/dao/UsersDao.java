package com.project.dao;
import java.util.List;
import javax.persistence.Parameter;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import com.project.hibernateutil.HibernateUtil;
import com.project.pojo.Comments;
import com.project.pojo.Likes;
import com.project.pojo.LikesC;
import com.project.pojo.Posts;
import com.project.pojo.Users;
import org.hibernate.SessionFactory;
import org.hibernate.Criteria;
import org.hibernate.Query;
@Transactional
@Repository("loginDao")
public class UsersDao  {
    
    
    public UsersDao(){
        
    }
    
    
    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
//  
    private SessionFactory sesFact;
    
    @Autowired
    public UsersDao(SessionFactory sesFact) {
        super();
        this.sesFact = sesFact;
    }
    
    
    public void setSessoinFactory(SessionFactory sessionFactory) {
        this.sesFact=sessionFactory;
    }
    
    //insert username
    public void InsertUserInfo(Users b) {
        
        sesFact.getCurrentSession().save(b);        
    }
    
    //insert comment
        public void InsertComment(Comments com) {
            
            sesFact.getCurrentSession().save(com);      
        }
    
    //update the user 
    public void UpdateUsername(Users user) {
        sesFact.getCurrentSession().update(user);
    }
    
    
    
     //get all users
    public List<Users> getAll(){
        
        Session ses = sesFact.getCurrentSession();  
        String hql = "from Users";
        return ses.createQuery(hql, Users.class).list();
    }
    
    
    //////////////////////////////////////////////////////////////////////////////////////////////
    
    
    
    
    public Users getUsernameValue(String username){
        Session ses = sesFact.getCurrentSession();
        Users b = ses.get(Users.class, username);
        return b;
    }
    
    
    
    
    
    
    /////////////////////////////////////////////////////////////////////////////////////////////
    
    //insert a post
    public void InserPosts(Posts b){
        sesFact.getCurrentSession().save(b);
    }
    
    
    //insert a like, not sure if need this but might work okay
    public void InsertLike(Likes like){
        sesFact.getCurrentSession().save(like);
    }
    
    //insert like for comments
    public void InsertLikeC(LikesC like){
        sesFact.getCurrentSession().save(like);
        
        
    }
    
    
    
    //get all posts
    public List<Posts> getAllPosts(){
        
        Session ses = sesFact.getCurrentSession();  
        
        return ses.createQuery("from Posts ", Posts.class).list();
    }
    //get posts by username
    public List<Posts> getPostsByUsername(Posts p){
        Session ses = sesFact.getCurrentSession();  
        return ses.createQuery("from Posts where home like ? ", Posts.class).setParameter(1, p.getHome().getUsername()).list();   
    }
    
    
    
    //get user by username
    public Users getUserByUsername(String name) {
    	System.out.println("we in the dao");
        Session ses = sesFact.getCurrentSession();
        System.out.println("we in teh dao bitchessss");
        return ses.createQuery("from Users where username like ?1 ", Users.class).setParameter(1, name).getSingleResult();
    }
    
}




