package com.agharibi.netflux.controllers;

import com.agharibi.netflux.domain.Movie;
import com.agharibi.netflux.domain.MovieEvent;
import com.agharibi.netflux.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/movies")
public class MovieControllerImpl implements MovieController {

    private final MovieService movieService;

    public MovieControllerImpl(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override
    @RequestMapping(value = "/{id}/events")
    public Flux<MovieEvent> streamMovieEvent(@PathVariable String id) {
        return this.movieService.events(id);
    }

    @Override
    @RequestMapping(value = "/{id}")
    public Mono<Movie> getMovieById( @PathVariable String id) {
        return this.movieService.getMovieById(id);
    }

    @Override
    public Flux<Movie> getAllMoives() {
        return this.movieService.getAllMovies();
    }
}
