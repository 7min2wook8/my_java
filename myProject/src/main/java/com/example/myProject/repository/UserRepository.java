package com.example.myProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.myProject.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}