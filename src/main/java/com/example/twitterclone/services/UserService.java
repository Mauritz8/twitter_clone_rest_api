package com.example.twitterclone.services;

import com.example.twitterclone.exceptions.userWithIdNotFound.UserWithIdNotFoundException;
import com.example.twitterclone.exceptions.userWithUsernameNotFound.UserWithUsernameNotFoundException;
import com.example.twitterclone.exceptions.usernameAlreadyExists.UsernameAlreadyExistsException;
import com.example.twitterclone.exceptions.wrongPasswordForUsername.WrongPasswordForUsernameException;
import com.example.twitterclone.models.Tweet;
import com.example.twitterclone.models.User;
import com.example.twitterclone.repositories.TweetRepository;
import com.example.twitterclone.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

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
        try {
            return userRepository.findById(userId).get();
        } catch (NoSuchElementException e) {
            throw new UserWithIdNotFoundException(userId);
        }
    }

    public User createUser(User user) {
        boolean usernameExists = usernameExists(user.getUsername());
        if (usernameExists) {
            throw new UsernameAlreadyExistsException(user.getUsername());
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
        return tweetRepository.findByUserId(userId);
    }

    public boolean usernameExists(String username) {
        return userRepository.findByUsername(username).size() != 0;
    }

    public List<User> getUsersWithUsername(String username) {
        if (usernameExists(username)) {
            return userRepository.findByUsername(username);
        }
        throw new UserWithUsernameNotFoundException(username);

    }

    public boolean correctPasswordForUsername(String username, String password) {
        String correctPassword = userRepository.findPasswordForUserWithUsername(username);
        if (password.equals(correctPassword)) {
            return true;
        }
        return false;
    }

    public User login(String username, String password) {
        if (!usernameExists(username)) {
            throw new UserWithUsernameNotFoundException(username);
        }
        if (correctPasswordForUsername(username, password)) {
            return getUsersWithUsername(username).get(0);
        }
        throw new WrongPasswordForUsernameException(username);
    }
}
