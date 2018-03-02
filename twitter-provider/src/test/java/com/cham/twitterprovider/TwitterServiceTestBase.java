package com.cham.twitterprovider;

import com.cham.twitterprovider.code.Tweet;
import com.cham.twitterprovider.code.TweetRepository;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TwitterProviderApplication.class)
public abstract class TwitterServiceTestBase {

	@Test
	public void contextLoads() {
	}

	@Autowired
	WebApplicationContext webApplicationContext;

	@MockBean
	private TweetRepository tweetRepository;

	@Before
	public void setup() {
        Tweet savedTweet = new Tweet();
        savedTweet.setUser("Chaminda");
        savedTweet.setTweetString("Scala Rocks");
        savedTweet.setId(1L);
        when(tweetRepository.save(any(Tweet.class))).thenReturn(savedTweet);
        RestAssuredMockMvc.webAppContextSetup(webApplicationContext);
        when(tweetRepository.findOne(eq(1L))).thenReturn(savedTweet);
	}
}
