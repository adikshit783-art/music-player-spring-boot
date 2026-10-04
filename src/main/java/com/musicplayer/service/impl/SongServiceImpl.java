package com.musicplayer.service.impl;

import com.musicplayer.exception.SongNotFoundException;
import com.musicplayer.entity.Song;
import com.musicplayer.repository.SongRepository;
import com.musicplayer.service.SongService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {

    private final SongRepository songRepository;

    public SongServiceImpl(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public Song addSong(Song song) {
        return songRepository.save(song);
    }

    @Override
    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    @Override
    public Song getSongById(Long id) {
        return songRepository.findById(id)
                .orElseThrow(() ->
                        new SongNotFoundException(
                                "Song not found with id: " + id));
    }

    @Override
    public Song updateSong(Long id, Song song) {

        Song existingSong = getSongById(id);

        existingSong.setTitle(song.getTitle());
        existingSong.setArtist(song.getArtist());
        existingSong.setAlbum(song.getAlbum());
        existingSong.setGenre(song.getGenre());
        existingSong.setAudioUrl(song.getAudioUrl());
        existingSong.setCoverImageUrl(song.getCoverImageUrl());
        existingSong.setDuration(song.getDuration());

        return songRepository.save(existingSong);
    }

    @Override
    public void deleteSong(Long id) {

        Song existingSong = getSongById(id);

        songRepository.delete(existingSong);
    }

    @Override
    public List<Song> searchSongs(String keyword) {

        List<Song> songsByTitle =
                songRepository.findByTitleContainingIgnoreCase(keyword);

        List<Song> songsByArtist =
                songRepository.findByArtistContainingIgnoreCase(keyword);

        songsByTitle.addAll(songsByArtist);

        return songsByTitle;
    }

}