package com.mindtech.service;

import com.mindtech.domain.Artist;
import com.mindtech.repository.ArtistRepository;
import com.mindtech.repository.PagingArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

@Service
public class ArtistService implements ArtistServiceInterface{

    private ArtistRepository artistRepository;
    private PagingArtistRepository pagingArtistRepository;

    @Autowired
    public void setArtistRepository(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Autowired
    public void setPagingArtistRepository(PagingArtistRepository pagingArtistRepository) {
        this.pagingArtistRepository = pagingArtistRepository;
    }


    @Override
    public List<Artist> getAllArtistFilteredByName(String filter, Pageable pageable) {
        return pagingArtistRepository.findAllByNameContaining(filter ,pageable);
    }

    @Override
    public List<Artist> getAllArtistFilteredByGenre(String filter, Pageable pageable) {
        return pagingArtistRepository.findAllByGenreContaining(filter ,pageable);
    }

    @Override
    public List<Artist> getAllArtist(Pageable pageable) {
        return pagingArtistRepository.findAll(pageable).getContent();
    }

    @Override
    public Optional<Artist> getArtistById(Long id) {
        return artistRepository.findById(id);
    }

    @Override
    public Optional<Artist> getArtistByName(String name) {
        return artistRepository.findByName(name);
    }

    @Override
    public Artist updateArtist(Artist updatedArtist) {
        return artistRepository.save(updatedArtist);
    }

    @Override
    public void deleteArtistById(Long id) {
        artistRepository.deleteById(id);
    }
}
