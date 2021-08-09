package com.example.twitterclone.services;

import com.example.twitterclone.models.Tweet;
import com.example.twitterclone.repositories.TweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TweetService {

    @Autowired
    TweetRepository tweetRepository;

    public List<Tweet> getTweets() {
        return tweetRepository.findAll();
    }

    public Tweet getTweet(Long tweetId) {
        return tweetRepository.findById(tweetId).get();
    }
}
