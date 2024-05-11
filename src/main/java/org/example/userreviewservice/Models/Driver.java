package org.example.userreviewservice.Models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Driver extends BaseModel{

    private String phoneNumber;

    @Column(nullable = false)
    private String driverName;

    @Column(nullable = false,unique = true)
    private String licenseNumber;

    @OneToMany(mappedBy = "driver",fetch = FetchType.LAZY)
    @Fetch(value = FetchMode.JOIN)
    private List<Booking> bookings = new ArrayList<>();

}