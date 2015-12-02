package com.springapp.mvc.service;


import com.springapp.mvc.model.Event;
import com.springapp.mvc.model.UserData;

public class BasicFunctions {

    public static double haversine(double lat1, double lon1, double lat2, double lon2) {
        double r = 6372.8;
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        double a = Math.pow(Math.sin(dLat / 2),2) + Math.pow(Math.sin(dLon / 2),2) * Math.cos(lat1) * Math.cos(lat2);
        double c = 2 * Math.asin(Math.sqrt(a));
        return r * c;
    }

    public static String eventAddress(Event event){
        String a = event.getAddress();
        String b = event.getCity();
        String c = event.getCountry();
        String d = event.getPostalCode();

        String address = a + "," + b + "," + c +". " +d;

        return address;
    }

    public static String userAddress (UserData userData){
        String a = userData.getAddress();
        String b = userData.getCity();
        String c = userData.getCountry();
        String d = userData.getPostalcode();
        String address = a + "," + b + "," + c +". " +d;

        return address;
    }
}
