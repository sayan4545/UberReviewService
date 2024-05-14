package org.example.userreviewservice.services;

import org.example.userreviewservice.Models.Review;
import org.example.userreviewservice.repositories.ReviewRepositories;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ReviewServiceImpl implements ReviewService{

    private ReviewRepositories repositories;

    public ReviewServiceImpl(ReviewRepositories repositories) {
        this.repositories = repositories;
    }

    @Override
    public Optional<Review> findReviewById(long id) {
        return repositories.findById(id);
    }

    @Override
    public List<Review> findAllReviews() {
        return repositories.findAll();
    }

    @Override
    public boolean deleteReviewById(long id) {
        try{
            repositories.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
