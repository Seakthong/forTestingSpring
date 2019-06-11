package com.test.nothing.repository.model;

import org.springframework.beans.factory.annotation.Autowired;

public class Article {

    private int id;
    private String title;
    private String description;
    private String author;
    private String create_date;
    private String thumbnail;
    private int status = 1;
    private int category_id;

    @Autowired
    private Category category;

    public Article() {
    }

    public Article(String title, String description, String author, String create_date, String thumbnail, int category_id) {
        this.title = title;
        this.description = description;
        this.author = author;
        this.create_date = create_date;
        this.thumbnail = thumbnail;
        this.category_id = category_id;
    }

//    public Article(int id, String title, String description, String author, String create_date, String thumbnail, int category_id) {
//        this.id = id;
//        this.title = title;
//        this.description = description;
//        this.author = author;
//        this.create_date = create_date;
//        this.thumbnail = thumbnail;
//        this.category_id = category_id;
//    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", author='" + author + '\'' +
                ", create_date='" + create_date + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", name='" + category.getName() + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
