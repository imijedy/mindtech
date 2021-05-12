package com.mindtech.repository;

import com.mindtech.domain.Album;
import com.mindtech.domain.Artist;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AlbumRepository extends CrudRepository<Album, Long> {

    List<Album> findAllByArtist(Artist artist);
}
