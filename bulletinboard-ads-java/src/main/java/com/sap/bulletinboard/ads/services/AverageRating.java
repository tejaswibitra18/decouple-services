package com.sap.bulletinboard.ads.services;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AverageRating {
    private Double averageRating;
    
    @JsonProperty("averageRating")
    public Double getAverageRating() {
        return averageRating;
    }

    @JsonProperty("averageRating")
    public void setAverageRating(Double averageRating) {
        this.averageRating = averageRating;
    }
}
