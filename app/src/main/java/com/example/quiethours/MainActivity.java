package com.example.quiethours;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.widget.AutocompleteSupportFragment;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvPlaces;
    Button btnDone;
    PlaceAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvPlaces = findViewById(R.id.rvPlaces);
        btnDone = findViewById(R.id.btnDone);
        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // send intent with adapter.places over to the geofencing page, where the geofences will be made
            }
        });
        Places.initialize(getApplicationContext(), " ");

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvPlaces.setLayoutManager(layoutManager);
        adapter = new PlaceAdapter(this, new ArrayList<Place>());
        rvPlaces.setAdapter(adapter);

        AutocompleteSupportFragment autocompleteSupportFragment = (AutocompleteSupportFragment) getSupportFragmentManager().findFragmentById(R.id.autocomplete_fragment);
        autocompleteSupportFragment.setPlaceFields(Arrays.asList(Place.Field.ID, Place.Field.NAME));
        autocompleteSupportFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {
                adapter.places.add(place);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onError(Status status) {
                Log.i("XYZ", "status");
            }
        });

    }


}
