package org.example.radio.Music.Model;

import jakarta.persistence.*;
import lombok.Data;
import org.example.radio.User.model.User;

import java.util.List;

@Data
@Entity
@Table(name = "Playlists")
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPlaylist;

    private String name;

    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User owner;

    @ManyToMany
    @JoinTable(
            name = "playlist_songs",
            joinColumns = @JoinColumn(name = "playlist_id"),
            inverseJoinColumns = @JoinColumn(name = "song_id")
    )
    private List<Song> songs;
}

