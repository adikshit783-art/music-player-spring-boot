package com.musicplayer.service;

import com.musicplayer.entity.Song;

import java.util.List;

public interface SongService {

    Song addSong(Song song);

    List<Song> getAllSongs();

    Song getSongById(Long id);

    Song updateSong(Long id, Song song);

    void deleteSong(Long id);

    List<Song> searchSongs(String keyword);
}