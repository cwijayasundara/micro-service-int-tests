

## Producer

write the service contracts /src/test/resources/contracts/twitterservice/shouldSaveTweet.groovy
                            /src/test/resources/contracts/twitterservice/shouldUpdateTweet.groovy
These conrcts are in Groovy DSL.

Write a test base class: com.cham.twitterprovider.TwitterServiceTestBase.java

Spring-cloud-contract is going to generate the test classes to extend this based on the Groovy contracts above

* /com/cham/twitterprovider/code/TweetController.java

* run `./gradlew generateContractTests` to generate JUnit tests that validate the controller against the contract 
(twitter-provider/build/generated-test-sources/contracts/org/springframework/cloud/contract/verifier/tests/TwitterserviceTest.java)
* run `./gradlew build` to generate and run the tests


##Gradle Changes:

apply plugin: 'spring-cloud-contract'

buildscript {
  repositories {
    // ...
  }
  dependencies {
    classpath "org.springframework.boot:spring-boot-gradle-plugin:1.5.9.RELEASE"
    classpath "org.springframework.cloud:spring-cloud-contract-gradle-plugin:1.2.2.BUILD-SNAPSHOT"
  }
}

contracts {
	baseClassMappings {
		baseClassMapping(".*twitterservice.*", "com.cham.twitterprovider.TwitterServiceTestBase")
	}
}

test compile:

dependencies {
  // ...
  testCompile('org.codehaus.groovy:groovy-all:2.4.6')
  testCompile("org.springframework.cloud:spring-cloud-starter-contract-verifier:${verifier_version}")
  testCompile("org.springframework.cloud:spring-cloud-contract-spec:${verifier_version}")
  testCompile("org.springframework.boot:spring-boot-starter-test:${springboot_version}")
}

## Consumer

Consumer will connect to the stub producer Spring-Cloud-Contract is going to generate and push to the local Maven repo (.m2/repository)
or to the Nexus repo.

So to enable that stub creation you need to place the below in the Gradle file as below.

apply plugin: 'maven-publish'

    testCompile("org.springframework.cloud:spring-cloud-starter-contract-stub-runner:${verifier_version}")
    testCompile("org.springframework.boot:spring-boot-starter-test:${springboot_version}")

In your consumer test, that connect to the stub server through hte Feign client you need to place the below:

    @AutoConfigureStubRunner(ids = "com.cham.twitterprovider.code:twitter-provider:+:stubs:6565", workOffline = true)
    

##  Disabling Eureka in integration tests

Spring Boot, Spring Cloud (with Netflix OSS) projects normally have Eureka integrated. For integration tests you can disable Eureka look ups as below.

in test/resources/applicaiton.yaml place the below.

eureka:
  client:
    enabled: false
