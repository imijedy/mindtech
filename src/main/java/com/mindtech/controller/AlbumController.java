package com.mindtech.controller;

import com.mindtech.domain.Album;
import com.mindtech.domain.Artist;
import com.mindtech.domain.ShowAlbumWrapper;
import com.mindtech.exceptions.NotFoundException;
import com.mindtech.service.AlbumService;
import com.mindtech.service.ArtistService;
import com.mindtech.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class AlbumController {

    private ArtistService artistService;
    private AlbumService albumService;

    @Autowired
    public void setArtistService(ArtistService artistService) {
        this.artistService = artistService;
    }

    @Autowired
    public void setAlbumService(AlbumService albumService) {
        this.albumService = albumService;
    }

    /*Album lekérdezése ID alapján*/
    @GetMapping("/album/{id}")
    public ResponseEntity<Album> getAlbum(@PathVariable(value = "id") Long albumId) throws NotFoundException {
        Album album = albumService.getAlbumById(albumId).orElseThrow(() -> new NotFoundException("Nem található album a következő azonosítóval : " + albumId));
        return ResponseEntity.ok().body(album);
    }

    /*Album listája 10-esével, rendezhetően, szűrhetően*/
    @GetMapping("/albums")
    public List<ShowAlbumWrapper> getArtists(@RequestParam(defaultValue = "0") int page,
                                              @RequestParam(defaultValue = "title") String sort,
                                              @RequestParam(required = false) String titleFilter,
                                              @RequestParam(required = false) String artistFilter
    ){
        List<String> possibleSorts = new ArrayList<String>(Arrays.asList("title", "releaseDate"));

        List<Album> albums = new ArrayList<Album>();
        List<ShowAlbumWrapper> responseAlbums = new ArrayList<ShowAlbumWrapper>();

        Pageable paginator;
        if(possibleSorts.contains(sort)){
            paginator = PageRequest.of(page, 10, Sort.by(sort));
        }else{
            paginator = PageRequest.of(page, 10);
        }

        if(titleFilter != null){
            albums = albumService.getAllAlbumFilteredByTitle(titleFilter, paginator);
        }else if(artistFilter != null){
            Artist artist = artistService.getArtistByName(artistFilter).get();
            albums = albumService.getAllAlbumFilteredByArtist(artist, paginator);
        }else{
            albums = albumService.getAllAlbum(paginator);
        }

        albums.forEach((album) -> {
            Integer trackNumber = album.getTracks().size();
            Double albumDuration = 0.0;
            for(int i = 0; i < album.getTracks().size(); i++){
                albumDuration += album.getTracks().get(i).getDuration();
            }
            responseAlbums.add(new ShowAlbumWrapper(album.getId(),album.getTitle(), album.getReleaseDate(), album.getArtist(), album.getDescription(), album.getCoverImageUrl(), trackNumber, albumDuration));
        });
        return responseAlbums;
    }
}
