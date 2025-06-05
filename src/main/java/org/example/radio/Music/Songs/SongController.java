package org.example.radio.Music.Songs;

import org.example.radio.Music.Model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Api/music/songs")
public class SongController {

    @Autowired
    private SongService songService;

    @GetMapping
    public List<Song> getAllSongs() {
        return songService.getAllSongs();
    }

    @PostMapping
    public Song saveSong(@RequestBody Song song) {
        return songService.saveSong(song);
    }

    @DeleteMapping("/{id}")
    public void deleteSong(@PathVariable int id) {
        songService.deleteSong(id);
    }
}
