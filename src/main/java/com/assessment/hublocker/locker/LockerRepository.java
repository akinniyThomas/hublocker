package com.assessment.hublocker.locker;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LockerRepository extends JpaRepository<Locker, Integer> {
    Optional<Locker> findByLockerName(String lockerName);
}
