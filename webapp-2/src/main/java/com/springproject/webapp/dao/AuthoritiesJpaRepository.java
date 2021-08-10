package com.springproject.webapp.dao;

import com.springproject.webapp.entity.Authorities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthoritiesJpaRepository extends JpaRepository<Authorities,Integer>
{

}
