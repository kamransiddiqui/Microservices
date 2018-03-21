package com.example.songsapi.models;

import lombok.*;
import javax.persistence.*;

@Data
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
@Entity @Table(name = "SONGS")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "LENGTH")
    private String length;

    @Column(name = "ARTIST_NAME")
    private String artistName;

    public Song(String title, String length, String artistName) {
        this.title = title;
        this.length = length;
        this.artistName = artistName;
    }
}