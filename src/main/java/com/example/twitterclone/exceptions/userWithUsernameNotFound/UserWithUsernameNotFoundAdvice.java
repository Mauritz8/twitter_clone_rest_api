package com.example.twitterclone.exceptions.userWithUsernameNotFound;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class UserWithUsernameNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(UserWithUsernameNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String UserWithUsernameNotFoundHandler(UserWithUsernameNotFoundException ex) {
        return ex.getMessage();
    }
}
