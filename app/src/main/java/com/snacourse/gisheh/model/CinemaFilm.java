package com.snacourse.gisheh.model;

public class CinemaFilm {

    private int id;
    private String title;
    private String director;
    private String reserveUrl;
    private String posterURl;

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


    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getReserveUrl() {
        return reserveUrl;
    }

    public void setReserveUrl(String reserveUrl) {
        this.reserveUrl = reserveUrl;
    }

    public String getPosterURl() {
        return posterURl;
    }

    public void setPosterURl(String posterURl) {
        this.posterURl = posterURl;
    }
}
