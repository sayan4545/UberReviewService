package org.example.userreviewservice.Dtos;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewDto {
    private long id;
    private String content;
    private Double rating;
    private long Booking;
    private Date createdAt;
    private Date updatedAt;

}
