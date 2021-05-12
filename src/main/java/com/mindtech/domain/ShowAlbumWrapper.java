package com.mindtech.domain;

import java.util.Date;
import java.util.List;


public class ShowAlbumWrapper {

    /*Adattagok*/

    private Long id;
    private String title;
    private Date releaseDate;
    private Artist artist;
    private String description;
    private String coverImageUrl;
    private Integer trackNumber;
    private Double albumDuration;

    /*Konstruktor*/

    public ShowAlbumWrapper(){}
    public ShowAlbumWrapper(Long id, String title, Date releaseDate, Artist artist, String description, String coverImageUrl, Integer trackNumber, Double albumDuration) {
        this.id = id;
        this.title = title;
        this.releaseDate = releaseDate;
        this.artist = artist;
        this.description = description;
        this.coverImageUrl = coverImageUrl;
        this.trackNumber = trackNumber;
        this.albumDuration = albumDuration;
    }

    /*Getterek, Setterek*/

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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

    public Integer getTrackNumber() {
        return trackNumber;
    }
    public void setTrackNumber(Integer trackNumber) {
        this.trackNumber = trackNumber;
    }

    public Double getAlbumDuration() {
        return albumDuration;
    }
    public void setAlbumDuration(Double albumDuration) {
        this.albumDuration = albumDuration;
    }
}
