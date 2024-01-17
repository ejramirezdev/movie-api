package dev.graphql.movieapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String director;

    private String studio;

    private Integer releaseYear;

    @ElementCollection
    @CollectionTable(name = "movie_cast")
    private List<String> movieCast;

    public Movie (String title, String director, String studio, Integer releaseYear, List<String> movieCast) {
        this.title = title;
        this.director = director;
        this.studio = studio;
        this.releaseYear = releaseYear;
        this.movieCast = movieCast;
    }
}
