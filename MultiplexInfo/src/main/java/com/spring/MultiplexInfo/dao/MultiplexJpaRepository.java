package com.spring.MultiplexInfo.dao;

import com.spring.MultiplexInfo.entity.Multiplex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MultiplexJpaRepository extends JpaRepository<Multiplex,Integer> {
    List<Multiplex> findByMultiplexName(String multiplexName);
}
