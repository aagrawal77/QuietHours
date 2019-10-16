package com.example.quiethours;

import android.os.Bundle;

import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.libraries.places.api.model.Place;

import java.util.ArrayList;

public class GeoFencing {
    public ArrayList<Geofence> geofenceList;

    public void createGeofence(Place place){
        geofenceList.add(new Geofence.Builder()
                // Set the request ID of the geofence. This is a string to identify this
                // geofence.
                .setRequestId(place.getId())

                .setCircularRegion(
                        place.getLatLng().latitude,
                        place.getLatLng().longitude,
                        100
                ).build());
    }
}

