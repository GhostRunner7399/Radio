package org.example.radio.User.model;

import jakarta.persistence.*;
import lombok.Data;
import org.example.radio.Music.Model.Album;

import java.util.List;

@Data
@Entity
@Table(name = "Artists")
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idArtist;

    private String name;

    private String lastname;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToMany(mappedBy = "artist", fetch = FetchType.LAZY)
    private List<Album> albums;

}

