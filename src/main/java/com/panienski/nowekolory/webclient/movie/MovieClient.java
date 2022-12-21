package com.panienski.nowekolory.webclient.movie;

import com.panienski.nowekolory.Dto.MovieDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;



@Component
public class MovieClient {
    private static final String MOVIE_URL = "http://www.omdbapi.com/";

    private static final String MOVIE_POSTER_URL = "http://img.omdbapi.com/";
    private static final String API_KEY = "897bd1d5";
    private RestTemplate restTemplate = new RestTemplate();

    public MovieDto getMovieForTitle(String title) {

        MovieDto movieDto = restTemplate.getForObject(MOVIE_URL + "?t={title}&plot=full&apikey={apiKey}", MovieDto.class, title,
                API_KEY);
        return MovieDto.builder()
                .title(movieDto.getTitle())
                .plot(movieDto.getPlot())
                .genre(movieDto.getGenre())
                .director(movieDto.getDirector())
                .build();
    }
}
