package com.example.twitterclone.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "tweets")
public class Tweet {

    @Id
    @GeneratedValue
    private Long id;

    private String content;

    private String timeTweeted = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());

    private Integer amountOfRetweets = 0;

    private Integer amountOfLikes = 0;

    private Integer amountOfComments = 0;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties("tweets")
    private User user;

    public Tweet() {
    }

    public Tweet(String content) {
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTimeTweeted() {
        return timeTweeted;
    }

    public void setTimeTweeted(String timeTweeted) {
        this.timeTweeted = timeTweeted;
    }

    public Integer getAmountOfRetweets() {
        return amountOfRetweets;
    }

    public void setAmountOfRetweets(Integer amountOfRetweets) {
        this.amountOfRetweets = amountOfRetweets;
    }

    public Integer getAmountOfLikes() {
        return amountOfLikes;
    }

    public void setAmountOfLikes(Integer amountOfLikes) {
        this.amountOfLikes = amountOfLikes;
    }

    public Integer getAmountOfComments() {
        return amountOfComments;
    }

    public void setAmountOfComments(Integer amountOfComments) {
        this.amountOfComments = amountOfComments;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tweet )) return false;
        return id != null && id.equals(((Tweet) o).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
