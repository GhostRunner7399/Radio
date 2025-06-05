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
    private String artist;

    private String album; // Si luego tienes entidad Album, esto se vuelve @ManyToOne
}
