package com.springproject.webapp.dao;

import com.springproject.webapp.entity.Multiplex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MultiplexRepository extends JpaRepository<Multiplex,Integer> {
}
