package org.example.userreviewservice.services;
import org.example.userreviewservice.Models.Review;
import org.example.userreviewservice.repositories.ReviewRepositories;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class ReviewService implements CommandLineRunner {
     ReviewRepositories repositories;
    public ReviewService(ReviewRepositories repositories){
        this.repositories=repositories;
    }
    @Override
    public void run(String... args) throws Exception {
        System.out.println("***************************");

//        Review r = Review.builder()
//                .Content("Amazing ride quality")
//                .rating(5.0)
//                .createdAt(new Date())
//                .updatedAt(new Date())
//                .build();
//
//        repositories.save(r);
//        Review r1 = Review.builder()
//                .Content("Average")
//                .rating(4.0)
//                .createdAt(new Date())
//                .updatedAt(new Date())
//                .build();
//        repositories.save(r1);

//        Review r2 = Review.builder()
//                .Content("Wait time long")
//                .rating(3.0)
//                .createdAt(new Date())
//                .updatedAt(new Date())
//                .build();
//        repositories.save(r2);

        List<Review> review_list = new ArrayList<>();
//        review_list.add(Review.builder()
//                .Content("Great booking")
//                .rating(5.0)
//                .createdAt(new Date())
//                .updatedAt(new Date())
//                .build());
//        review_list.add(Review.builder()
//                .Content("Bad booking")
//                .rating(1.0)
//                .createdAt(new Date())
//                .updatedAt(new Date())
//                .build());
//        repositories.saveAll(review_list);
        review_list.add(Review.builder()
                .Content("Very good service")
                .rating(4.5)
                .createdAt(new Date())
                .updatedAt(new Date())
                .build());
        repositories.saveAll(review_list);
    }
}
