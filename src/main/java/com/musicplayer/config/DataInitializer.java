package com.musicplayer.config;

import com.musicplayer.entity.Song;
import com.musicplayer.repository.SongRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(SongRepository songRepository) {

        return args -> {

            if (songRepository.count() == 0) {

                Song song = new Song();

                song.setTitle("Believer");
                song.setArtist("Imagine Dragons");
                song.setAlbum("Evolve");
                song.setGenre("Rock");

                // File inside src/main/resources/static/songs/
                song.setAudioUrl("songs/believer.mp3");

                // File inside src/main/resources/static/images/
                song.setCoverImageUrl("images/default.jpg");

                song.setDuration(204);

                songRepository.save(song);

                System.out.println("Default song inserted successfully!");
            }
        };
    }
}