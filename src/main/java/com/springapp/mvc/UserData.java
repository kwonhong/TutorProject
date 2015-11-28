package com.springapp.mvc;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "userData")
public class UserData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "password", nullable =  false)
    private String password;

    @Column(name = "userName", nullable = false)
    private String userName;

    @Column(name ="firstname", nullable = false)
    private String firstName;

    @Column(name ="address", nullable = false)
    private String address;

    @Column(name ="city", nullable = false)
    private String city;

    @Column(name ="postalCode", nullable = true)
    private String postalCode;

    @Column(name ="gender", nullable = false)
    private String gender;

    @Column(name ="lastname", nullable = false)
    private String  lastName;

    @Column(name ="age", nullable = false)
    private int age;

    @Column(name ="email", nullable = false)
    private String email;

    @Column(name ="geolat", nullable = true)
    private double geolat;

    @Column(name ="geolon", nullable = true)
    private double geolon;

    @Column(name ="country", nullable = false)
    private String country;


    public String getCountry() {return country;}
    public void setCountry(String country) {this.country = country;}

    public double getGeolat() {
        return geolat;
    }
    public void setGeolat(double geolat) {this.geolat = geolat;}

    public double getGeolon() {
        return geolon;
    }
    public void setGeolon(double geolon) {
        this.geolon = geolon;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
