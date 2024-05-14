package org.example.userreviewservice.services;

import org.example.userreviewservice.Models.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {

    public Optional<Review> findReviewById(long id);
    public List<Review> findAllReviews();
    public boolean deleteReviewById(long id);

}
