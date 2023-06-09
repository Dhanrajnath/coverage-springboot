package com.springproject.webapp.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "multiplex")
public class Multiplex {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "idmultiplex")
    private int idMultiplex;

    @NotNull
    @Size(min = 1, message = "required")
    @Column(name = "multiplex_name")
    private String multiplexName;

    @NotNull
    @Min(value = 1, message = "minimum is 1")
    @Max(value = 5, message = "maximum is 5")
    @Column(name = "multiplex_rating")
    private float multiplexRating;

    @NotNull(message = "required")
    @Size(min = 1, message = "required")
    @Column(name = "multiplex_location")
    private String multiplexLocation;


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name = "multiplex_movie",
            joinColumns = @JoinColumn(name = "multiplex_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    @ToString.Exclude
    private List<Movie> movieList;

    public Multiplex() {
    }

    public Multiplex(String multiplexName, float multiplexRating, String multiplexLocation) {
        this.multiplexName = multiplexName;
        this.multiplexRating = multiplexRating;
        this.multiplexLocation = multiplexLocation;
    }

    public List<Movie> getMovieList() {

        return movieList;
    }

    public void addMovie(Movie theMovie) {

        if (movieList == null) {
            movieList = new ArrayList<>();
        }

        movieList.add(theMovie);
    }

}
