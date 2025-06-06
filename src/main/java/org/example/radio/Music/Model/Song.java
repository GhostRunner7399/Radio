package org.example.radio.Music.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Songs")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSong;

    private String title;

    private String genre;

    private String lyrics;

    private String url;

    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;
}
