package com.assessment.hublocker.location;

import javax.transaction.Transactional;

import com.assessment.hublocker.AnObjectResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {
    private final LocationRepository locationRepository;

    @Autowired
    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    //gets all locations
    public AnObjectResult<Location> getAllLocations(){
        return new AnObjectResult<Location>().returnObjectResult(locationRepository.findAll(), true, "");
    }

    //gets one location
    public AnObjectResult<Location> getOneLocation(Integer locationId){
        AnObjectResult<Location> returnLoc = locationExists(locationId);
        if(returnLoc != null) return returnLoc;
        return new AnObjectResult<Location>().returnObjectResult(locationRepository.findById(locationId).get(), true, "");
    }

    //adds a new Location
    public AnObjectResult<Location> addLocation(Location location){
        AnObjectResult<Location> returnLoc = countryExists(location);
        if(returnLoc!=null) return returnLoc;
        
        Location loc = locationRepository.save(location);
        return new AnObjectResult<Location>().returnObjectResult(loc, true, "");
    }

    @Transactional
    public AnObjectResult<Location> updateLocation(Integer locationId, Location location){
        AnObjectResult<Location> returnLoc = locationExists(locationId);
        if(returnLoc != null) return returnLoc;

        returnLoc = countryExists(location);
        if(returnLoc!=null) return returnLoc;

        Location locationToUpdate = locationRepository.findById(locationId).get();
        locationToUpdate.setCity(location.getCity());
        locationToUpdate.setCountry(location.getCountry());
        locationToUpdate.setState(location.getState());

        return new AnObjectResult<Location>().returnObjectResult(location, true, "");
    }

    //delete location
    public AnObjectResult<Location> deleteLocation(Integer locationId){
        return null;
    }

    //checks if location already exists
    public AnObjectResult<Location> locationExists(Integer locationId){
        if(!locationRepository.existsById(locationId)) return new AnObjectResult<Location>().returnObjectResult(false, "No such location exists!");
        return null;
    }

    //checks if country already exists
    public AnObjectResult<Location> countryExists(Location location){
        if(location == null) 
        return new AnObjectResult<Location>().returnObjectResult(false, "The location data passed is empty!");
        if(locationRepository.findByCountry(location.getCountry()).isPresent()) 
        return new AnObjectResult<Location>().returnObjectResult(false, "This Country already exists!");
        return null;
    }

}
