package org.example.radio.Music.Album;

import org.example.radio.Music.Model.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {

    @Autowired
    private org.example.radio.Music.Album.AlbumRepository albumRepository;

    public List<Album> getAllAlbums() {
        return albumRepository.findAll();
    }

    public Album saveAlbum(Album album) {
        return albumRepository.save(album);
    }

    public void deleteAlbum(Long id) {
        albumRepository.deleteById(id);
    }
}
