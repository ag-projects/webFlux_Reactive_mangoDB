package com.agharibi.netflux.controllers;

import com.agharibi.netflux.domain.Movie;
import com.agharibi.netflux.domain.MovieEvent;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MovieController {

    /**
     *
     * @param id
     * @return
     */
    Flux<MovieEvent> streamMovieEvent(String id);

    /**
     *
     * @param id
     * @return
     */
    Mono<Movie> getMovieById(String id);

    /**
     *
     * @return
     */
    Flux<Movie> getAllMoives();
}
