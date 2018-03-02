package com.cham.twitterconsumer;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "twitterservice")
public interface TwitterClient {

    @RequestMapping(method = RequestMethod.GET, path = "/tweet-service/tweets/{id}")
    Tweet getTweet(@PathVariable("id") Long id);

    @RequestMapping(method = RequestMethod.PUT, path = "/tweet-service/tweets/{id}")
    Tweet updateTweet(@PathVariable("id") Long id, @RequestBody Tweet tweet);

    @RequestMapping(method = RequestMethod.POST, path = "/tweet-service/tweets")
    TweeterId createTweet(@RequestBody Tweet tweet);

}
