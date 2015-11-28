package com.springapp.mvc;


import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.GeocoderRequestBuilder;
import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderRequest;
import com.google.code.geocoder.model.GeocoderResult;

import java.io.IOException;
import java.util.List;

public class GeocodingApi {
    final Geocoder geocoder = new Geocoder();

    public double getLatitude(String address) throws IOException {
        double lat = 0;
            GeocoderRequest geocoderRequest = new GeocoderRequestBuilder().setAddress(address).getGeocoderRequest();
            GeocodeResponse geocoderResponse = geocoder.geocode(geocoderRequest);
            List<GeocoderResult> results = geocoderResponse.getResults();
            lat = results.get(0).getGeometry().getLocation().getLat().doubleValue();
        return lat;
    }

    public double getLongitude(String address) throws IOException {
        double lon = 0;
            GeocoderRequest geocoderRequest = new GeocoderRequestBuilder().setAddress(address).getGeocoderRequest();
            GeocodeResponse geocoderResponse = geocoder.geocode(geocoderRequest);
            List<GeocoderResult> results = geocoderResponse.getResults();
            lon = results.get(0).getGeometry().getLocation().getLng().doubleValue();

        return lon;
    }
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




