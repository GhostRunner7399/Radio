package org.example.radio.Music.Repository;

import org.example.radio.Music.Model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {
}
