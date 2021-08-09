package com.example.twitterclone.exceptions.userNotFound;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Long id) {
        super("Could not find user " + id + "\n");
    }
}
