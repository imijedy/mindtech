package com.mindtech.service;

import com.mindtech.domain.Artist;
import com.mindtech.domain.Track;

import java.util.List;
import java.util.Optional;

public interface TrackServiceInterface {
    public Optional<Track> getTrackById(Long id);
    public void deleteTrackById(Long id);
    public void deleteTrack(Track track);
    public List<Track> findAllTrackByArtist(Artist artist);
}
