package pl.sda.netlix.repository;

import pl.sda.netlix.model.Movie;

import java.util.List;

public interface MoviesRepository {

    List<Movie> findAll();
    Movie findByTitle(String title);

}
