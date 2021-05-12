package com.mindtech.repository;


import com.mindtech.domain.Artist;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ArtistRepository extends CrudRepository<Artist, Long>{

    public Optional<Artist> findByName(String name);
}
