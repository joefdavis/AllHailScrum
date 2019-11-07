package com.project.pojo;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table (name = "likesp")
public class Likes {
    
    
    
    @Id
    @Column(name = "likesp_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int likeId;
    
    
    @Column(name = "likesp_username")
    private String username;
    
    
    
    
     @ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
     @JoinColumn(name= "posts_id")
     private Posts likescool;
     
     
     
     
    





	public Posts getLikestousernamep() {
		return likestousernamep;
	}






	public void setLikestousernamep(Posts likestousernamep) {
		this.likestousernamep = likestousernamep;
	}
	@ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
     @JoinColumn(name= "social_username")
     private Posts likestousernamep;
    
    
    
    
    public Likes(int likeId, String username) {
        super();
        this.likeId = likeId;
        this.username = username;
    }
    
    
    
    
    
    
    @Override
    public String toString() {
        return "Likes [likeId=" + likeId + ", username=" + username + ", getLikeId()=" + getLikeId()
                + ", getUsername()=" + getUsername() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
                + ", toString()=" + super.toString() + "]";
    }
    public int getLikeId() {
        return likeId;
    }
    public void setLikeId(int likeId) {
        this.likeId = likeId;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    } 
    
    public Posts getLikescool() {
		return likescool;
	}






	public void setLikescool(Posts likescool) {
		this.likescool = likescool;
	}

    
}




