package com.example.twitterclone.models;

import com.example.twitterclone.View;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.None.class)
public class User {

    @Id
    @GeneratedValue
    @JsonView(View.AlwaysShowThis.class)
    private Long id;

    @JsonView(View.AlwaysShowThis.class)
    private String username;

    @JsonView(View.AlwaysShowThis.class)
    private String displayName;

    @JsonView(View.AlwaysShowThis.class)
    private String password;

    @JsonView(View.AlwaysShowThis.class)
    private String profilePic = "https://hips.hearstapps.com/digitalspyuk.cdnds.net/17/13/1490989105-twitter1.jpg?resize=45:*";

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "user")
    @JsonView(View.ShowUserStuff.class)
    private List<Tweet> tweets;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, String profilePic) {
        this.username = username;
        this.password = password;
        this.profilePic = profilePic;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public List<Tweet> getTweets() {
        return tweets;
    }

    public void setTweets(List<Tweet> tweets) {
        this.tweets = tweets;
    }

    public void addTweet(Tweet tweet) {
        tweets.add(tweet);
        tweet.setUser(this);
    }

    public void removeTweet(Tweet tweet) {
        tweets.remove(tweet);
        tweet.setUser(null);
    }
}
