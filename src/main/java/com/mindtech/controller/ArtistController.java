package com.mindtech.controller;


import com.mindtech.domain.Album;
import com.mindtech.domain.Artist;
import com.mindtech.domain.ShowArtistWrapper;
import com.mindtech.domain.Track;
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
public class ArtistController {

    private ArtistService artistService;
    private TrackService trackService;
    private AlbumService albumService;

    @Autowired
    public void setArtistService(ArtistService artistService) {
        this.artistService = artistService;
    }

    @Autowired
    public void setTrackService(TrackService trackService) {
        this.trackService = trackService;
    }

    @Autowired
    public void setAlbumService(AlbumService albumService) {
        this.albumService = albumService;
    }

    /*Előadó lekérdezése ID alapján*/
    @GetMapping("/artist/{id}")
    public ResponseEntity<ShowArtistWrapper> getArtist(@PathVariable(value = "id") Long artistId) throws NotFoundException{
        Artist artist = artistService.getArtistById(artistId).orElseThrow(() -> new NotFoundException("Nem található szerző a következő azonosítóval : " + artistId));;
        Integer albumNumber = albumService.findAllAlbumByArtist(artist).size();
        ShowArtistWrapper responseArtist = new ShowArtistWrapper(artist.getId(),artist.getName(), artist.getGenre(), artist.getFormedYear(), artist.getBiography(),albumNumber);
        return ResponseEntity.ok().body(responseArtist);
    }

    /*Előadó szerkesztése ID alapján*/
    @PutMapping("/artist/{id}")
    public ResponseEntity<Artist> updateArtist(@PathVariable(value = "id") Long artistId, @RequestBody Artist newArtist) throws NotFoundException{
        Artist artist = artistService.getArtistById(artistId).orElseThrow(() -> new NotFoundException("Nem található szerző a következő azonosítóval : " + artistId));;

        artist.setName(newArtist.getName());
        artist.setGenre(newArtist.getGenre());
        artist.setFormedYear(newArtist.getFormedYear());
        artist.setBiography(newArtist.getBiography());

        final Artist updatedArtist = artistService.updateArtist(artist);
        return ResponseEntity.ok(updatedArtist);
    }

    /*Előadó törlése ID alapján*/
    @DeleteMapping("/artist/{id}")
    public String deleteArtist(@PathVariable(value = "id") Long artistId) throws NotFoundException{
        Artist artist = artistService.getArtistById(artistId).orElseThrow(() -> new NotFoundException("Nem található szerző a következő azonosítóval : " + artistId));;

        List<Track> tracks = trackService.findAllTrackByArtist(artist);
        tracks.forEach((track) -> {
            trackService.deleteTrack(track);
        });


        List<Album> albums = albumService.findAllAlbumByArtist(artist);
        albums.forEach((album) -> {
            albumService.deleteAlbum(album);
        });


        artistService.deleteArtistById(artistId);
        return "A " + artistId + " azonosítójú szerző törölve lett!";
    }
    /*Előadók listája 10-esével, rendezhetően, szűrhetően*/
    @GetMapping("/artists")
    public List<ShowArtistWrapper> getArtists(@RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "name") String sort,
                                   @RequestParam(required = false) String nameFilter,
                                   @RequestParam(required = false) String genreFilter
    ){
        List<String> possibleSorts = new ArrayList<String>(Arrays.asList("name", "formedYear"));

        List<Artist> artists = new ArrayList<Artist>();
        List<ShowArtistWrapper> responseArtists = new ArrayList<ShowArtistWrapper>();

        Pageable paginator;
        if(possibleSorts.contains(sort)){
            paginator = PageRequest.of(page, 10, Sort.by(sort));
        }else{
            paginator = PageRequest.of(page, 10);
        }

        if(nameFilter != null){
            artists = artistService.getAllArtistFilteredByName(nameFilter, paginator);
        }else if(genreFilter != null){
            artists = artistService.getAllArtistFilteredByGenre(genreFilter, paginator);
        }else{
            artists = artistService.getAllArtist(paginator);
        }

        artists.forEach((artist) -> {
            Integer albumNumber = albumService.findAllAlbumByArtist(artist).size();
            responseArtists.add(new ShowArtistWrapper(artist.getId(),artist.getName(), artist.getGenre(), artist.getFormedYear(), artist.getBiography(),albumNumber));
        });
        return responseArtists;
    }

}
