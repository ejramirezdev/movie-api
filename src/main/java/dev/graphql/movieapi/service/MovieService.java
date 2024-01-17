package dev.graphql.movieapi.service;

import dev.graphql.movieapi.exception.MovieNotFoundException;
import dev.graphql.movieapi.inputs.CreateMovieInput;
import dev.graphql.movieapi.inputs.UpdateMovieInput;
import dev.graphql.movieapi.models.Movie;
import dev.graphql.movieapi.repository.MovieRepository;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;
    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }
    public Movie addMovie(CreateMovieInput createMovieInput){
        Movie movie = new Movie(createMovieInput.title(),
                createMovieInput.director(), createMovieInput.studio(),
                createMovieInput.releaseYear(), createMovieInput.movieCast());
        return movieRepository.save(movie);
    }

    public Movie updateMovie(UpdateMovieInput updateMovieInput){
        Movie movie = movieRepository.findById(updateMovieInput.id()).orElseThrow(MovieNotFoundException::new);
        movie.setTitle(updateMovieInput.title());
        movie.setDirector(updateMovieInput.director());
        movie.setStudio(updateMovieInput.studio());
        movie.setReleaseYear(updateMovieInput.releaseYear());
        movie.setMovieCast(updateMovieInput.movieCast());
        return movieRepository.save(movie);
    }

    public String deleteMovie(Integer movieId){
        Movie movie = movieRepository.findById(movieId).orElseThrow(MovieNotFoundException::new);
        movieRepository.delete(movie);
        return "Movie deleted with id " + movieId;
    }
}
