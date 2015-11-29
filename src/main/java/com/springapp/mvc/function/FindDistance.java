package com.springapp.mvc.function;


public class FindDistance {

    public double findDistance(double lat1, double lon1, double lat2, double lon2){
        double radius = 6371.0;
        double dLat = Math.toRadians(lat2-lat1);
        double sindLat = Math.sin(dLat/2);

        double dLon = Math.toRadians(lon2-lon1);
        double sindLon = Math.sin(dLon/2);

        double a = Math.pow(sindLat,2) + Math.pow(sindLon,2) + Math.cos(Math.toRadians(lat1))*Math.cos(Math.toRadians(lat2));
        double c = 2*Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

        double distance = radius*c;

        return distance;
    }
}
