package org.example.radio.Music.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Playlist")
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPlaylist;

    private String name;

    private String description;

    private int totalSongs;

    private String createdBy;
}
