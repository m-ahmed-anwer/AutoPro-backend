package net.springboot.AutoProbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "service", schema = "autopro")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private long uid;

    public void setUid(long uid) {
        this.uid = uid;
    }

    public long getUid() {
        return uid;
    }

    private String repair;

    private String brand;
    private String model;
    private String yom;
    private String fuel;
    private String transmission;
    private String mileage;
    private String fullName;
    @Column(name = "email", unique = true)
    private String email;
    private String phone;
    private String street;
    private String country;
    private String city;
    private String state;
    private String zip;
    private  boolean status;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getYom() {
        return yom;
    }

    public String getFuel() {
        return fuel;
    }

    public String getTransmission() {
        return transmission;
    }

    public String getMileage() {
        return mileage;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getStreet() {
        return street;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }



    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYom(String yom) {
        this.yom = yom;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }




    public String getRepair() {
        return repair;
    }

    public void setRepair(String repair) {
        this.repair = repair;
    }
}
