package com.musicplayer.controller;

import com.musicplayer.entity.Song;
import com.musicplayer.service.SongService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/songs")
public class SongController {

    private final SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    @PostMapping
    public Song addSong(@RequestBody Song song) {
        return songService.addSong(song);
    }

    @GetMapping
    public List<Song> getAllSongs() {
        return songService.getAllSongs();
    }

    @GetMapping("/{id}")
    public Song getSongById(@PathVariable Long id) {
        return songService.getSongById(id);
    }

    @PutMapping("/{id}")
    public Song updateSong(
            @PathVariable Long id,
            @RequestBody Song song) {

        return songService.updateSong(id, song);
    }

    @DeleteMapping("/{id}")
    public String deleteSong(@PathVariable Long id) {

        songService.deleteSong(id);

        return "Song deleted successfully";
    }
    @GetMapping("/search")
    public List<Song> searchSongs(
            @RequestParam String keyword) {

        return songService.searchSongs(keyword);
    }
}