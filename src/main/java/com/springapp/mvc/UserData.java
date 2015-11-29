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
    private String username;

    @Column(name ="firstname", nullable = false)
    private String firstname;

    @Column(name ="address", nullable = false)
    private String address;

    @Column(name ="city", nullable = false)
    private String city;

    @Column(name ="postalCode", nullable = true)
    private String postalcode;

    @Column(name ="gender", nullable = false)
    private String gender;

    @Column(name ="lastname", nullable = false)
    private String  lastname;

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
    public void setPassword(String password) {this.password = password;}

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstName) {
        this.firstname = firstName;
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

    public String getPostalcode() {
        return postalcode;
    }
    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
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
