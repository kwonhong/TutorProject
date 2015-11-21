package com.springapp.mvc;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;


public class UserData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "password", nullable =  false)
    private String password;

    @Column(name = "userName", nullable = false)
    private String userName;

    @Column(name ="fname", nullable = false)
    private String fname;

    @Column(name ="address", nullable = false)
    private String address;

    @Column(name ="city", nullable = false)
    private String city;

    @Column(name ="postalCode", nullable = false)
    private String postalcode;

    @Column(name ="gender", nullable = false)
    private String gender;

    @Column(name ="lname", nullable = false)
    private String  lname;

    @Column(name ="age", nullable = false)
    private int age;

    @Column(name ="email", nullable = false)
    private String email;

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public String getCity(){ return city;}
    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCity(String city) {this.city = city;}
}
