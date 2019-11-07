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
@Table (name = "likesc")
public class LikesC {
    
    
    
    
    @Id
    @Column(name = "likesc_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int likeId;
    
    
    
    @Column(name = "likesc_username")
    private String username;
    
    
    
    
    
    
     @ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
     @JoinColumn(name= "comments_id")
     private Comments likesc;
     
     
     
     
     @ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
     @JoinColumn(name= "social_username")
     private Users likescusers;
    
    
    
    
    
    public LikesC(int likeId, String username) {
        super();
        this.likeId = likeId;
        this.username = username;
    }
    
    
    
    
    
    @Override
    public String toString() {
        return "LikesC [likeId=" + likeId + ", username=" + username + ", getLikeId()=" + getLikeId()
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





	public Comments getLikesc() {
		return likesc;
	}





	public void setLikesc(Comments likesc) {
		this.likesc = likesc;
	}





	public Users getLikescusers() {
		return likescusers;
	}





	public void setLikescusers(Users likescusers) {
		this.likescusers = likescusers;
	}
    
    
    
    
}
