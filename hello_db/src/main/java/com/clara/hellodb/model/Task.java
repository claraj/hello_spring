package com.clara.hellodb.model;

import java.util.Date;

import javax.persistence.*;

/**
 * Created by clara on 3/30/18.
 */

@Entity
public class Task {
    
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    
    private String text;
    
    private boolean urgent;
    
    private Date dateCreated;
    
    public Task() { }   // empty constructor, you need this
    
    public Task(String text, boolean urgent, Date dateCreated) {
        this.text = text;
        this.urgent = urgent;
        this.dateCreated = dateCreated;
    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isUrgent() {
        return urgent;
    }

    public void setUrgent(boolean urgent) {
        this.urgent = urgent;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
//
    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", urgent=" + urgent +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
