package com.example.twitterclone.exceptions.wrongPasswordForUsername;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class WrongPasswordForUsernameAdvice {

    @ResponseBody
    @ExceptionHandler(WrongPasswordForUsernameException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    String WrongPasswordForUsernameHandler(WrongPasswordForUsernameException ex) {
        return ex.getMessage();
    }
}
