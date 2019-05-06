package app;

import java.util.Date;

public class Comment {
    private Date date;
    private String autor;
    private String text;
    private double rating;


    public Comment(String autor, String text, double rating) {
        this.date = new Date();
        this.autor = autor;
        this.text = text;
        this.rating = rating;
    }

    public Date getDate() {
        return date;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
