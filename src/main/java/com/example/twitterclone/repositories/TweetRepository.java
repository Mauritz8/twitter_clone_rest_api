package com.example.twitterclone.repositories;

import com.example.twitterclone.models.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TweetRepository extends JpaRepository<Tweet, Long> {

    List<Tweet> findByUser_id(Long userId);
}
