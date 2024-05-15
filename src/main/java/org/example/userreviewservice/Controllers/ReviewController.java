package org.example.userreviewservice.Controllers;

import org.example.userreviewservice.Dtos.CreateReviewDto;
import org.example.userreviewservice.Models.Review;
import org.example.userreviewservice.adapters.CreateReviewDtoToReviewAdapter;
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
    private CreateReviewDtoToReviewAdapter createReviewDtoToReviewAdapter;
    public ReviewController(ReviewService reviewService,CreateReviewDtoToReviewAdapter createReviewDtoToReviewAdapter) {
        this.reviewService = reviewService;
        this.createReviewDtoToReviewAdapter = createReviewDtoToReviewAdapter;
    }

    @PostMapping
    public ResponseEntity<?> publishReview(@RequestBody CreateReviewDto request) {
        Review incomingReview = this.createReviewDtoToReviewAdapter.convertDtoToReview(request);
        if(incomingReview==null){
            return new ResponseEntity<>("Invalid arguments",HttpStatus.BAD_REQUEST);
        }
        Review review = this.reviewService.publishReview(incomingReview);
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
