package com.snacourse.gisheh.model;

public class Film {
    private int id;
    private String filmURL;

    private int rank;
    private String title;

    private int weeks;
    private int saloonNumber;
    private String weeklySale;
    private String totalsale;

    public String getFilmURL() {
        return filmURL;
    }

    public void setFilmURL(String filmURL) {
        this.filmURL = filmURL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getWeeks() {
        return weeks;
    }

    public void setWeeks(int weeks) {
        this.weeks = weeks;
    }

    public int getSaloonNumber() {
        return saloonNumber;
    }

    public void setSaloonNumber(int saloonNumber) {
        this.saloonNumber = saloonNumber;
    }

    public String getWeeklySale() {
        return weeklySale;
    }

    public void setWeeklySale(String weeklySale) {
        this.weeklySale = weeklySale;
    }

    public String getTotalsale() {
        return totalsale;
    }

    public void setTotalsale(String totalsale) {
        this.totalsale = totalsale;
    }
}
