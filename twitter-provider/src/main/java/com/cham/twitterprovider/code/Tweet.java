package com.cham.twitterprovider.code;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Tweet {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    @NotNull
    private String user;

    @Column
    @NotNull
    private String tweetString;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTweetString() {
        return tweetString;
    }

    public void setTweetString(String tweetString) {
        this.tweetString = tweetString;
    }

    public void updateTweet(Tweet tweet){
        this.user = tweet.getUser();
        this.tweetString = tweet.getTweetString();
    }

}
