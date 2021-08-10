package com.springproject.multiplexinfoapp.dao;

import com.springproject.multiplexinfoapp.entity.Multiplex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MultiplexRepository extends JpaRepository<Multiplex,Integer> {
    List<Multiplex> findByMultiplexName(String multiplexName);
}
