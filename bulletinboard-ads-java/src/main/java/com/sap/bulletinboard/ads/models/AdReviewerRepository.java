package com.sap.bulletinboard.ads.models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdReviewerRepository extends JpaRepository<AverageRating, String> {
}
