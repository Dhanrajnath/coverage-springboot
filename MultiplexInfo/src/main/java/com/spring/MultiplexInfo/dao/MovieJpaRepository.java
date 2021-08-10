package com.spring.MultiplexInfo.dao;

import com.spring.MultiplexInfo.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieJpaRepository extends JpaRepository<Movie, Integer> {
    List<Movie> findByMovieTitle(String movieTitle);

}
