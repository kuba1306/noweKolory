package com.panienski.nowekolory.controller;

import com.panienski.nowekolory.Dto.MovieDto;
import com.panienski.nowekolory.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/movie")
    public MovieDto getMovie() {
        return movieService.getMovie();
    }

}
