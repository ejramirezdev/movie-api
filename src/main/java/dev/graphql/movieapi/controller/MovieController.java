package dev.graphql.movieapi.controller;

import dev.graphql.movieapi.inputs.CreateMovieInput;
import dev.graphql.movieapi.inputs.UpdateMovieInput;
import dev.graphql.movieapi.models.Movie;
import dev.graphql.movieapi.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @QueryMapping
    List<Movie> getAllMoviesHandler(){
        return movieService.getAllMovies();
    }

    @MutationMapping
    Movie addMovie(@Argument CreateMovieInput createMovieInput){
        return movieService.addMovie(createMovieInput);
    }

    @MutationMapping
    Movie updateMovie(@Argument UpdateMovieInput updateMovieInput){
        return movieService.updateMovie(updateMovieInput);
    }

    @MutationMapping
    String deleteMovie(@Argument Integer movieId){
        return movieService.deleteMovie(movieId);
    }
}
