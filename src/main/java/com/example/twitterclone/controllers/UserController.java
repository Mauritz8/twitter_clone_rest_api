package com.example.twitterclone.controllers;

import com.example.twitterclone.models.Tweet;
import com.example.twitterclone.models.User;
import com.example.twitterclone.services.UserService;
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
    public List<User> getUsers(@RequestParam(required = false) String username) {
        if (username == null || username.equals("")) {
            return userService.getUsers();
        } else {
            return userService.getUsersWithUsername(username);
        }
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

    @PostMapping("login")
    public User login(@RequestBody User user) {
        return userService.login(user.getUsername(), user.getPassword());
    }

    @GetMapping("search")
    public List<User> searchUsers(String searchPattern) {
        return userService.searchUsers(searchPattern);
    }
}
