package com.example.books.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.books.model.User;

public interface UserRepo extends JpaRepository<User, Long>{

}
