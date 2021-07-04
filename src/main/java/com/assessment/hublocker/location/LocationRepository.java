package com.assessment.hublocker.location;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {

    @Query("Select l from Location l where l.country = ?1 and l.state = ?2 and l.city = ?3")
    Optional<Location> findByCountryAndStateAndCity(String country, String state, String city);
}
