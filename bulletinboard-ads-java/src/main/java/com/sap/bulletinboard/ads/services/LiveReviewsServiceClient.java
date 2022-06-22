package com.sap.bulletinboard.ads.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class LiveReviewsServiceClient implements ReviewsServiceClient {
    private static final String API_PATH = "api/v1";
    private final RestTemplate restTemplate;

    @Value("${REVIEWS_HOST_INTERNAL:}")
    private String reviewsServiceHostInternal;
    @Value("${REVIEWS_HOST:}")
    private String reviewsServiceHost;

    private String determineHost() {
        if (reviewsServiceHostInternal.equals("")) {
            return reviewsServiceHost;
        }
        return reviewsServiceHostInternal;
    }

    public LiveReviewsServiceClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
	public Double getAverageRating(String userEmail) {
        String url = determineHost() + "/" + API_PATH + "/averageRatings/" + userEmail;
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<AverageRating> entity = new HttpEntity<>(headers);
        ResponseEntity<AverageRating> response = restTemplate.exchange(url, HttpMethod.GET, entity, AverageRating.class);
        AverageRating review = response.getBody();
        return review.getAverageRating();
    }
}
