package com.sap.bulletinboard.reviews.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReviewDto {
    private String revieweeEmail;
    private String reviewerEmail;
    private Integer rating;
    private String comment;

    @JsonProperty("revieweeEmail")
    public String getRevieweeEmail() {
        return revieweeEmail;
    }

    @JsonProperty("revieweeEmail")
    public void setRevieweeEmail(String revieweeEmail) {
        this.revieweeEmail = revieweeEmail;
    }

    @JsonProperty("reviewerEmail")
    public String getReviewerEmail() {
        return reviewerEmail;
    }

    @JsonProperty("reviewerEmail")
    public void setReviewerEmail(String reviewerEmail) {
        this.reviewerEmail = reviewerEmail;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
