package org.example.radio.Music.Model;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "Album")

public class Album {
    @Id
    long idAlbum;

    String name;

    int TotalSongs;

    int year;

    int idSonglist;

}
