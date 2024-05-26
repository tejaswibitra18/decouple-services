package com.sap.bulletinboard.ads.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class MockReviewsServiceClient implements ReviewsServiceClient{

	@Override
	public float getAverageRating(String userEmail) {
		return 0;
	}

}
