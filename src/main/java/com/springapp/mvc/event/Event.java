package com.springapp.mvc.event;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by honkwon on 15-11-21.
 */

@Entity
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name ="name", nullable = false)
    private String name;

    @Column(name ="address", nullable = false)
    private String address;

    @Column(name ="city", nullable = false)
    private String city;

    @Column(name ="postalCode", nullable = false)
    private String postalCode;

    @Column(name ="gender", nullable = false)
    private String gender;

    @Column(name ="date", nullable = false)
    private Date date;

    @Column(name ="minimumAge", nullable = false)
    private int minimumAge;

    @Column(name ="maximumAge", nullable = false)
    private int maximumAge;

    @Column(name ="numParticipants", nullable = false)
    private int numParticipants;

    @Column(name ="capacity", nullable = false)
    private int capacity;

    @Column(name ="Description", nullable = false)
    private String Description;




}
