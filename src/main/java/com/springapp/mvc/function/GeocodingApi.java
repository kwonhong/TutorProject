package com.springapp.mvc.function;


import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.GeocoderRequestBuilder;
import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderRequest;
import com.google.code.geocoder.model.GeocoderResult;

import java.io.IOException;
import java.util.List;

public class GeocodingApi {
    final Geocoder geocoder = new Geocoder();
    private GeocoderRequest geocoderRequest;
    private GeocodeResponse geocoderResponse;

    public double getLatitude(String address) throws IOException {
        double lat = 0;
            geocoderRequest = new GeocoderRequestBuilder().setAddress(address).getGeocoderRequest();
            geocoderResponse = geocoder.geocode(geocoderRequest);
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
}




