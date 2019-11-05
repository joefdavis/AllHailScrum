package com.project.pojo;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table (name = "comments")
public class Comments {
    
    @Override
    public String toString() {
        return "Comments [time=" + time + ", description=" + description + ", id=" + id + ", getTime()=" + getTime()
                + ", getDescription()=" + getDescription() + ", getId()=" + getId() + ", getClass()=" + getClass()
                + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
    }
    
    
    @Column(name = "comments_time")
    private LocalDateTime time;
    
    @Column(name = "comments_description")
    private String description;
    
    @Id
    @Column(name = "comments_id")
    private int id;
    
    
    
    
     @ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
     @JoinColumn(name= "posts_id")
     private Posts cool;
        
     
     
     
     
     @OneToMany(mappedBy = "likesc",cascade = CascadeType.ALL, fetch=FetchType.LAZY )
     private Set<LikesC> likesc = new HashSet<>();
        
    
    
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
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
