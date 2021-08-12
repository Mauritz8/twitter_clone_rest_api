package com.example.twitterclone.repositories;

import com.example.twitterclone.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByUsername(String username);

    @Query(value = "SELECT password FROM users WHERE username=?1 limit 1", nativeQuery = true)
    String findPasswordForUserWithUsername(String username);
}
