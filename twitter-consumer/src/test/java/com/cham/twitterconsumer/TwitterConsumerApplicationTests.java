package com.cham.twitterconsumer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureStubRunner(ids = "com.cham.twitterprovider.code:twitter-provider:+:stubs:6565", workOffline = true)

/*
 while running in a CI server set the workOffline= false and
 and in application.yml
 stubrunner:
  http://<<path>>/<repo-name>
*/

public class TwitterConsumerApplicationTests {

	@Autowired
	private TwitterClient twitterClient;

	@Test
	public void contextLoads() {
	}

	@Test
	public void createTweetCompliesToContract() {
		Tweet tweet = new Tweet();
		tweet.setUser("Chaminda");
		tweet.setTweetString("Scala rocks");
		TweeterId id = twitterClient.createTweet(tweet);
		assertThat(id.getId()).isEqualTo(1);
	}
}
