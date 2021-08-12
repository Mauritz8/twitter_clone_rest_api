package com.example.twitterclone.controllers;

import com.example.twitterclone.View;
import com.example.twitterclone.models.Tweet;
import com.example.twitterclone.models.User;
import com.example.twitterclone.services.UserService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("")
    @JsonView(View.ShowUserStuff.class)
    public List<User> getUsers(@RequestParam(required = false) String username) {
        if (username == null || username.equals("")) {
            return userService.getUsers();
        } else {
            return userService.getUsersWithUsername(username);
        }
    }

    @GetMapping("{userId}")
    @JsonView(View.ShowUserStuff.class)
    public User getUser(@PathVariable Long userId) {
        return userService.getUser(userId);
    }

    @GetMapping("{userId}/tweets")
    @JsonView(View.ShowUserStuff.class)
    public List<Tweet> getTweetsFromUser(@PathVariable Long userId) {
        return userService.getTweetsFromUser(userId);
    }

    @PostMapping("add")
    @JsonView(View.ShowUserStuff.class)
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }


    @PostMapping("{userId}/tweets/add")
    @JsonView(View.ShowUserStuff.class)
    public Tweet createTweet(@PathVariable Long userId, @RequestParam String tweetContent) {
        return userService.createTweet(userId, tweetContent);
    }

    @PostMapping("login")
    @JsonView(View.ShowUserStuff.class)
    public String login(@RequestBody User user) {
        return userService.login(user.getUsername(), user.getPassword());
    }
}
