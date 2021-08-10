package com.example.twitterclone.controllers;

import com.example.twitterclone.View;
import com.example.twitterclone.models.Tweet;
import com.example.twitterclone.services.TweetService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/tweets")
@CrossOrigin(origins = "http://localhost:3000")
public class TweetController {

    @Autowired
    TweetService tweetService;

    @GetMapping("")
    @JsonView(View.ShowTweetStuff.class)
    public List<Tweet> getTweets() {
        return tweetService.getTweets();
    }

    @GetMapping("{tweetId}")
    @JsonView(View.ShowTweetStuff.class)
    public Tweet getTweet(@PathVariable Long tweetId) {
        return tweetService.getTweet(tweetId);
    }
}
