package com.mindtech.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Album {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "title", nullable = false)
    @JsonProperty("title")
    private String title;

    @Column(name = "release_date", nullable = false)
    @JsonProperty("releaseDate")
    private Date releaseDate;

    @ManyToOne
    @JsonProperty("artist")
    @JsonBackReference
    private Artist artist;

    @Column(name = "description", columnDefinition = "TEXT")
    @JsonProperty("description")
    private String description;

    @Column(name = "cover_image_url", nullable = false)
    @JsonProperty("coverImageUrl")
    private String coverImageUrl;

    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL)
    @JsonProperty("tracks")
    private List<Track> tracks;

    /*Konstruktor*/
    private Album(){}

    public Album(String title, Date releaseDate, Artist artist, String description, String coverImageUrl, List<Track> tracks) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.artist = artist;
        this.description = description;
        this.coverImageUrl = coverImageUrl;
        this.tracks = tracks;
    }

    /*Getterek, Setterek*/

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }
    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Artist getArtist() {
        return artist;
    }
    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getCoverImageUrl() {
        return coverImageUrl;
    }
    public void setCoverImageUrl(String coverImageUrl) {
        this.coverImageUrl = coverImageUrl;
    }

    public List<Track> getTracks() {
        return tracks;
    }
    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }
}
