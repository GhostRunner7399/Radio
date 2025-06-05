package org.example.radio.Music.Songs;

import org.example.radio.Music.Model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {

    @Autowired
    private org.example.radio.Music.Songs.SongRepository songRepository;

    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    public Song saveSong(Song song) {
        return songRepository.save(song);
    }

    public void deleteSong(int id) {
        songRepository.deleteById((long) id);
    }


}
