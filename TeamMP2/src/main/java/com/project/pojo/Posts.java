package com.project.pojo;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table (name = "posts")
public class Posts {
    
    
    
    @Column(name = "posts_time")
    private LocalDateTime time;
    
    
    public Posts(LocalDateTime time, String description, String post) {
        super();
        this.time = time;
        this.description = description;
        this.post = post;
    }
    
    
    
    
    
    
    
    @Column(name = "posts_description")
    private String description;
    
    
    @Column(name = "posts_post")
    private String post;
    
    public Users getHome() {
        return home;
    }
    public void setHome(Users home) {
        this.home = home;
    }
    @Id
    @Column(name = "posts_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    
    
    
    @ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name= "social_username")
    private Users home;
    
    
    
    /////////////////////////////////////////////////////////////////////////////////////////////////////
    
    @OneToMany(mappedBy = "cool",cascade = CascadeType.ALL, fetch=FetchType.LAZY )
    private Set<Comments> comments = new HashSet<>();
    
    
    @OneToMany(mappedBy = "likescool",cascade = CascadeType.ALL, fetch=FetchType.LAZY )
    private Set<Likes> likes = new HashSet<>();
    
    
    //////////////////////need to map by random private.....
    ///////////////////////////////////////////////////////////////////////////////////////////
    
    
    
    
    
    
    @Override
    public String toString() {
        return "Posts [time=" + time + ", description=" + description + ", post=" + post + ", id=" + id + ", getTime()="
                + getTime() + ", getDescription()=" + getDescription() + ", getPost()=" + getPost() + ", getId()="
                + getId() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
                + super.toString() + "]";
    }
    
    
    
    
    
    
    public LocalDateTime getTime() {
        return time;
    }
    public void setTime(LocalDateTime time) {
        this.time = time;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getPost() {
        return post;
    }
    public void setPost(String post) {
        this.post = post;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    
}
