package org.example.radio.Music.Playlists;

import org.example.radio.Music.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService {

    @Autowired
    private MusicRepository musicRepository;

    public List<Music> getAllMusic() {
        return musicRepository.findAll();
    }

    public Music createMusic(Music music) {
        return musicRepository.save(music);
    }

    public void deleteMusic(Long id) {
        musicRepository.deleteById(id);
    }
}
