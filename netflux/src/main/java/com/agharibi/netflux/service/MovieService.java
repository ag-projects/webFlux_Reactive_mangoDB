package com.agharibi.netflux.service;

import com.agharibi.netflux.domain.Movie;
import com.agharibi.netflux.domain.MovieEvent;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MovieService {

    /**
     * Generate stream of movie events for a given movieId
     * @param movieId
     * @return
     */
    Flux<MovieEvent> events(String movieId);

    /**
     * Get movie byId
     * @param id
     * @return
     */
    Mono<Movie> getMovieById(String id);

    /**
     * Get all movies
     * @return
     */
    Flux<Movie> getAllMovies();

}
