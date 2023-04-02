package by.itclass.model.beans;

import java.util.Date;

public class News {
    private int id;
    private String title;
    private String text;
    private User user;
    private Date date;
    private int likes;

    public News() {
    }

    public News(int id) {
        this.id = id;
    }

    public News(String title, String text, User user) {
        this.title = title;
        this.text = text;
        this.user = user;
    }

    public News(int id, String title, String text) {
        this.id = id;
        this.title = title;
        this.text = text;
    }

    public News(int id, String title, String text, User user, Date date) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.user = user;
        this.date = date;
    }

    public News(int id, String title, String text, Date date, int likes) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.date = date;
        this.likes = likes;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
