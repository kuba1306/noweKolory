package com.panienski.nowekolory.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "movies")
public class Movie {

    @Id
    @GeneratedValue
    private int id;
    private String title;
    private String plot;
    private String genre;
    private String director;

    public Movie(String title, String plot, String genre, String director) {
        this.title = title;
        this.plot = plot;
        this.genre = genre;
        this.director = director;
    }

    public Movie() {

    }

    //    File Poster;
}
