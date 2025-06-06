package org.example.radio.User.Artists;

import org.example.radio.User.model.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistService {

    @Autowired
    private org.example.radio.User.Artists.ArtistRepository artistRepository;

    public List<Artist> getAllArtists() {
        return artistRepository.findAll();
    }

    public Optional<Artist> getArtistById(Long id) {
        return artistRepository.findById(id);
    }

    public Artist createArtist(Artist artist) {
        return artistRepository.save(artist);
    }

    public Artist updateArtist(Long id, Artist updatedArtist) {
        return artistRepository.findById(id).map(artist -> {
            artist.setName(updatedArtist.getName());
            artist.setLastname(updatedArtist.getLastname());
            artist.setIdArtist(updatedArtist.getIdArtist());
            artist.setAlbums(updatedArtist.getAlbums());
            return artistRepository.save(artist);
        }).orElseThrow(() -> new RuntimeException("Artista no encontrado con id " + id));
    }

    public void deleteArtist(Long id) {
        artistRepository.deleteById(id);
    }
}
