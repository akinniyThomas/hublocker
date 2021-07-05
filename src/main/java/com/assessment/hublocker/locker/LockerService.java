package com.assessment.hublocker.locker;

import javax.transaction.Transactional;

import com.assessment.hublocker.AnObjectResult;
import com.assessment.hublocker.location.Location;
import com.assessment.hublocker.location.LocationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LockerService {
    private final LockerRepository lockerRepository;
    private final LocationService locationService;

    @Autowired
    public LockerService(LockerRepository lockerRepository, LocationService locationService) {
        this.lockerRepository = lockerRepository;
        this.locationService = locationService;
    }

    //gets all lockers
    public AnObjectResult<Locker> getAllLockers(){
        return new AnObjectResult<Locker>().returnObjectResult(lockerRepository.findAll(), true, "");
    }

    //gets one locker
    public AnObjectResult<Locker> getOneLocker(Integer lockerId){
        AnObjectResult<Locker> returnLoc = lockerExists(lockerId);
        if(returnLoc != null) return returnLoc;
        return new AnObjectResult<Locker>().returnObjectResult(lockerRepository.findById(lockerId).get(), true, "");
    }

    //adds locker
    public AnObjectResult<Locker> addLocker(Integer locationId, Locker locker){
        AnObjectResult<Locker> returnLoc = lockerNameExists(locker);
        if(returnLoc != null) return returnLoc;

        AnObjectResult<Location>  location = locationService.getOneLocation(locationId);
        if(location.getSucceeded()) locker.setLocation(location.getResultObjects().get(0));
        else return new AnObjectResult<Locker>().returnObjectResult(false, location.getErrorMessages());

        Locker lockerToAdd = lockerRepository.save(locker);
        return new AnObjectResult<Locker>().returnObjectResult(lockerToAdd, true, "");
    }

    //update locker
    @Transactional
    public AnObjectResult<Locker> updateLocker(Integer locationId, Integer lockerId, Locker locker){
        AnObjectResult<Locker> returnLoc = lockerNameExists(locker);
        if(returnLoc != null) return returnLoc;
        returnLoc = lockerExists(lockerId);
        if(returnLoc != null) return returnLoc;

        AnObjectResult<Location>  location = locationService.getOneLocation(locationId);
        if(location.getSucceeded()) locker.setLocation(location.getResultObjects().get(0));
        else return new AnObjectResult<Locker>().returnObjectResult(false, location.getErrorMessages());

        Locker lockerToUpdate = lockerRepository.findById(lockerId).get();
        lockerToUpdate.setIsRented(locker.getIsRented());
        lockerToUpdate.setLockerName(locker.getLockerName());
        lockerToUpdate.setLocation(locker.getLocation());
        lockerToUpdate.setDepth(locker.getDepth());
        lockerToUpdate.setWidth(locker.getWidth());
        lockerToUpdate.setHeight(locker.getHeight());
        lockerToUpdate.setPrice(locker.getPrice());

        return new AnObjectResult<Locker>().returnObjectResult(lockerToUpdate, true, "");
    }

    //delete locker
    public AnObjectResult<Locker> deleteLocker(Integer lockerId){
        return null;
    }

    //checks if locker already exists
    public AnObjectResult<Locker> lockerExists(Integer lockerId){
        if(!lockerRepository.existsById(lockerId)) return new AnObjectResult<Locker>().returnObjectResult(false, "No such locker exists!");
        return null;
    }

    //checks if lockerName already exists
    public AnObjectResult<Locker> lockerNameExists(Locker locker){
        if(locker == null) new AnObjectResult<Locker>().returnObjectResult(false, "A locker data passed is empty!");
        if(lockerRepository.findByLockerName(locker.getLockerName()).isPresent()) 
        return new AnObjectResult<Locker>().returnObjectResult(false, "A Locker with this name already exists!");
        return null;
    }
}
