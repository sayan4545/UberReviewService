package org.example.userreviewservice.repositories;

import org.example.userreviewservice.Models.Booking;
import org.example.userreviewservice.Models.Driver;
import org.example.userreviewservice.Models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {
    List<Booking> findAllByDriverId(Long driverId);

    List<Booking> findAllByDriverIn(List<Driver> drivers);
}
