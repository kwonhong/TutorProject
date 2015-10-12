package com.springapp.mvc;

import lombok.Data;

import java.util.Date;

/**
 * Created by honkwon on 15-10-12.
 */
@Data
public class SoccerEvent {
    private String title;
    private String description;

    private Date startTime;
    private Date endTime;

    private SoccerEventType soccerEventType;
    private Address address;

    private int minimumAge;
    private int maximumAge;

    private int capacity;
    private int numParticipants;

}
