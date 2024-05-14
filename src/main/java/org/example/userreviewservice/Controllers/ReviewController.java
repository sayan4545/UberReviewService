package org.example.userreviewservice.Controllers;

import org.example.userreviewservice.Models.Review;
import org.example.userreviewservice.services.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    private ReviewService reviewService;
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    public ResponseEntity<Review> publishReview(@RequestBody Review request) {
        Review review = this.reviewService.publishReview(request);
        return new ResponseEntity<>(review, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews() {
        List<Review> reviews = this.reviewService.findAllReviews();
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }
    @GetMapping("/{reviewId}")
    public ResponseEntity<?> getReview(@PathVariable long reviewId) {
        try{
            Optional<Review> review = this.reviewService.findReviewById(reviewId);
            return new ResponseEntity<>(review, HttpStatus.OK);

        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }
    @GetMapping("/{Id}")
    public ResponseEntity<?> deleteReview(@PathVariable long Id) {
        try{
            boolean isDeleted = this.reviewService.deleteReviewById(Id);
            if(!isDeleted){
                return new ResponseEntity<>("Unable to delete review",HttpStatus.INTERNAL_SERVER_ERROR);
            }
            return new ResponseEntity<>("Response deleted succesfully", HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
