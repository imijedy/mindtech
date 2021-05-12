package com.mindtech.service;


import com.mindtech.domain.Album;
import com.mindtech.domain.Artist;
import com.mindtech.repository.AlbumRepository;
import com.mindtech.repository.PagingAlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumService implements AlbumServiceInterface{

    private AlbumRepository albumRepository;
    private PagingAlbumRepository pagingAlbumRepository;

    @Autowired
    public void setArtistRepository(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Autowired
    public void setPagingArtistRepository(PagingAlbumRepository pagingAlbumRepository) {
        this.pagingAlbumRepository = pagingAlbumRepository;
    }

    @Override
    public List<Album> getAllAlbumFilteredByTitle(String filter, Pageable pageable) {
        return pagingAlbumRepository.findAllByTitleContaining(filter ,pageable);
    }

    @Override
    public List<Album> getAllAlbumFilteredByArtist(Artist filter, Pageable pageable) {
        return pagingAlbumRepository.findAllByArtist(filter, pageable);
    }

    @Override
    public List<Album> getAllAlbum(Pageable pageable) {
        return pagingAlbumRepository.findAll(pageable).getContent();
    }

    @Override
    public Optional<Album> getAlbumById(Long id) {
        return albumRepository.findById(id);
    }

    @Override
    public void deleteAlbumById(Long id) {

    }

    @Override
    public void deleteAlbum(Album album) {
        albumRepository.delete(album);
    }

    @Override
    public List<Album> findAllAlbumByArtist(Artist artist) {
        return albumRepository.findAllByArtist(artist);
    }
}
