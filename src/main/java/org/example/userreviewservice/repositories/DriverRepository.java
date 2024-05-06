package org.example.userreviewservice.repositories;

import org.example.userreviewservice.Models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver, Long> {
    Optional<Driver> findByIdAndLicenseNumber(long id,String licenseNumber);



}
