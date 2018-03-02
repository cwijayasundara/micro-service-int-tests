package contracts.twitterservice

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description("When a PUT request with a Tweet is made, the updated Tweet ID is returned")
    request {
        method 'PUT'
        url '/tweet-service/tweets/1'
        body(
                user: "Simon",
                tweetString: "Java also rocks"
        )
        headers {
            contentType(applicationJson())
        }
    }
    response {
        status 200
        body(
                id: 1
        )
        headers {
            contentType(applicationJson())
        }
    }
}