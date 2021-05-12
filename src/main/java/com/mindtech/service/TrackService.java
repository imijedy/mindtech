package com.mindtech.service;

import com.mindtech.domain.Artist;
import com.mindtech.domain.Track;
import com.mindtech.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackService implements TrackServiceInterface {

    private TrackRepository trackRepository;
    @Autowired
    public void setArtistRepository(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public Optional<Track> getTrackById(Long id) {
        return null;
    }

    @Override
    public void deleteTrackById(Long id) {

    }

    @Override
    public void deleteTrack(Track track) {
        trackRepository.delete(track);
    }

    @Override
    public List<Track> findAllTrackByArtist(Artist artist) {
        return trackRepository.findAllByArtist(artist);
    }
}
