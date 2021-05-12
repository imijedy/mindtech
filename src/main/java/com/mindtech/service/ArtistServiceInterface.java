package com.mindtech.service;


import com.mindtech.domain.Artist;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

public interface ArtistServiceInterface {
    public List<Artist> getAllArtistFilteredByName(String filter, Pageable pageable);
    public List<Artist> getAllArtistFilteredByGenre(String filter, Pageable pageable);
    public List<Artist> getAllArtist(Pageable pageable);
    public Optional<Artist> getArtistById(Long id);
    public Optional<Artist> getArtistByName(String name);
    public Artist updateArtist(Artist updatedArtist);
    public void deleteArtistById(Long id);

}
