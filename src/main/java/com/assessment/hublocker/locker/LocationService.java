package com.assessment.hublocker.locker;

import com.assessment.hublocker.location.LocationRepository;

import org.springframework.stereotype.Service;

@Service
public class LocationService {
    private final LocationRepository locationRepository;


    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

}
