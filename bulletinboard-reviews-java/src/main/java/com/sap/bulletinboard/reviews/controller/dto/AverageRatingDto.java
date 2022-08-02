package com.sap.bulletinboard.reviews.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AverageRatingDto {
    Number averageRating;

    public AverageRatingDto() {
    }

    public AverageRatingDto(Number averageRating) {
        this.averageRating = averageRating;
    }

    @JsonProperty("averageRating")
    public Number getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(Number averageRating) {
        this.averageRating = averageRating;
    }
}
