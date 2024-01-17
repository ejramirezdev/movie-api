package dev.graphql.movieapi.inputs;

import java.util.List;

public record CreateMovieInput(String title,
                               String director, String studio, Integer releaseYear,
                               List<String> movieCast) {
}
