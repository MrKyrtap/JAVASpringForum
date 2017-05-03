package com.grudnik.entities;

import javax.persistence.*;

/**
 * Created by PatrykGrudnik on 08/04/2017.
 */
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String name;
    @ManyToOne
    MainCategory category;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MainCategory getCategory() {
        return category;
    }

    public void setCategory(MainCategory category) {
        this.category = category;
    }
}
