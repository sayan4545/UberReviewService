package org.example.userreviewservice.services;
import org.example.userreviewservice.Models.BaseModel;
import org.example.userreviewservice.Models.Booking;
import org.example.userreviewservice.Models.BookingStatus;
import org.example.userreviewservice.Models.Review;
import org.example.userreviewservice.repositories.BookingRepository;
import org.example.userreviewservice.repositories.ReviewRepositories;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService implements CommandLineRunner {
    BookingRepository bookingRepository;
    ReviewRepositories repositories;
    public ReviewService(ReviewRepositories repositories, BookingRepository bookingRepository){
        this.repositories=repositories;
        this.bookingRepository = bookingRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        System.out.println("***************************");
//        Review r = Review.builder().Content("Satisfactory").rating(3.0).build();
//        repositories.save(r);
//        Review r1 = Review.builder()
//                .Content("Below Average")
//                .rating(2.0)
//                .build();
//        repositories.save(r1);
//        Review r2 = Review.builder()
//                .Content("Wait time long")
//                .rating(3.0)
//                .createdAt(new Date())
//                .updatedAt(new Date())
//                .build();
//        repositories.save(r2);
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
//        review_list.add(Review.builder()
//                .Content("Very good service")
//                .rating(4.5)
//                .createdAt(new Date())
//                .updatedAt(new Date())
//                .build());
//        repositories.saveAll(review_list);

//        List<Review> reviews = repositories.findAll();
//        for(Review review : reviews){
//            System.out.println(review.getRating());
//        }

//        Review r = Review.builder()
//                .Content("Great ride")
//                .rating(5.0).build();
//
//        Booking b = Booking.builder()
//                .startTime(new Date())
//                        .review(r)
//                                .endTime(new Date())
//                                        .bookingStatus(BookingStatus.COMPLETED)
//                                                .totalDistance(5l)
//                                                        .build();


        Optional<Booking> b = bookingRepository.findById(2l);
        if(b.isPresent()){
            bookingRepository.delete(b.get());
        }


        //repositories.save(r);

        //bookingRepository.save(b);


    }
}
