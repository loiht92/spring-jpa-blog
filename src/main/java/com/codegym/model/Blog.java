package com.codegym.model;

import javax.persistence.*;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String bloggers;
    private String content;

    @ManyToOne
    @JoinColumn //Join voi bang title.
    private Category category; // Moi quan he nhieu - mot thi phai them thuoc tinh cua bang ma muon join den.

    public Category getCategory() {
        return (category == null) ? new Category() : category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Blog(){
    }

    public Blog(String content, String bloggers, String name){
        this.content = content;
        this.bloggers = bloggers;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getBloggers() {
        return bloggers;
    }

    public void setBloggers(String bloggers) {
        this.bloggers = bloggers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}