package com.sap.bulletinboard.ads.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "ads_reviewer")
public class AverageRating {

    @NotBlank
    @Id
    private String reviweeEmail;

    private float averageRating;

    public String getReviweeEmail() {
        return reviweeEmail;
    }

    public void setReviweeEmail(String contact) {
        this.reviweeEmail = contact;
    }

    public float getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(float averageRating) {
        this.averageRating = averageRating;
    }
}