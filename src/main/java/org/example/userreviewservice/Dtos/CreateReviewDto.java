package org.example.userreviewservice.Dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * DTO for {@link org.example.userreviewservice.Models.Review}
 */
@AllArgsConstructor
@Getter
@Setter
public class CreateReviewDto implements Serializable {
    private  String Content;

    private  Double rating;

    private Long BookingId;
}