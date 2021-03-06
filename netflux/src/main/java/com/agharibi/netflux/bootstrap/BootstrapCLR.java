package com.agharibi.netflux.bootstrap;

import com.agharibi.netflux.domain.Movie;
import com.agharibi.netflux.repositories.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Component
public class BootstrapCLR implements CommandLineRunner {

    private final MovieRepository movieRepository;

    public BootstrapCLR(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        //clear old data
        movieRepository.deleteAll()
                .thenMany(
                        Flux.just("Silence of the Lambdas",
                                "AEon Flux",
                                "Enter the Mono<Void>",
                                "The Fluxxinator",
                                "Back to the Future",
                                "Meet the Fluxes",
                                "Lord of the Fluxes")
                                .map(title -> new Movie(UUID.randomUUID().toString(),title))
                                .flatMap(movieRepository::save))
                .subscribe(null, null, () -> {
                    movieRepository.findAll().subscribe(System.err::println);
                });
    }
}
