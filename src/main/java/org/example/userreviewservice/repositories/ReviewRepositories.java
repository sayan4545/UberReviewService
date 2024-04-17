package org.example.userreviewservice.repositories;


import org.example.userreviewservice.Models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ReviewRepositories extends JpaRepository<Review,Long> {


}
