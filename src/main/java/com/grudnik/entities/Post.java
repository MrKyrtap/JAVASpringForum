package com.grudnik.entities;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by PatrykGrudnik on 16/04/2017.
 */
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @NotNull
    String text;
    Date date;
    @ManyToOne
    Topic topic;
    @ManyToOne
    User autor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public User getAutor() {
        return autor;
    }

    public void setAutor(User autor) {
        this.autor = autor;
    }
}
