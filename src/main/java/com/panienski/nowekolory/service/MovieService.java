package com.panienski.nowekolory.service;

import com.panienski.nowekolory.Dto.MovieDto;
import com.panienski.nowekolory.webclient.movie.MovieClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
@RequiredArgsConstructor
public class MovieService {

    private final MovieClient movieClient;

    public MovieDto getMovie() {
        String response = movieClient.getMovieById(5);
        log.info(response);
        return null;
    }




}
