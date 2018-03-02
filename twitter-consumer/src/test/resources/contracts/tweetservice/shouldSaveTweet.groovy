package contracts.twitterservice

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description("When a POST request with a Tweet is made, the created Tweet ID is returned")
    request {
        method 'POST'
        url '/tweet-service/tweets'
        body(
                user: "Chaminda",
                tweetString: "Scala rocks"
        )
        headers {
            contentType(applicationJson())
        }
    }
    response {
        status 201
        body(
                id: 1
        )
        headers {
            contentType(applicationJson())
        }
    }
}