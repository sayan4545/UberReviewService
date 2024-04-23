package org.example.userreviewservice.Models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Booking extends BaseModel{
    @OneToOne
    private Review review;
    @Enumerated(value = EnumType.STRING)
    private BookingStatus bookingStatus;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date startTime;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date endTime;
    private Long totalDistance;
}
