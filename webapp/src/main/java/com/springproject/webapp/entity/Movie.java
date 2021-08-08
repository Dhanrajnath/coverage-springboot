package com.springproject.webapp.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "idmovie")
    private int idMovie;


    @NotNull
    @Size(min=1,message = "required")
    @Column(name="movie_title")
    private String movieTitle;

    @NotNull
    @Size(min=1,message = "required")
    @Column(name ="movie_type")
    private String movieType;

    @NotNull
    @Min(value = 1,message = "minimum is 1")
    @Max(value=5,message="maximum is 5")
    @Column(name="movie_rating")
    private float movieRating;


    @ManyToMany(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name="multiplex_movie",
            joinColumns=@JoinColumn(name="movie_id"),
            inverseJoinColumns=@JoinColumn(name="multiplex_id")
    )
    private List<Multiplex> multiplexList;


    public Movie(){ }

    public void addMultiplex(Multiplex theMultiplex) {

        if (multiplexList == null) {
            multiplexList = new ArrayList<>();
        }

        multiplexList.add(theMultiplex);
    }
}
