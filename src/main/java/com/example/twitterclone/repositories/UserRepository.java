package com.example.twitterclone.repositories;

import com.example.twitterclone.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByUsername(String username);

    @Query(value = "SELECT password FROM users WHERE username=?1 limit 1", nativeQuery = true)
    String findPasswordForUserWithUsername(String username);

    @Query(value = "FROM User WHERE username LIKE %?1% OR displayName LIKE %?1%")
    List<User> findByUsernameOrDisplayNameContaining(String searchPattern);
}
