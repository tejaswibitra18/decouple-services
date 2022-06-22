package com.sap.bulletinboard.ads.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.sap.bulletinboard.ads.services.ReviewsServiceClient;

@Primary
@Component
public class MockReviewsServiceClient implements ReviewsServiceClient{

	@Override
	public Double getAverageRating(String userEmail) {
		// TODO Auto-generated method stub
		return 0d;
	}

}
