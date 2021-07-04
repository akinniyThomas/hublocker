package com.assessment.hublocker.locker;

import org.springframework.stereotype.Service;

@Service
public class LockerService {
    private final LockerRepository lockerRepository;


    public LockerService(LockerRepository lockerRepository) {
        this.lockerRepository = lockerRepository;
    }

    


}
