package com.cham.twitterconsumer;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfiguration {
    @Bean
    public Logger.Level logLevel(){
        return Logger.Level.FULL;
    }
}
