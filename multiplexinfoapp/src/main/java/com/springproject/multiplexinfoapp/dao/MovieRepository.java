package com.springproject.multiplexinfoapp.dao;

import com.springproject.multiplexinfoapp.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    List<Movie> findByMovieTitle(String movieTitle);

}
