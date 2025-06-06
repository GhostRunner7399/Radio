package org.example.radio.User.Artists;

import org.example.radio.User.model.Artist;
import org.example.radio.User.model.User;
import org.example.radio.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/artists")
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @Autowired
    private ArtistRepository artistRepository;

    @Autowired
    private UserRepository userRepository; // ✅ Inyección correcta

    @GetMapping("")
    public List<Artist> getAllArtists() {
        return artistService.getAllArtists();
    }

    @GetMapping("/{id}")
    public Artist getArtistById(@PathVariable Long id) {
        return artistService.getArtistById(id)
                .orElseThrow(() -> new RuntimeException("Artista no encontrado"));
    }

    @PostMapping("/register")
    public ResponseEntity<?> createArtist(@RequestBody Artist artist) {
        Long userId = artist.getUser().getId();
        Optional<User> userOptional = userRepository.findById(userId); // ✅ Uso correcto

        if (userOptional.isEmpty()) {
            return ResponseEntity.badRequest().body("Usuario no encontrado");
        }

        artist.setUser(userOptional.get());
        Artist savedArtist = artistRepository.save(artist);
        return ResponseEntity.ok(savedArtist);
    }

    @PutMapping("/{id}")
    public Artist updateArtist(@PathVariable Long id, @RequestBody Artist artist) {
        return artistService.updateArtist(id, artist);
    }

    @DeleteMapping("/{id}")
    public void deleteArtist(@PathVariable Long id) {
        artistService.deleteArtist(id);
    }
}

