package com.example.twitterclone.exceptions.userWithIdNotFound;

public class UserWithIdNotFoundException extends RuntimeException {

    public UserWithIdNotFoundException(Long id) {
        super("No user with the id " + id + "\n");
    }
}
