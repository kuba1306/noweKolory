package com.panienski.nowekolory.webclient.movie;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MovieClient {

    private static final String MOVIE_URL = "http://www.omdbapi.com/";
    private static final String API_KEY = "897bd1d5";
    private RestTemplate restTemplate = new RestTemplate();

    public String getMovieById(int id) {
        return restTemplate.getForObject(MOVIE_URL + "?t={id}&apikey={apiKey}", String.class,
                id, API_KEY);

    }
}
