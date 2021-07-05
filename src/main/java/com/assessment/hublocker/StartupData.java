package com.assessment.hublocker;

import com.assessment.hublocker.location.Location;
import com.assessment.hublocker.location.LocationRepository;
import com.assessment.hublocker.locker.Locker;
import com.assessment.hublocker.locker.LockerRepository;

import org.springframework.stereotype.Service;

@Service
public class StartupData {
    private final LockerRepository lockerRepository;
    private final LocationRepository locationRepository;


    public StartupData(LockerRepository lockerRepository, LocationRepository locationRepository) {
        this.lockerRepository = lockerRepository;
        this.locationRepository = locationRepository;
    }

    public void LoadData(){

        
        Location locationOne = new Location("Lekki","Lagos","Nigeria","No. 32. Gbodo opposite sugar street", Integer.valueOf(4));
        Location locationTwo = new Location("Costain","Lagos","Nigeria", "Ebute-meta store next to camera", Integer.valueOf(5));
        Location locationThree = new Location("Bergar","Lagos","Nigeria","Julius Bergar Complex beside Lasoro street", Integer.valueOf(4));
        Location locationFour = new Location("Ibadan","Oyo","Nigeria","Gimo Oyo State Town Center", Integer.valueOf(4));
        Location locationFive = new Location("Abeokuta","Ogun","Nigeria", "Abeokuta Stone cold region of coldness", Integer.valueOf(3));
        
        locationOne = locationRepository.save(locationOne);
        locationTwo = locationRepository.save(locationTwo);
        locationThree = locationRepository.save(locationThree);
        locationFour = locationRepository.save(locationFour);
        locationFive = locationRepository.save(locationFive);

        

        Locker lockerOne = new Locker("Lekki_Lagos_1", Boolean.valueOf(false), locationOne, Integer.valueOf(50), Integer.valueOf(50), Integer.valueOf(50), Double.valueOf(50));
        Locker lockerTwo = new Locker("Lekki_Lagos_2", Boolean.valueOf(false), locationOne, Integer.valueOf(50), Integer.valueOf(50), Integer.valueOf(50), Double.valueOf(50));

        Locker lockerThree = new Locker("Costain_Lagos_1", Boolean.valueOf(false), locationTwo, Integer.valueOf(50), Integer.valueOf(50), Integer.valueOf(50), Double.valueOf(50));

        Locker lockerFour = new Locker("Bergar_Lagos_1", Boolean.valueOf(false), locationThree, Integer.valueOf(50), Integer.valueOf(50), Integer.valueOf(50), Double.valueOf(50));
        Locker lockerFive = new Locker("Bergar_Lagos_2", Boolean.valueOf(false), locationThree, Integer.valueOf(50), Integer.valueOf(50), Integer.valueOf(50), Double.valueOf(50));
        Locker lockerSix = new Locker("Bergar_Lagos_3", Boolean.valueOf(false), locationThree, Integer.valueOf(50), Integer.valueOf(50), Integer.valueOf(50), Double.valueOf(50));
        Locker lockerSeven = new Locker("Bergar_Lagos_4", Boolean.valueOf(false), locationThree, Integer.valueOf(50), Integer.valueOf(50), Integer.valueOf(50), Double.valueOf(50));

        Locker lockerEight = new Locker("Ibadan_Oyo_1", Boolean.valueOf(false), locationFour, Integer.valueOf(50), Integer.valueOf(50), Integer.valueOf(50), Double.valueOf(50));

        Locker lockerNine = new Locker("Abeokuta_Ogun_1", Boolean.valueOf(false), locationFive, Integer.valueOf(50), Integer.valueOf(50), Integer.valueOf(50), Double.valueOf(50));
        Locker lockerTen = new Locker("Abeokuta_Ogun_2", Boolean.valueOf(false), locationFive, Integer.valueOf(50), Integer.valueOf(50), Integer.valueOf(50), Double.valueOf(50));

        lockerRepository.save(lockerOne);
        lockerRepository.save(lockerTwo);
        lockerRepository.save(lockerThree);
        lockerRepository.save(lockerFour);
        lockerRepository.save(lockerFive);
        lockerRepository.save(lockerSix);
        lockerRepository.save(lockerSeven);
        lockerRepository.save(lockerEight);
        lockerRepository.save(lockerNine);
        lockerRepository.save(lockerTen);
    }

}
