package com.example.twitterclone.services;

import com.example.twitterclone.exceptions.userNotFound.UserNotFoundException;
import com.example.twitterclone.models.Tweet;
import com.example.twitterclone.models.User;
import com.example.twitterclone.repositories.TweetRepository;
import com.example.twitterclone.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TweetRepository tweetRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUser(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
    }

    public User createUser(User user) {
        boolean usernameExists = userRepository.findByUsername(user.getUsername()).size() != 0;
        if (usernameExists) {
            System.out.println("Username already exists");
            return null;
        } else {
            userRepository.save(user);
            return user;
        }
    }

    public Tweet createTweet(Long userId, String tweetContent) {
        User user = userRepository.findById(userId).get();
        user.addTweet(new Tweet(tweetContent));
        userRepository.save(user);
        return user.getTweets().get(user.getTweets().size() - 1);
    }

    public List<Tweet> getTweetsFromUser(Long userId) {
        return tweetRepository.findByUser_id(userId);
    }

}
