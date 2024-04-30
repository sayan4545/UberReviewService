package org.example.userreviewservice.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Driver extends BaseModel{

    @Column(nullable = false)
    private String driverName;

    @Column(nullable = false,unique = true)
    private String licenseNumber;

    @OneToMany(mappedBy = "driver")
    private List<Booking> bookings = new ArrayList<>();
}