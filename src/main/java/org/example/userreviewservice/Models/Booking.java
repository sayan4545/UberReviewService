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

    @Enumerated(value = EnumType.STRING)
    private BookingStatus bookingStatus;
    private Date startTime;
    private Date endTime;
    private Long totalDistance;

    @ManyToOne(fetch = FetchType.LAZY)
    private Driver driver;
    @ManyToOne(fetch = FetchType.LAZY)
    private Passenger passenger;
}
