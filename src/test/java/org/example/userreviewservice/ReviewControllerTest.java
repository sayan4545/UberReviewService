package org.example.userreviewservice;
import org.example.userreviewservice.Controllers.ReviewController;
import org.example.userreviewservice.Models.Review;
import org.example.userreviewservice.adapters.CreateReviewDtoToReviewAdapter;
import org.example.userreviewservice.services.ReviewService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ReviewControllerTest {
    @InjectMocks
    private ReviewController reviewController;
    @Mock
    private ReviewService reviewService;
    @Mock
    private CreateReviewDtoToReviewAdapter createReviewDtoToReviewAdapter;
    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindReviewByIdSuccess(){
        long reviewId = 1l;
        Review mockReview = Review.builder().build();
        mockReview.setId(reviewId);
        //mocking
        when(reviewService.findReviewById(reviewId)).thenReturn(Optional.of(mockReview));
        //test
        ResponseEntity<?> response = reviewController.findReviewById(reviewId);
        assertEquals(HttpStatus.OK,response.getStatusCode());
        Optional<Review> reviewReturned = (Optional<Review>) response.getBody();
        assertEquals(reviewId,reviewReturned.get().getId());
    }
    @Test
    public void testGetAllReviewsSuccess(){
        Review mockReview = Review.builder().build();
        when(reviewService.findAllReviews()).thenReturn(List.of(mockReview));
        ResponseEntity<?> response = reviewController.getAllReviews();
        assertEquals(HttpStatus.OK,response.getStatusCode());
        List<Review> reviewReturned = (List<Review>) response.getBody();
        assertEquals(1,reviewReturned.size());

    }
}
