package app;

import java.util.ArrayList;

public class Film {

    private String id;
    private String type;
    private String name;
    private String genre;
    private String date;
    private String desk;
    private Double rating;
    private String imdb;
    private ArrayList<Comment> comment = new ArrayList<Comment>();

    public Film (String id, String type, String name, String genre, String date, String desk, Double rating, String imdb) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.genre = genre;
        this.date = date;
        this.desk = desk;
        this.rating = rating;
        this.imdb = imdb;
    }

    public void addComment(String autor, String text, double rating) {
        comment.add(new Comment(autor, text, rating));
    }

    public ArrayList<Comment> getComment() {
        return comment;
    }

    public String getImdb() {
        return imdb;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public String getDate() {
        return date;
    }

    public String getDesk() {
        return desk;
    }

    public double getRating() {
        return rating;
    }
}
