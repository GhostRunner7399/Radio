package org.example.radio.Music.Model;

import jakarta.persistence.*;
import lombok.Data;
import org.example.radio.User.model.Artist;

import java.util.List;

@Data
@Entity
@Table(name = "Album")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAlbum;

    private String name;

    private int year;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_artist")
    private Artist artist;


    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Song> songs;
}
