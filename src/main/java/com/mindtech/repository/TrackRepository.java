package com.mindtech.repository;

import com.mindtech.domain.Artist;
import com.mindtech.domain.Track;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TrackRepository extends CrudRepository<Track, Long> {

    List<Track> findAllByArtist(Artist artist);
}
