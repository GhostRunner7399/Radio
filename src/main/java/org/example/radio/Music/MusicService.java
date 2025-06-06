package org.example.radio.Music;

import org.example.radio.Music.Album.AlbumService;
import org.example.radio.Music.Model.Album;
import org.example.radio.Music.Model.Playlist;
import org.example.radio.Music.Model.Song;
import org.example.radio.Music.Songs.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MusicService {

    @Autowired
    private SongService songService;

    @Autowired
    private AlbumService albumService;


    public List<Song> getAllSongs() {
        return songService.getAllSongs();
    }

    public List<Album> getAllAlbums() {
        return albumService.getAllAlbums();
    }


    public Map<String, Object> getMusicSummary() {
        Map<String, Object> summary = new HashMap<>();
        summary.put("totalSongs", songService.getAllSongs().size());
        summary.put("totalAlbums", albumService.getAllAlbums().size());
        return summary;
    }
}
