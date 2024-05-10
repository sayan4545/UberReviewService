package org.example.userreviewservice.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Passenger extends BaseModel{

    private String PassengerName;
    @OneToMany(mappedBy = "passenger")
    private List<Booking> passengerBookings = new ArrayList<>();

}
