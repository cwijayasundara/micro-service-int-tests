package com.cham.twitterprovider.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class TweetController {

    private TweetRepository tweetRepository;

    @Autowired
    public TweetController(TweetRepository tweetRepository) {
        this.tweetRepository = tweetRepository;
    }

    @PostMapping(path = "/tweet-service/tweets")
    public ResponseEntity<TweeterId> createTweet(@RequestBody @Valid Tweet tweet) {
        System.out.println("inside the TweetController.createTweet()");
        Tweet savedTweet = this.tweetRepository.save(tweet);
        return ResponseEntity
                .status(201)
                .body(new TweeterId(savedTweet.getId()));
    }

    @PutMapping(path = "/tweet-service/tweets/{id}")
    public ResponseEntity<Tweet> updateTweet(@RequestBody @Valid Tweet tweet, @PathVariable long id) {
        System.out.println("inside the TweetController.updateTweet()");
        Tweet tweetFromDB = tweetRepository.findOne(id);
        tweetFromDB.updateTweet(tweet);
        tweetFromDB = tweetRepository.save(tweetFromDB);
        return ResponseEntity.ok(tweetFromDB);
    }

    @GetMapping(path = "/tweet-service/tweets/{id}")
    public ResponseEntity<Tweet> getTweet(@PathVariable("id") Long id) {
        System.out.println("inside the TweetController.getTweet()");
        return ResponseEntity.ok(tweetRepository.findOne(id));
    }

}
