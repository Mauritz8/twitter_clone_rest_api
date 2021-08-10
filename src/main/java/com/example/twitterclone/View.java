package com.example.twitterclone;

public class View {
    public interface AlwaysShowThis {}
    public interface ShowTweetStuff extends AlwaysShowThis {}
    public interface ShowUserStuff extends AlwaysShowThis {}
}
