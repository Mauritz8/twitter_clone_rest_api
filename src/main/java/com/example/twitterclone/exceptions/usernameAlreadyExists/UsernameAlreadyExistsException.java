package com.example.twitterclone.exceptions.usernameAlreadyExists;

public class UsernameAlreadyExistsException extends RuntimeException {

    public UsernameAlreadyExistsException(String username) {
        super("There already exists a user with the username " + username + "\n");
    }
}
