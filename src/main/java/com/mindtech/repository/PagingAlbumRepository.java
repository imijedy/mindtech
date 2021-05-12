package com.mindtech.repository;

import com.mindtech.domain.Album;
import com.mindtech.domain.Artist;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;


public interface PagingAlbumRepository extends PagingAndSortingRepository<Album, Long> {

    List<Album> findAllByTitleContaining(String filter, Pageable pageable);
    List<Album> findAllByArtist(Artist filter, Pageable pageable);

}
