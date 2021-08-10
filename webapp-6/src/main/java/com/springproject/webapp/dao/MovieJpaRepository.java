package com.springproject.webapp.dao;

import com.springproject.webapp.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieJpaRepository extends JpaRepository<Movie, Integer> {
    Movie findByMovieTitle(String movieTitle);
}
