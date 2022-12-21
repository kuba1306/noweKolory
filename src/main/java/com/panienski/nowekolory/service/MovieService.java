package com.panienski.nowekolory.service;

import com.panienski.nowekolory.Dto.MovieDto;
import com.panienski.nowekolory.controller.MovieNotFoundException;
import com.panienski.nowekolory.domain.Movie;
import com.panienski.nowekolory.repository.MovieRepository;
import com.panienski.nowekolory.webclient.movie.MovieClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MovieService {


    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public MovieDto getMovieByTitle(final String title) throws MovieNotFoundException {
        return movieRepository.findMovieByTitle(title);
    }

    public Movie saveMovie(final Movie movie) {
        return movieRepository.save(movie);
    }

    public void deleteMovie(final Long movieId) throws MovieNotFoundException {
        Movie movie = movieRepository.findById(movieId).orElseThrow(MovieNotFoundException::new);
        movieRepository.delete(movie);
    }
}
