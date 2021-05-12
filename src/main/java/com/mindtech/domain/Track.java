package com.mindtech.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
public class Track {

    /*Adattagok*/

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @ManyToOne
    @JsonProperty("album")
    @JsonBackReference
    @JoinColumn(name = "album_album_id")
    private Album album;

    @ManyToOne
    @JsonIgnore
    private Artist artist;

    @Column(name = "duration", nullable = false)
    @JsonProperty("duration")
    private Double duration;

    @Column(name = "genre", nullable = false)
    @JsonProperty("genre")
    private String genre;

    @Column(name = "title", nullable = false)
    @JsonProperty("title")
    private String title;

    /*Konstruktor*/
    private Track(){}

    public Track(Album album, Artist artist, Double duration, String genre) {
        this.album = album;
        this.artist = artist;
        this.duration = duration;
        this.genre = genre;
    }

    /*Getterek, Setterek*/

    public Long getId() {
        return id;
    }

    public Album getAlbum() {
        return album;
    }
    public void setAlbum(Album album) {
        this.album = album;
    }

    public Artist getArtist() {
        return artist;
    }
    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Double getDuration() {
        return duration;
    }
    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
}
