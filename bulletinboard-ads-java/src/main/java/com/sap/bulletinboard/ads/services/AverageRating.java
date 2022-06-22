package com.sap.bulletinboard.ads.services;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AverageRating {
    private Double averageRating;
    
    @JsonProperty("average_rating")
    public Double getAverageRating() {
        return averageRating;
    }

    @JsonProperty("average_rating")
    public void setAverageRating(Double averageRating) {
        this.averageRating = averageRating;
    }
}
