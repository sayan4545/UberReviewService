package org.example.userreviewservice.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Booking extends BaseModel{
    @OneToOne
    private Review review;
    @Enumerated(value = EnumType.STRING)
    private BookingStatus bookingStatus;
    private Date startTime;
    private Date endTime;
    private Long totalDistance;
}
