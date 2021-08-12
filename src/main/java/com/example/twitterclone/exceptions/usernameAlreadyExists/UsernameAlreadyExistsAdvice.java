package com.example.twitterclone.exceptions.usernameAlreadyExists;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class UsernameAlreadyExistsAdvice {

    @ResponseBody
    @ExceptionHandler(UsernameAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String UsernameAlreadyExistsHandler(UsernameAlreadyExistsException ex) {
        return ex.getMessage();
    }
}
