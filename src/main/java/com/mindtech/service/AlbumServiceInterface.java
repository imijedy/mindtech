package com.mindtech.service;

import com.mindtech.domain.Album;
import com.mindtech.domain.Artist;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface AlbumServiceInterface {
    public List<Album> getAllAlbumFilteredByTitle(String filter, Pageable pageable);
    public List<Album> getAllAlbumFilteredByArtist(Artist filter, Pageable pageable);
    public List<Album> getAllAlbum(Pageable pageable);
    public Optional<Album> getAlbumById(Long id);
    public void deleteAlbumById(Long id);
    public void deleteAlbum(Album album);
    public List<Album> findAllAlbumByArtist(Artist artist);
}
