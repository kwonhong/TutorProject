package com.springapp.mvc.model;


import javax.persistence.*;

@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "eventid", nullable = false)
    private int eventid;

    @Column(name = "userid", nullable = false)
    private int userid;

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public int getEventid() {return eventid;}
    public void setEventid(int eventid) {this.eventid = eventid;}

    public int getUserid() {return userid;}
    public void setUserid(int userid) {this.userid = userid;}
}
