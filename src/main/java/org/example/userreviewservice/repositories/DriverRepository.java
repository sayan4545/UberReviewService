package org.example.userreviewservice.repositories;

import org.example.userreviewservice.Models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver, Long> {
   // Optional<Driver> findByIdAndLicenseNumber(long id,String licenseNumber);
    @Query(nativeQuery = true,value = "select * from driver where id =:id and license_number =:licenseNumber")
    Optional<Driver> rawFindByIdAndLicenseNumber(Long id, String licenseNumber);

    //hibernate query
    @Query("SELECT d FROM Driver AS d  WHERE d.id =:id AND d.driverName =:name")
    Optional<Driver> hqlFindByIdAndName(Long id, String name);

    List<Driver> findAllByIdIn(List<Long> id);



}
