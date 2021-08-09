package com.example.twitterclone.controllers;

import com.example.twitterclone.models.Tweet;
import com.example.twitterclone.models.User;
import com.example.twitterclone.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("{userId}")
    public User getUser(@PathVariable Long userId) {
        return userService.getUser(userId);
    }

    @GetMapping("{userId}/tweets")
    public List<Tweet> getTweetsFromUser(@PathVariable Long userId) {
        return userService.getTweetsFromUser(userId);
    }

    @PostMapping("add")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }


    @PostMapping("{userId}/tweets/add")
    public Tweet createTweet(@PathVariable Long userId, @RequestParam String tweetContent) {
        return userService.createTweet(userId, tweetContent);
    }
}
