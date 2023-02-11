package com.example.junittest.restAPI.dao;

import com.example.junittest.restAPI.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userDAO extends JpaRepository<User,Integer> {
}
