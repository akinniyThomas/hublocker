package com.assessment.hublocker.locker;

import com.assessment.hublocker.AnObjectResult;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/locker")
public class LockerController {
    private final LockerService lockerService;
    

    public LockerController(LockerService lockerService) {
        this.lockerService = lockerService;
    }
    
    @GetMapping
    public AnObjectResult<Locker> getLockers(){
        return lockerService.getAllLockers();
    }

    @GetMapping("{lockerId}")
    public AnObjectResult<Locker> getALocker(@PathVariable Integer lockerId){
        return lockerService.getOneLocker(lockerId);
    }

    @PostMapping("/location/{locationId}")
    public AnObjectResult<Locker> addLocker(@PathVariable Integer locationId, @RequestBody Locker locker){
        return lockerService.addLocker(locationId, locker);
    }

    @PutMapping("{lockerId}/location/{locationId}/")
    public AnObjectResult<Locker> updateLocker(@PathVariable Integer lockerId, @PathVariable Integer locationId, @RequestBody Locker locker){
        return lockerService.updateLocker(locationId, lockerId, locker);
    }

    @DeleteMapping("{lockerId}")
    public AnObjectResult<Locker> deleteLocker(@PathVariable Integer lockerId){
        return lockerService.deleteLocker(lockerId);
    }
}
