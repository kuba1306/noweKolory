package com.panienski.nowekolory.repository;

import com.panienski.nowekolory.Dto.MovieDto;
import com.panienski.nowekolory.domain.Movie;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Transactional
@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {

    @Override
    List<Movie> findAll();

    MovieDto findMovieByTitle(String title);

}
