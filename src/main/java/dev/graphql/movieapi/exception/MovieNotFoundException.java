package dev.graphql.movieapi.exception;

public class MovieNotFoundException extends RuntimeException{
    public MovieNotFoundException() {
        super("Movie not found");
    }
}
