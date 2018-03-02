package com.cham.twitterconsumer;

public class TweeterId {

    private long id;

    public TweeterId(long id) {
        this.id = id;
    }

    public TweeterId(){
        // default constructor for JSON deserialization
    }

    public long getId() {
        return id;
    }
}