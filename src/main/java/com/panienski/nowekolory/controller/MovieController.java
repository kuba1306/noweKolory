package com.panienski.nowekolory.controller;

import com.panienski.nowekolory.Dto.MovieDto;

import com.panienski.nowekolory.domain.Movie;
import com.panienski.nowekolory.mapper.MovieMapper;
import com.panienski.nowekolory.service.MovieService;
import com.panienski.nowekolory.webclient.movie.MovieClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/v1/movie")
public class MovieController {
    private final MovieService movieService;
    private final MovieMapper movieMapper;
    private final MovieClient movieClient;

    public MovieController(MovieService movieService, MovieMapper movieMapper, MovieClient movieClient) {
        this.movieService = movieService;
        this.movieMapper = movieMapper;
        this.movieClient = movieClient;
    }

    @GetMapping
    public ResponseEntity<List<MovieDto>> getAllMoviesFromDB() {
        List<Movie> movies = movieService.getAllMovies();
        return ResponseEntity.ok(movieMapper.mapToMovieDtoList(movies));
    }

    @GetMapping(value = "{title}")
    public ResponseEntity<MovieDto> getMovieByFromApiByTitle(@PathVariable String title) throws MovieNotFoundException {
        return ResponseEntity.ok(movieClient.getMovieForTitle(title));

    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addToFavouriteMovies(@RequestBody MovieDto movieDto) {
        Movie movie = movieMapper.mapToMovie(movieDto);
        movieService.saveMovie(movie);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "{movieId}")
    public ResponseEntity<Void> deleteMovieFromDB(@PathVariable Long movieId) throws MovieNotFoundException {
        movieService.deleteMovie(movieId);
        return ResponseEntity.ok().build();
    }
}
