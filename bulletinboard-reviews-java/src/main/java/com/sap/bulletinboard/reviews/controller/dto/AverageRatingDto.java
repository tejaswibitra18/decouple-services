package com.sap.bulletinboard.reviews.controller.dto;

public class AverageRatingDto {
    private Number averageRating;
    private String reviweeEmail;


    public AverageRatingDto() {
    }

    public AverageRatingDto(Number averageRating) {
        this.averageRating = averageRating;
    }

    public Number getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(Number averageRating) {
        this.averageRating = averageRating;
    }

    public String getReviweeEmail() {
        return reviweeEmail;
    }

    public void setReviweeEmail(String reviweeEmail) {
        this.reviweeEmail = reviweeEmail;
    }
}
