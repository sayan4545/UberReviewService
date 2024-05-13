package org.example.userreviewservice.repositories;


import org.example.userreviewservice.Models.Driver;
import org.example.userreviewservice.Models.Passenger;
import org.example.userreviewservice.Models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository

public interface ReviewRepositories extends JpaRepository<Review,Long> {

    Integer countAllByRatingIsLessThan(Integer givenRating);
    List<Review> findAllByRatingIsLessThanEqual(Integer givenRating);
    List<Review> findAllByCreatedAtBefore(Date date);
    @Query(nativeQuery = true,value = "select * from booking b inner join uber_db_local.booking_review br on b.review_id = br.id where b.id=:bookingId")
    Review findByBookingId(Long bookingId);






}
class Custom{
    public Driver driver;
    public Passenger passenger;
    public Review review;
    public Custom(Driver driver, Passenger passenger, Review review) {
        this.driver = driver;
        this.passenger = passenger;
        this.review = review;
    }

}
