package org.example.radio.User.Artists;

import org.example.radio.User.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {
    // Puedes agregar métodos personalizados si necesitas (ej: buscar por nombre, etc.)
}
