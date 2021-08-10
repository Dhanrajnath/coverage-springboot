package com.spring.MultiplexInfo.dao;

import com.spring.MultiplexInfo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<User, String> {
}
