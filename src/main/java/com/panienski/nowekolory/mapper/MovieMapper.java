package com.panienski.nowekolory.mapper;

import com.panienski.nowekolory.Dto.MovieDto;
import com.panienski.nowekolory.domain.Movie;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieMapper {

    public Movie mapToMovie(final MovieDto movieDto) {
        return new Movie(
                movieDto.getTitle(),
                movieDto.getPlot(),
                movieDto.getGenre(),
                movieDto.getDirector()
        );
    }

    public MovieDto mapToMovieDto(final Movie movie) {
        return new MovieDto(

                movie.getTitle(),
                movie.getPlot(),
                movie.getGenre(),
                movie.getDirector()
        );
    }

    public List<MovieDto> mapToMovieDtoList(final List<Movie> movieList) {
        return movieList.stream()
                .map(this::mapToMovieDto)
                .collect(Collectors.toList());
    }
}
