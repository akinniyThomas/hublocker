package com.assessment.hublocker.locker;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.assessment.hublocker.location.Location;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "lockers")
public class Locker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="lockerName", unique = true, nullable = false)
    private String lockerName;
    
    @Column(name="isRented")
    private Boolean isRented;

    @ManyToOne
    @JoinColumn(name = "locationId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Location location;


    public Locker() {
    }

    public Locker(String lockerName, Boolean isRented, Location location) {
        this.lockerName = lockerName;
        this.isRented = isRented;
        this.location = location;
    }

    public String getLockerName() {
        return this.lockerName;
    }

    public void setLockerName(String lockerName) {
        this.lockerName = lockerName;
    }

    public Boolean getIsRented() {
        return this.isRented;
    }

    public void setIsRented(Boolean isRented) {
        this.isRented = isRented;
    }
    

    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "{" +
            " lockerName='" + getLockerName() + "'" +
            ", location='" + getLocation() + "'" +
            "}";
    }

}
