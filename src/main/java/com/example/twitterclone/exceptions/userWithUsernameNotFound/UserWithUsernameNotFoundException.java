package com.example.twitterclone.exceptions.userWithUsernameNotFound;

public class UserWithUsernameNotFoundException extends RuntimeException {

    public UserWithUsernameNotFoundException(String username) {
        super("User " + username + " doesn't exist\n");
    }
}
