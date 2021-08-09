package com.example.twitterclone.controllers;

import com.example.twitterclone.models.Tweet;
import com.example.twitterclone.services.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tweets")
public class TweetController {

    @Autowired
    TweetService tweetService;

    @GetMapping("")
    public List<Tweet> getTweets() {
        return tweetService.getTweets();
    }

    @GetMapping("{tweetId}")
    public Tweet getTweet(@PathVariable Long tweetId) {
        return tweetService.getTweet(tweetId);
    }
}
