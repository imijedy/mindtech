package com.mindtech.domain;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "artists")
public class Artist {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "name", nullable = false)
    @JsonProperty("name")
    private String name;

    @Column(name = "genre", nullable = false)
    @JsonProperty("genre")
    private String genre;

    @Column(name = "formed_year", nullable = false)
    @JsonProperty("formedYear")
    private Date formedYear;

    @Column(name = "biography", nullable = false)
    @JsonProperty("biography")
    private String biography;

    /*Konstruktor*/

    private Artist(){}

    public Artist(String name, String genre, Date formedYear, String biography) {
        this.name = name;
        this.genre = genre;
        this.formedYear = formedYear;
        this.biography = biography;
    }

    /*Getterek, Setterek*/

    public Long getId() {
        return id;
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
}
