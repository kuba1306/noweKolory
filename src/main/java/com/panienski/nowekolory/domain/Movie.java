package com.panienski.nowekolory.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity(name = "movies")
public class Movie {

    @Id
    @GeneratedValue
    Long id;
    String title;
    String description;
    String genre;
    String director;
    String plakat;
}
