package com.example.twitterclone.models;

import com.example.twitterclone.View;
import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "tweets")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Tweet {

    @Id
    @GeneratedValue
    @JsonView(View.AlwaysShowThis.class)
    private Long id;

    @JsonView(View.AlwaysShowThis.class)
    private String content;

    @JsonView(View.AlwaysShowThis.class)
    private String timeTweeted = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());

    @JsonView(View.AlwaysShowThis.class)
    private Integer amountOfRetweets = 0;

    @JsonView(View.AlwaysShowThis.class)
    private Integer amountOfLikes = 0;

    @JsonView(View.AlwaysShowThis.class)
    private Integer amountOfComments = 0;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonView(View.ShowTweetStuff.class)
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
