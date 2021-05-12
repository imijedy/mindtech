package com.mindtech.domain;


import java.util.Date;

public class ShowArtistWrapper {

    /*Adattagok*/
    private Long id;
    private String name;
    private String genre;
    private Date formedYear;
    private String biography;
    private Integer albumNumber;

    /*Konstruktor*/

    public ShowArtistWrapper() {
    }

    public ShowArtistWrapper(Long id, String name, String genre, Date formedYear, String biography, Integer albumNumber) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.formedYear = formedYear;
        this.biography = biography;
        this.albumNumber = albumNumber;
    }

    /*Getterek, Setterek*/

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Date getFormedYear() {
        return formedYear;
    }
    public void setFormedYear(Date formedYear) {
        this.formedYear = formedYear;
    }

    public String getBiography() {
        return biography;
    }
    public void setBiography(String biography) {
        this.biography = biography;
    }

    public Integer getAlbumNumber() {
        return albumNumber;
    }
    public void setAlbumNumber(Integer albumNumber) {
        this.albumNumber = albumNumber;
    }
}
