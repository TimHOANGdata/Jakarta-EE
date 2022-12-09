package com.mycompany.poe20221107.ecommerce.model;

public class Article {
    private int id;
    private String name;

    public Article() {
    }
    public Article(String name) {
        this.name = name;
    }
    
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
    
    
    
}