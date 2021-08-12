package com.example.twitterclone.exceptions.wrongPasswordForUsername;

public class WrongPasswordForUsernameException extends RuntimeException {

    public WrongPasswordForUsernameException(String username) {
        super("Wrong password for user " + username + "\n");
    }
}
