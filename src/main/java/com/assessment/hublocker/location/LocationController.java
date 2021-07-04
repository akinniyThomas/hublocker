package com.assessment.hublocker.location;

import com.assessment.hublocker.AnObjectResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/location")
public class LocationController {

    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService){
        this.locationService = locationService;
    }

    @GetMapping
    public AnObjectResult<Location> getLocations(){
        return locationService.getAllLocations();
    }

    @GetMapping("{locationId}")
    public AnObjectResult<Location> getLocation(@PathVariable Integer locationId){
        return locationService.getOneLocation(locationId);
    }

    @PostMapping
    public AnObjectResult<Location> addLocation(@RequestBody Location location){
        return locationService.addLocation(location);
    }

    @PutMapping("{locationId}")
    public AnObjectResult<Location> updateLocation(@PathVariable Integer locationId, @RequestBody Location location){
        return locationService.updateLocation(locationId, location);
    }

    @DeleteMapping("{locationId}")
    public AnObjectResult<Location> deleteLocation(@PathVariable Integer locationId){
        return locationService.deleteLocation(locationId);
    }
}
