package org.example.userreviewservice.adapters;

import org.example.userreviewservice.Dtos.CreateReviewDto;
import org.example.userreviewservice.Models.Review;

public interface CreateReviewDtoToReviewAdapter {

    public Review convertDtoToReview(CreateReviewDto createReviewDto);
}
