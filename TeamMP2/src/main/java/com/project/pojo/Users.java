package com.project.pojo;
import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table (name = "social_users")
public class Users {
    
    
//    
    
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column (name = "social_id" , updatable = false, nullable = false)
////
//    private int id;
    
    
    
  @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "social_username", unique = true)
    private String username;
    
    
    @JsonIgnore
    @OneToMany(mappedBy = "home",cascade = CascadeType.ALL, fetch=FetchType.LAZY )
    private Set<Posts> posts = new HashSet<>();
    
    
    @JsonIgnore
     @OneToMany(mappedBy = "likestousernamep",cascade = CascadeType.ALL, fetch=FetchType.LAZY )
     private Set<Likes> likes = new HashSet<>();
     
  
    @JsonIgnore
     @OneToMany(mappedBy = "likescusers",cascade = CascadeType.ALL, fetch=FetchType.LAZY )
     private Set<LikesC> likec = new HashSet<>();
     
 
    
    @Column(name = "social_password")
    private String password;
    
    
    @Column(name = "social_email", unique = true)
    private String email;
    
    
    @Column(name = "social_description")
    private String description; 
    
    
    @Column(name = "social_profile")
    //this is where the profile picture will go
    private String profile;
    
    
    @Column(name = "social_birthday")
    private Date brithday;
//  
//  @Id
//  @Column (name = "social_id", columnDefinition = "serial")
//  @Generated(GenerationTime.INSERT)
//  private int id;
    
    public Users() {     
    }
    
    
    public Users(String username, String password, String email, String description, String profile, Date brithday) {
        super();
        this.username = username;
        this.password = password;
        this.email = email;
        this.description = description;
        this.profile = profile;
        this.brithday = brithday;
    }
    
    
    
    
    
    
    
//    public int getId() {
//        return id;
//    }
//    public void setId(int id) {
//        this.id = id;
//    }
    
    
    
    
    
    
    
    
    @Override
    public String toString() {
        return "Users [username=" + username + ", password=" + password + ", email=" + email + ", description="
                + description + ", profile=" + profile + ", brithday=" + brithday  + "]";
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getProfile() {
        return profile;
    }
    public void setProfile(String profile) {
        this.profile = profile;
    }
    public Date getBrithday() {
        return brithday;
    }
    public void setBrithday(Date brithday) {
        this.brithday = brithday;
    }
    public Set<Posts> getPosts() {
        return posts;
    }
    public void setPosts(Set<Posts> posts) {
        this.posts = posts;
    }
    
}