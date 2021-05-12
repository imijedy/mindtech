package com.mindtech.repository;

import com.mindtech.domain.Artist;
import org.springframework.data.repository.PagingAndSortingRepository;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface PagingArtistRepository extends PagingAndSortingRepository<Artist, Long>{

    List<Artist> findAllByNameContaining(String filter, Pageable pageable);
    List<Artist> findAllByGenreContaining(String filter, Pageable pageable);

}
