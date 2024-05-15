package org.example.userreviewservice.adapters;

import org.example.userreviewservice.Dtos.CreateReviewDto;
import org.example.userreviewservice.Models.Booking;
import org.example.userreviewservice.Models.Review;
import org.example.userreviewservice.repositories.BookingRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class CreateReviewDtoToReviewAdapterImpl implements CreateReviewDtoToReviewAdapter{

    private BookingRepository bookingRepository;
    public CreateReviewDtoToReviewAdapterImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }
    @Override
    public Review convertDtoToReview(CreateReviewDto createReviewDto) {
        Optional<Booking> booking = bookingRepository.findById(createReviewDto.getBookingId());
        return booking.map(value -> Review.builder()
                .rating(createReviewDto.getRating())
                .Content(createReviewDto.getContent())
                .booking(value).build())
                .orElse(null);
    }
}
