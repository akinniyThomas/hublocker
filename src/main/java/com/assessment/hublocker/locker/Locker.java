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

    @Column(name="height", nullable = false)
    private Integer height;

    @Column(name="width", nullable = false)
    private Integer width;

    @Column(name="depth", nullable = false)
    private Integer depth;

    @Column(name="price", nullable = false)
    private Double price;

    public Locker() {
    }

    public Locker(String lockerName, Boolean isRented, Location location, Integer height, Integer width, Integer depth, Double price) {
        this.lockerName = lockerName;
        this.isRented = isRented;
        this.location = location;
        this.depth = depth;
        this.width = width;
        this.height = height;
        this.price = price;
    }

    public Integer getId() {
        return this.id;
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

    public Integer getHeight() {
        return this.height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return this.width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getDepth() {
        return this.depth;
    }

    public void setDepth(Integer depth) {
        this.depth = depth;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", lockerName='" + getLockerName() + "'" +
            ", isRented='" + getIsRented() + "'" +
            ", location='" + getLocation() + "'" +
            ", height='" + getHeight() + "'" +
            ", width='" + getWidth() + "'" +
            ", depth='" + getDepth() + "'" +
            ", price='" + getPrice() + "'" +
            "}";
    }
    

}
