package org.example.userreviewservice.Models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Booking extends BaseModel{
    @OneToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.REMOVE
    })
    private Review review;
    @Enumerated(value = EnumType.STRING)
    private BookingStatus bookingStatus;
    private Date startTime;
    private Date endTime;
    private Long totalDistance;

    @ManyToOne
    private Driver driver;
    @ManyToOne
    private Passenger passenger;
}
