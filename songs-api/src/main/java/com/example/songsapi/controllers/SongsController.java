package com.example.songsapi.controllers;

import com.example.songsapi.models.Song;
import com.example.songsapi.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class SongsController {

    @Autowired
    private SongRepository songRepository;

    @GetMapping("/songs")
    public Iterable<Song> findAllSongs() {
        return songRepository.findAll();
    }

    @GetMapping("/songs/{songId}")
    public Song findUserById(@PathVariable Long songId) {
        return songRepository.findOne(songId);
    }

    @DeleteMapping("/songs/{songId}")
    public HttpStatus deleteUserById(@PathVariable Long songId) {
        songRepository.delete(songId);
        return HttpStatus.OK;
    }

    @PostMapping("/songs")
    public Song createNewSong(@RequestBody Song newSong) {
        return songRepository.save(newSong);
    }

    @PatchMapping("/songs/{songId}")
    public Song updateUserById(@PathVariable Long songId, @RequestBody Song songRequest) {

        Song songFromDb = songRepository.findOne(songId);

        songFromDb.setTitle(songRequest.getTitle());
        songFromDb.setLength(songRequest.getLength());
        songFromDb.setArtistName(songRequest.getArtistName());

        return songRepository.save(songFromDb);
    }
}